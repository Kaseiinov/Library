package org.example.library.exception;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.library.dto.TicketDto;
import org.example.library.dto.UserDto;
import org.example.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserCredentialsValidator implements ConstraintValidator<ValidUserCredentials, TicketDto> {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean isValid(TicketDto ticketDto, ConstraintValidatorContext context) {
        if (ticketDto.getPassport() == null) {
            return true;
        }

        UserDto userDto = userService.findByPassport(ticketDto.getPassport());
        if (userDto == null) {
            addConstraintViolation(context, "passport", "There is no such passport");
            return false;
        }

        boolean isValid = true;

        if (!userDto.getFirstName().equalsIgnoreCase(ticketDto.getFirstName())) {
            addConstraintViolation(context, "firstName", "First name does not match our records");
            isValid = false;
        }

        if (!userDto.getLastName().equalsIgnoreCase(ticketDto.getLastName())) {
            addConstraintViolation(context, "lastName", "Last name does not match our records");
            isValid = false;
        }

        if (!passwordEncoder.matches(ticketDto.getPassword(), userDto.getPassword())) {
            addConstraintViolation(context, "password", "Password is incorrect");
            isValid = false;
        }

        return isValid;
    }

    private void addConstraintViolation(ConstraintValidatorContext context, String field, String message) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message)
                .addPropertyNode(field)
                .addConstraintViolation();
    }
}