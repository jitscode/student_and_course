package com.studentandcourse.student_and_course.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class TIMEANDDATE {
    @Id
    private int id;
    private Date dateandtime;

}
