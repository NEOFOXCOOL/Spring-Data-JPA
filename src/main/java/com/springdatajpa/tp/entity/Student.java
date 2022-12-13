package com.springdatajpa.tp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(
            nullable = false,
            name = "student_name"
    )
    private String name;
    @Column(
            nullable = false,
            name = "student_password"
    )
    private String password;
    @Column(
            nullable = false,
            name = "student_age"
    )
    private Integer age;
    @Column(
            nullable = false,
            name = "student_email"
    )
    private String email;
}
