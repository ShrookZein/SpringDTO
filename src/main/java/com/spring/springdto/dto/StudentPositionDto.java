package com.spring.springdto.dto;

import java.util.ArrayList;
import java.util.List;

public class StudentPositionDto {
    private Long id;
    private String name;
    //نفس اسم ال courses ف كلاس ال student  عشان كدا عمل ماب علطول من غير محتاج لوب ف StudentService
    private List<CourseResponse>courses=new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CourseResponse> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseResponse> courses) {
        this.courses = courses;
    }
}
