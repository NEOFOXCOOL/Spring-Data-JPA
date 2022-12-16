package com.springdatajpa.tp;

import com.github.javafaker.Faker;
import com.springdatajpa.tp.dao.StudentIdCardRepository;
import com.springdatajpa.tp.dao.StudentRepository;
import com.springdatajpa.tp.entity.Book;
import com.springdatajpa.tp.entity.Cours;
import com.springdatajpa.tp.entity.Student;
import com.springdatajpa.tp.entity.StudentCard;
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
                //books
                student.addBook(new Book("Think and Grow Rich", LocalDateTime.now().minusDays(1)));
                student.addBook(new Book("Spring Data JPA", LocalDateTime.now().minusDays(200)));
                student.addBook(new Book("careless art", LocalDateTime.now().minusDays(360)));

                //courses
            student.enrolCours(new Cours("Computer science","TECH"));
            student.enrolCours(new Cours("Amigos Code Spring Boot","AmigosCode"));
            student.enrolCours(new Cours("Learning PhotoShop","Infographie"));

                StudentCard studentCard = new StudentCard(
                        null,"123456789",student
                );
                student.setStudentCard(studentCard);

                studentRepository.save(student);

                studentRepository.findById(1L).ifPresent(s -> {
                    System.out.println("featch book lazy ...");
                    List<Book> books = student.getBooks();
                    books.forEach(book -> {
                        System.out.println(s.getFirst_name()+" borrwed "+book.getBook_name());
                    });
                });
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
