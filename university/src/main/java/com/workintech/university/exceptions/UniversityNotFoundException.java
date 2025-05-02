package com.workintech.university.exceptions;

import org.springframework.http.HttpStatus;

public class UniversityNotFoundException extends UniversityException {
    public UniversityNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
