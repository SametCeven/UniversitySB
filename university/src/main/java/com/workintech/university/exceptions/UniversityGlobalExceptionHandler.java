package com.workintech.university.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class UniversityGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<UniversityErrorResponse> handleException(UniversityException universityException){

        UniversityErrorResponse response = new UniversityErrorResponse(
                universityException.getMessage(),
                universityException.getHttpStatus().value(),
                System.currentTimeMillis(),
                LocalDateTime.now());

        return new ResponseEntity<UniversityErrorResponse>(response,universityException.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<UniversityErrorResponse> handleException(Exception exception){

        UniversityErrorResponse response = new UniversityErrorResponse(
                exception.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                System.currentTimeMillis(),
                LocalDateTime.now());

        return new ResponseEntity<UniversityErrorResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);

    }



}
