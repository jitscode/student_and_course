package com.studentandcourse.student_and_course.repository;

import com.studentandcourse.student_and_course.entity.Student;
import com.studentandcourse.student_and_course.entity.TIMEANDDATE;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TIMEANDDATEREPO extends JpaRepository<TIMEANDDATE, Integer> {
}
