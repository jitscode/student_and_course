package com.studentandcourse.student_and_course.repository;

import com.studentandcourse.student_and_course.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
