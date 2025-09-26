package org.example.library.exception;

public class EmailAlreadyExistsException extends Exception {
    public EmailAlreadyExistsException() {
        super("Email already exists");
    }
}
