package com.workintech.university.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UniversityErrorResponse {
    private String message;
    private int status;
    private long timestamp;
    private LocalDateTime localDateTime;
}
