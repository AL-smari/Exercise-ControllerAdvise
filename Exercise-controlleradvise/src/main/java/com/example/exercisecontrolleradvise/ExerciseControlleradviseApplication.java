package com.example.exercisecontrolleradvise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ExerciseControlleradviseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExerciseControlleradviseApplication.class, args);
    }

}
