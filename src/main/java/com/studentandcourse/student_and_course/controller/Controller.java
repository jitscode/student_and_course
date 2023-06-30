package com.studentandcourse.student_and_course.controller;

import com.studentandcourse.student_and_course.entity.TIMEANDDATE;
import com.studentandcourse.student_and_course.repository.TIMEANDDATEREPO;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@RestController
public class Controller {
    @Autowired
    TIMEANDDATEREPO repo;

    @GetMapping("/time")
    public String timesave() throws ParseException {
        Date date = new Date();
        System.out.println("System time zone - " + date);
        DateFormat requiredFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        TimeZone timeZone = TimeZone.getTimeZone("Asia/Kolkata");
        requiredFormat.setTimeZone(timeZone);
        System.out.println(timeZone);
        String strCurrentDay = requiredFormat.format(date);
        System.out.println("Date and time in IST converted - " + strCurrentDay);
        Date parse = requiredFormat.parse(strCurrentDay);
        Timestamp timestamp = new Timestamp(parse.getTime());
        TIMEANDDATE timeanddate = new TIMEANDDATE();
        timeanddate.setDateandtime(timestamp);
        repo.save(timeanddate);
        return "Success";
    }
}
