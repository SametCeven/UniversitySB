package com.workintech.university.service;

import com.workintech.university.entity.Course;
import com.workintech.university.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{

    private CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        if(course.isPresent()) return course.get();
        return null;
    }

    @Override
    public Course create(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteById(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        if(course.isPresent()) courseRepository.deleteById(id);
    }
}
