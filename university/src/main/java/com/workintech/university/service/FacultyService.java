package com.workintech.university.service;

import com.workintech.university.entity.Course;
import com.workintech.university.entity.Faculty;

import java.util.List;
import java.util.Optional;

public interface FacultyService {
    List<Faculty> getAll();
    Faculty findById(Long id);
    Faculty create(Faculty faculty);
    Faculty replaceOrCreate(Long id, Faculty faculty);
    Faculty update(Long id, Faculty faculty);
    void deleteById(Long id);
    List<Faculty> searchFacultyByName(String name);
    List<Faculty> searchByFacultyNameOrEmail(String name);
}
