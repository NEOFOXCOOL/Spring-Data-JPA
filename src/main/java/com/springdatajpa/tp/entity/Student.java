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

    @ManyToMany(
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE}
    )
    @JoinTable(
            //name of created table
            name = "enrolement",

            //student table join
            joinColumns =
                    @JoinColumn(
                            name = "student_id",
                            foreignKey = @ForeignKey(
                                    name = "enrolement_student_id_fk"
                            )
                    ),

            //cours table join
            inverseJoinColumns =  @JoinColumn(
                    name = "cours_id",
                    foreignKey = @ForeignKey(
                            name = "enrolement_cours_id_fk"
                    )
            )
    )
    private List<Cours> courses = new ArrayList<>();

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

public void enrolCours(Cours cours){
        courses.add(cours);
        cours.getStudents().add(this);
}

public void unEnrolCours(Cours cours){
        courses.remove(cours);
        cours.getStudents().remove(this);
}
}
