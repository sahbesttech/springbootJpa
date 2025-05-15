package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return  args -> {
            Student saheed = new Student(
                    "Saheed",
                    "saheed@gmail.com",
                    LocalDate.of(1994, Month.FEBRUARY, 19)
            );

            Student kunle = new Student(
                    "Kunle",
                    "Kunle@gmail.com",
                    LocalDate.of(1990, Month.APRIL, 14)
            );

            Student ayinde = new Student(
                    "Ayinde",
                    "Ayinde@gmail.com",
                    LocalDate.of(1990, Month.APRIL, 30));
            Student soyinka = new Student(
                    "soyinka",
                    "soyinka@gmail.com",
                    LocalDate.of(1980, Month.APRIL, 10)
            );

            repository.saveAll(
                    List.of(saheed,kunle,ayinde,soyinka)
            );

        };
    }
}


