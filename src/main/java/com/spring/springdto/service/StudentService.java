package com.spring.springdto.service;

import com.spring.springdto.dto.CourseResponse;
import com.spring.springdto.dto.StudentPositionDto;
import com.spring.springdto.model.Course;
import com.spring.springdto.model.Student;
import com.spring.springdto.dto.StudentDTO;
import com.spring.springdto.dto.StudentResponse;
import com.spring.springdto.repository.CourseRepo;
import com.spring.springdto.repository.StudentRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private ModelMapper modelmapper;
    @Autowired
    private CourseRepo courseRepo;

    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepo.findAll();
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            StudentDTO studentDTO = modelmapper.map(students.get(i), StudentDTO.class);
//            StudentDTO studentDTO= new StudentDTO();
//            studentDTO.setId(students.get(i).getId());
//            studentDTO.setName(students.get(i).getName());
            studentDTOList.add(studentDTO);
        }
        return studentDTOList;
    }

    //    StudentResponse studentResponse =new StudentResponse();
    public StudentResponse getstudent(Long id) {
        Student student = studentRepo.findById(id).get();
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setPhone("01524785455");
        modelmapper.map(student, studentResponse);
//--------------------------------------------------------------------------------
//        StudentResponse studentResponse =new StudentResponse();
//        studentResponse.setName(student.getName());
//--------------------------------------------------------------------------------
        return studentResponse;
    }

    public List<Student> getStudentsAfterR() {
        return studentRepo.findAll();
    }

    public StudentPositionDto getStudentCourses(List<Long>ids) {

        Student student= courseRepo.findStudentByCourseId(ids.get(0));
        StudentPositionDto studentPositionDto=modelmapper.map(student,StudentPositionDto.class);
//---------------------------------------------------------------------------------------
//        studentPositionDto.setName(student.getName());
//        studentPositionDto.setId(student.getId());
//---------------------------------------------------------------------------------------

        List<Course>courses=courseRepo.listCoursesInIds(ids);
        for(int i=0;i<courses.size();i++) {
            CourseResponse courseResponse=modelmapper.map(courses.get(i),CourseResponse.class);
//            courseResponse.setId(courses.get(i).getId());
//            courseResponse.setCost(courses.get(i).getCost());
            studentPositionDto.getCourses().add(courseResponse);
        }
        return studentPositionDto;
    }
}
