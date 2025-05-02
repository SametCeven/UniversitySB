package com.workintech.university.service;

import com.workintech.university.entity.Course;
import com.workintech.university.exceptions.CourseNotFoundException;
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
        return courseRepository
                .findById(id)
                .orElseThrow(() -> new CourseNotFoundException(id +"li kurs bulunumadı."));
    }

    @Override
    public Course create(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course replaceOrCreate(Long id, Course course) {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        if(optionalCourse.isPresent()){
            course.setId(id);
            return courseRepository.save(course);
        }
        return courseRepository.save(course);
    }

    @Override
    public Course update(Long id, Course course) {
        Course courseToUpdate = courseRepository
                .findById(id)
                .orElseThrow(() -> new CourseNotFoundException(id + "li kurs bulunamadı."));
        if(course.getName() != null) courseToUpdate.setName(course.getName());
        if(course.getCode() != null) courseToUpdate.setCode(course.getCode());
        return courseRepository.save(courseToUpdate);
    }

    @Override
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }
}
