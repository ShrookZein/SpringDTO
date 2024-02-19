package com.spring.springdto.controller;

import com.spring.springdto.dto.StudentPositionDto;
import com.spring.springdto.model.Student;
import com.spring.springdto.dto.StudentDTO;
import com.spring.springdto.dto.StudentResponse;
import com.spring.springdto.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/allstudent")
    public List<StudentDTO>getAllStudents(){
        return studentService.getAllStudents();
    }
    //http://localhost:8080/student/getstudent?id=...
    @GetMapping("getstudent")
    public StudentResponse getStudent(@RequestParam Long id){
        return studentService.getstudent(id);
    }
    // After Relation between tables in database
    @GetMapping("/allStudentR")
    public List<Student> getAllStudentsAfterR(){
        return studentService.getStudentsAfterR();
    }
    @GetMapping("/student-course")
    public StudentPositionDto getStudentCourses(@RequestParam List<Long>ids){
        return studentService.getStudentCourses(ids);
    }
}
