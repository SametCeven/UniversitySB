package com.workintech.university.controller;

import com.workintech.university.entity.Department;
import com.workintech.university.entity.Faculty;
import com.workintech.university.service.DepartmentService;
import com.workintech.university.service.FacultyService;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@Slf4j
@AllArgsConstructor
public class DepartmentController {

    @Autowired
    private final DepartmentService departmentService;

    @GetMapping
    public List<Department> getAll(){
        return departmentService.getAll();
    }

    @GetMapping("/{id}")
    public Department getById(@Positive @PathVariable Long id){
        return departmentService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Department create(@Validated @RequestBody Department department){
        return departmentService.create(department);
    }

    @PutMapping("/{id}")
    public Department replaceOrCreate(@Positive @PathVariable Long id, @Validated @RequestBody Department department){
        return departmentService.replaceOrCreate(id,department);
    }

    @PatchMapping("/{id}")
    public Department update(@Positive @PathVariable Long id, @Validated @RequestBody Department department){
        return departmentService.update(id,department);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@Positive @PathVariable Long id){
        departmentService.deleteById(id);
    }

}
