package com.studentandcourse.student_and_course.controller;

import com.studentandcourse.student_and_course.entity.Student;
import com.studentandcourse.student_and_course.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentServices services;

    @PostMapping("/addstudent")
    public Student addStudent(@RequestBody Student student){
        return services.saveStudent(student);
    }
    @GetMapping("student/{id}")
    public Student getStudent(@PathVariable int id){
        return services.getStudent(id);
    }
    @GetMapping("/students")
    public List<Student> getAllStudent(){
        return services.getAllStudents();
    }
    @PutMapping("/updatestudent")
    public Student updateStudent(@RequestBody Student student){
        return services.updateStudent(student);
    }

}
