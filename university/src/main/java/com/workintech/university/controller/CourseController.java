package com.workintech.university.controller;

import com.workintech.university.dto.CoursePatchRequestDto;
import com.workintech.university.dto.CourseResponseDto;
import com.workintech.university.entity.Course;
import com.workintech.university.service.CourseService;
import jakarta.validation.constraints.Positive;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@Slf4j
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseResponseDto> getCourses(){
        log.debug("Getting all courses...");
        return courseService
                .getAll()
                .stream()
                .map((course) -> new CourseResponseDto(
                        course.getName(),
                        course.getCode(),
                        course.getCredit(),
                        course.getDepartment() == null ? "" : course.getDepartment().getName()
                ))
                .toList();
    }

    @GetMapping("/{id}")
    public Course findCourseById(@Positive @PathVariable("id") Long id){
        log.debug("Getting by ID {}...", id);
        return courseService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Course createCourse(@Validated @RequestBody Course course){
        return courseService.create(course);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourse(@Positive @PathVariable("id") Long id){
        courseService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Course replaceOrCreate(@Positive @PathVariable("id") Long id, @Validated @RequestBody Course course){
        return courseService.replaceOrCreate(id, course);
    }

    @PatchMapping("/{id}")
    public Course update(@Positive @PathVariable("id") Long id, @Validated @RequestBody CoursePatchRequestDto coursePatchRequestDto){
        Course course = new Course();
        if(coursePatchRequestDto.getName() != null)
            course.setName(coursePatchRequestDto.getName());
        if(coursePatchRequestDto.getCode() != null)
            course.setCode(coursePatchRequestDto.getCode());
        if(coursePatchRequestDto.getCredit() != null)
            course.setCredit(coursePatchRequestDto.getCredit());

        return courseService.update(id, course);
    }





}
