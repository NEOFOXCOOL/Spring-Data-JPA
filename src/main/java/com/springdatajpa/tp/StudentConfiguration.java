package com.springdatajpa.tp;

import com.github.javafaker.Faker;
import com.springdatajpa.tp.dao.StudentIdCardRepository;
import com.springdatajpa.tp.dao.StudentRepository;
import com.springdatajpa.tp.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class StudentConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository studentRepository,
            StudentIdCardRepository studentIdCardRepository
    ) {
        return  args -> {
                Faker faker = new Faker();
                String firstName = faker.name().firstName();
                String lastName = faker.name().lastName();
                String password = faker.internet().password();
                String email = String.format("%s.%s@gmail.com", firstName, lastName);
                int age = faker.number().numberBetween(17, 55);
                Student student = new Student(
                        firstName,
                        lastName,
                        password,
                        age,
                        email
                );
                student.addBook(new Book("now you se mi",LocalDateTime.now()));
                student.addEnrolment(new Enrolment(student,new Cours("photoshop","INF"),LocalDateTime.now()));
//                //books
//                student.addBook(new Book("Think and Grow Rich", LocalDateTime.now().minusDays(1)));
//                student.addBook(new Book("Spring Data JPA", LocalDateTime.now().minusDays(200)));
//                student.addBook(new Book("careless art", LocalDateTime.now().minusDays(360)));

//                student.addEnrolment(new Enrolment(
//                        new EnrolmentId(1L,1L),
//                        student,
//                        new Cours("Computer science","TECH"),
//                        LocalDateTime.now().minusMonths(3)
//                ));
//                student.addEnrolment(new Enrolment(
//                        new EnrolmentId(2L,3L),
//                        student,
//                        new Cours("Learning PhotoShop","Infographie"),
//                        LocalDateTime.now().minusDays(5)
//                ));


//                StudentCard studentCard = new StudentCard(
//                        null,"123456789",student
//                );
//                student.setStudentCard(studentCard);
//
//                studentRepository.save(student);

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
