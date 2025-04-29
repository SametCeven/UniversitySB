package com.workintech.university.service;

import com.workintech.university.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAll();
    Course findById(Long id);
    Course create(Course course);

    void deleteById(Long id);

}
