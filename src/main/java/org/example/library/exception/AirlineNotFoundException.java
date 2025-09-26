package org.example.library.exception;

import java.util.NoSuchElementException;

public class AirlineNotFoundException extends NoSuchElementException {
    public AirlineNotFoundException() {
        super("Airline not found");
    }
}
