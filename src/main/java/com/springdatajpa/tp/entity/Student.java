package com.springdatajpa.tp.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.management.ConstructorParameters;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @SequenceGenerator(
            name="student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_seqhuence"
    )
    private Long id;
    @Column(
            nullable = false,
            name = "student_first_name"
    )
    private String first_name;
    @Column(
            nullable = false,
            name = "student_last_name"
    )
    private String last_name;
    @Column(
            nullable = false,
            name = "student_password",
            length = 25
    )
    private String password;
    @Column(
            nullable = false,
            name = "student_age"

    )
    private Integer age;
    @Column(
            nullable = false,
            name = "student_email",
            length = 32
    )
    private String email;

    @OneToOne(
            mappedBy = "student",
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.REMOVE
            },
            fetch = FetchType.LAZY
            )
    private StudentCard studentCard;

    @OneToMany(
            mappedBy = "student",
            orphanRemoval = true,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.REMOVE
            },
            fetch = FetchType.LAZY
    )
    private List<Book> books = new ArrayList<>();

    @OneToMany(
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            mappedBy = "student"
    )
    private List<Enrolment> enrolments = new ArrayList<>();

    public Student(
            String first_name,
            String last_name,
            String password,
            Integer age,
            String email
    ){
        this.first_name=first_name;
        this.last_name=last_name;
        this.password=password;
        this.age=age;
        this.email=email;
    }

    //add book to student table
    public void addBook(Book book){
        if(!books.contains(book)){
            this.books.add(book);
            book.setStudent(this);
        }
    }

    //remove book from student table
    public void removeBook(Book book){
        if(books.contains(book)){
            this.books.remove(book);
            book.setStudent(null);
        }
    }

    public void addEnrolment(Enrolment enrolment){
        if(!enrolments.contains(enrolment)){
            enrolments.add(enrolment);
        }
    }
    public void removeEnrolment(Enrolment enrolment){
        enrolments.remove(enrolment);
    }

}
