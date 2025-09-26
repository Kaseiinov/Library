package org.example.library.service;

import lombok.RequiredArgsConstructor;
import org.example.library.Repository.UserRepository;
import org.example.library.dto.UserDto;
import org.example.library.exception.UserAlreadyExistsException;
import org.example.library.exception.UserNotFoundException;
import org.example.library.model.Role;
import org.example.library.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final PasswordEncoder encoder;

    public void save(UserDto userDto) throws UserAlreadyExistsException {
        boolean isUserExists = userRepository.existsUserByPassport(userDto.getPassport());
        if(isUserExists){
            throw new UserAlreadyExistsException();
        }
        Role role = roleService.findRoleByName("USER");
        User user = convertUserDtoToModel(userDto);
        user.setPassword(encoder.encode(userDto.getPassword()));
        user.setRoles(List.of(role));

        userRepository.save(user);
    }

    public List<UserDto> findAllByBookId(Long bookId) {
        List<User> users = userRepository.findUsersByBookId(bookId);
        return convertToDto(users);
    }

    public List<User> findAllByBookIdModel(Long bookId) {
        return userRepository.findUsersByBookId(bookId);

    }

    public List<UserDto> convertToDto(List<User> users) {
        return users
                .stream()
                .map(u -> UserDto
                        .builder()
                        .id(u.getId())
                        .firstName(u.getFirstName())
                        .lastName(u.getLastName())
                        .password(u.getPassword())
                        .passport(u.getPassport())
                        .enabled(u.getEnabled())
                        .ticket(u.getTicket())
                        .build()
                ).toList();
    }

    public UserDetails loadUserByUsername(String username) throws UserNotFoundException {
        User user = userRepository.findUserByPassport((username)).orElseThrow(UserNotFoundException::new);
        System.out.println(user.getPassport());
        System.out.println(user.getPassword());
        return new org.springframework.security.core.userdetails.User(
                user.getPassport(),
                user.getPassword(),
                user.getAuthorities()
        );
    }

    public User convertUserDtoToModel(UserDto userDto){
        return User.builder()
                .id(userDto.getId())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .passport(userDto.getPassport())
                .password(userDto.getPassword())
                .enabled(true)
                .build();
    }
}
