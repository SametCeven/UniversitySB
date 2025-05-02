package com.workintech.university.exceptions;

import org.springframework.http.HttpStatus;

public class DepartmentNotFoundException extends UniversityException {
    public DepartmentNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
