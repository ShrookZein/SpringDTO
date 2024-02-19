package com.spring.springdto.service;

import com.spring.springdto.model.Course;
import com.spring.springdto.dto.CourseDTO;
import com.spring.springdto.repository.CourseRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepo courseRepo;
    @Autowired
    private ModelMapper modelMapper;
    public List<CourseDTO> getCourse(){
        List<Course>courses= courseRepo.findAll();
        List<CourseDTO>courseDTOList=new ArrayList<>();
        for(int i=0;i<courses.size();i++){
            CourseDTO courseDTO= modelMapper.map(courses.get(i),CourseDTO.class);
//            CourseDTO courseDTO= new CourseDTO();
//            courseDTO.setId(courses.get(i).getId());
//            courseDTO.setName(courses.get(i).getName());
//            courseDTO.setCost(courses.get(i).getCost());
            courseDTOList.add(courseDTO);
        }
        return courseDTOList;
    }
    public List<Course> getCoursesAfterR(){
        return courseRepo.findAll();
    }
}
