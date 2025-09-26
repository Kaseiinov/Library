package org.example.library.service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.library.Repository.UserRepository;
import org.example.library.dto.TicketDto;
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
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final PasswordEncoder encoder;

    public void authWithHttpServletRequest(HttpServletRequest request, String passport, String password) {
        try {
            request.login(passport, password);
        } catch (ServletException e) {
            log.error("Error while login ", e);
        }
    }

    public UserDto findByPassport(String passport) {
        User user = userRepository.findByPassport(passport);
        if(user != null) {
            return convertToDto(user);
        }
        return null;
    }

    public String getTicket(TicketDto ticketDto) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String shortId = uuid.substring(0, 5);

        User user = userRepository.findUserByPassport(ticketDto.getPassport()).orElseThrow(UserNotFoundException::new);
        user.setTicket(shortId);
        userRepository.save(user);
        return shortId;
    }

    public void save(UserDto userDto, HttpServletRequest request) throws UserAlreadyExistsException {
        boolean isUserExists = userRepository.existsUserByPassport(userDto.getPassport());
        if(isUserExists){
            throw new UserAlreadyExistsException();
        }
        Role role = roleService.findRoleByName("USER");
        User user = convertUserDtoToModel(userDto);
        user.setPassword(encoder.encode(userDto.getPassword()));
        user.setRoles(List.of(role));

        userRepository.save(user);
        authWithHttpServletRequest(request, userDto.getPassport(), userDto.getPassword());
        log.info("Auto authenticated");
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

    public UserDto convertToDto(User user) {
        return UserDto
                .builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .password(user.getPassword())
                .passport(user.getPassport())
                .enabled(user.getEnabled())
                .ticket(user.getTicket())
                .build();
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
