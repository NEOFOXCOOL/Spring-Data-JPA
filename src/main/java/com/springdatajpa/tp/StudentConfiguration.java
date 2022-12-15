package com.springdatajpa.tp;

import com.github.javafaker.Faker;
import com.springdatajpa.tp.dao.StudentRepository;
import com.springdatajpa.tp.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class StudentConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return  args -> {
        generatedRondomStudent(studentRepository);
        Pageable pageable = PageRequest.of(0,5);
            List<Student> page = studentRepository.findOrderByAgeAsc(pageable);
            System.out.println(page);
        };
    }

    private void generatedRondomStudent(StudentRepository studentRepository){
        Faker faker = new Faker();
        for (int i=0;i<20;i++){
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String password = faker.internet().password();
            String email = String.format("%s.%s@gmail.com", firstName, lastName);
            int age = faker.number().numberBetween(17, 55);
            Student student = new Student(
                    null,
                    firstName,
                    lastName,
                    password,
                    age,
                    email
            );
            studentRepository.save(student);
        }
    }
}
