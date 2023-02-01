package com.studentandcourse.student_and_course.services;

import com.studentandcourse.student_and_course.entity.Student;
import com.studentandcourse.student_and_course.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServices {

    @Autowired
    private StudentRepository repository;

    public Student saveStudent(Student student){
        return repository.save(student);
    }
    public List<Student> getAllStudents(){
        return repository.findAll();
    }
    public Student getStudent(int id){
        return repository.findById(id).orElse(null);
    }
    public Student updateStudent(Student student){
        Student existing=repository.findById(student.getId()).orElse(null);
        existing.setName(student.getName());
        existing.setId(student.getId());
        existing.setCourse(student.getCourse());
        existing.setSchool(student.getSchool());
        return repository.save(existing);
    }
}
