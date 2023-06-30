package com.studentandcourse.student_and_course.controller;

import com.studentandcourse.student_and_course.entity.Student;
import com.studentandcourse.student_and_course.services.StudentServices;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    Logger logger= LoggerFactory.getLogger(StudentController.class);
    @Autowired
    private StudentServices services;

    @PostMapping("/addstudent")
    public Student addStudent(@Valid @RequestBody Student student){
        logger.info("Student Is Being Added");
                services.saveStudent(student);
        logger.info("Student Added Successfully");
        return student;
    }
    @GetMapping("student/{id}")
    public Student getStudent(@PathVariable int id){
        return services.getStudent(id);
    }
    @GetMapping("/students")
    public List<Student> getAllStudent(){
        logger.info("Getting all students Here");
        return services.getAllStudents();
    }
    @PutMapping("/updatestudent")
    public Student updateStudent(@RequestBody Student student){
        return services.updateStudent(student);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void processData(@RequestBody MultiValueMap<String, String> formData) {
        formData.forEach((key, value) -> System.out.println(key + " : " + value));
    }

}
