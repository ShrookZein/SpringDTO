package com.spring.springdto.controller;

import com.spring.springdto.model.Course;
import com.spring.springdto.dto.CourseDTO;
import com.spring.springdto.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @GetMapping("/allcourse")
    public List<CourseDTO> getCourse(){
        return courseService.getCourse();
    }
    @GetMapping("/allCoursesR")
    public List<Course> getAllCoursesAfterR(){
        return courseService.getCoursesAfterR();
    }
}
