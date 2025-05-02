package com.workintech.university.exceptions;


import org.springframework.http.HttpStatus;

public class FacultyNotFoundException extends UniversityException{

    public FacultyNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
