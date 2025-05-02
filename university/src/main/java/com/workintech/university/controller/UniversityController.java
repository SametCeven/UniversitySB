package com.workintech.university.controller;

import com.workintech.university.entity.Faculty;
import com.workintech.university.entity.University;
import com.workintech.university.service.UniversityService;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/universities")
@AllArgsConstructor
public class UniversityController {

    @Autowired
    private final UniversityService universityService;

    @GetMapping
    public List<University> getAll(){
        return universityService.getAll();
    }

    @GetMapping("/{id}")
    public University getById(@Positive @PathVariable Long id){
        return universityService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public University create(@Validated @RequestBody University university){
        return universityService.create(university);
    }

    @PutMapping("/{id}")
    public University replaceOrCreate(@Positive @PathVariable Long id, @Validated @RequestBody University university){
        return universityService.replaceOrCreate(id,university);
    }

    @PatchMapping("/{id}")
    public University update(@Positive @PathVariable Long id, @Validated @RequestBody University university){
        return universityService.update(id,university);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@Positive @PathVariable Long id){
        universityService.deleteById(id);
    }


}
