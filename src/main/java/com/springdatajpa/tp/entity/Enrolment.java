package com.springdatajpa.tp.entity;

import jakarta.annotation.security.DenyAll;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "Enrolment")
@Table(name = "enrolment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Enrolment {

    @EmbeddedId
    private EnrolmentId id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(
            name = "student_id",
            foreignKey = @ForeignKey(
                    name = "enrolment_student_id_fk"
            )
    )
    private Student student;

    @ManyToOne
    @MapsId("coursId")
    @JoinColumn(
            name = "cours_id",
    foreignKey = @ForeignKey(
            name = "enrolment_cours_id_fk"
    ))
    private Cours cours;

    @Column(
            name = "created_at",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime created_at;

    public Enrolment(
            Student student,
            Cours cours,
            LocalDateTime created_at
            ){
        this.student =student;
        this.cours = cours;
        this.created_at =created_at;
    }

}
