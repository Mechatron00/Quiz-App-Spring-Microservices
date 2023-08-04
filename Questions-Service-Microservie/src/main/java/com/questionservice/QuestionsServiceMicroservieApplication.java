package com.questionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuestionsServiceMicroservieApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuestionsServiceMicroservieApplication.class, args);
        System.out.println("Questions service working!");
    }


}
