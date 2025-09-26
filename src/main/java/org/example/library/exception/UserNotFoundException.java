package org.example.library.exception;

import java.util.NoSuchElementException;

public class UserNotFoundException extends NoSuchElementException {
    public UserNotFoundException() {
        super("User not found");
    }
}
