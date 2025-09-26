package org.example.library.service;

import lombok.RequiredArgsConstructor;
import org.example.library.Repository.UserRepository;
import org.example.library.dto.UserDto;
import org.example.library.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

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
}
