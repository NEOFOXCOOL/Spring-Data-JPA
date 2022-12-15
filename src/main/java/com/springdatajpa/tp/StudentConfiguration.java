package com.springdatajpa.tp;

import com.github.javafaker.Faker;
import com.springdatajpa.tp.dao.StudentRepository;
import com.springdatajpa.tp.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;

import javax.naming.ldap.SortControl;

@Configuration
public class StudentConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return  args -> {
        generatedRondomStudent(studentRepository);
            System.out.println( Sort.by("first_name").ascending());
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
