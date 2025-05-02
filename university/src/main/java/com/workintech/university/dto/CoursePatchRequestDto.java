package com.workintech.university.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoursePatchRequestDto {

    @Size(max = 150)
    private String name;

    @Size(max = 25)
    private String code;

    private Double credit;


}
