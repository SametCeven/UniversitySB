package com.workintech.university.exceptions;

import org.springframework.http.HttpStatus;

public class InstructorNotFoundException extends UniversityException{
    public InstructorNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
