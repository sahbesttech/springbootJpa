package com.example.demo.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {

    public List<Student> getStudents(){
        return List.of(
                new Student(
                        1L,
                        "Saheed",
                        "saheed@gmail.com",
                        LocalDate.of(1994, Month.FEBRUARY,19),
                        31
                ),
                new Student(
                        2L,
                        "Kunle",
                        "Kunle@gmail.com",
                        LocalDate.of(1990, Month.APRIL,14),
                        31
                ),
                new Student(
                        2L,
                        "Ayinde",
                        "Ayinde@gmail.com",
                        LocalDate.of(1990, Month.APRIL,30),
                        31
                )
        );
    }

}
