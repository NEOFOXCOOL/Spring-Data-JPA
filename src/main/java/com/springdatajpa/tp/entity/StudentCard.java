package com.springdatajpa.tp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Studentcard")
@Table(
        name = "studentcard",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = "Student_Id_Card_Number",
                        name = "Student_Id_Card_Number_Unique"
                )
        }
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentCard {
    @Id
    @SequenceGenerator(
            name = "student_id_card_sequence",
            sequenceName = "student_id_card_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_id_card_sequence"
    )
    @Column(
            name = "Student_Id_Card_Id",
            updatable = false
    )
    private  Long id;
    @Column(
            name = "Student_Id_Card_Number",
            nullable = false,
            length = 15
    )
    private String number;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "student_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "student_id_fk"
            )
    )
    private Student student;
}
