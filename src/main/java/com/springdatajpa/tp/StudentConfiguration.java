package com.springdatajpa.tp;

import com.springdatajpa.tp.dao.StudentRepository;
import com.springdatajpa.tp.entity.Student;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@AllArgsConstructor
public class StudentConfiguration {

    private final StudentRepository studentRepository;

    @Bean
    CommandLineRunner commandLineRunner(){
        return  args -> {
            System.out.println("hello world !!");
            Student mariam = new Student(null,"mariam","123",12,"mariam@gmail.com");
            Student mariam2 = new Student(null,"mariam","123",20,"mariam2@gmail.com");
            Student ali = new Student(null,"ali","123",28,"ali@gmail.com");

            studentRepository.saveAll(Arrays.asList(
                    mariam,mariam2,ali
            ));

            studentRepository.findStudentsByEmail("mariam@gmail.com").ifPresentOrElse(
                    System.out::println,() -> System.out.println("student not found")
            );
            studentRepository.findStudentByName("mariam").forEach(System.out::println);
            studentRepository.findStudentByNameEqualsAndAgeEquals("mariam",12);
        };
    }
}
