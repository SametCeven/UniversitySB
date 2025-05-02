package com.workintech.university.exceptions;

import org.springframework.http.HttpStatus;

public class CourseNotFoundException extends UniversityException{
    public CourseNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
