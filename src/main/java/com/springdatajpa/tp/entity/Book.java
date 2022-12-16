package com.springdatajpa.tp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity(name = "Book")
@Table(name="book")
public class Book {
    @Id
    @SequenceGenerator(
            name="book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_squence"
    )
    private Long id;
    @Column(
            name = "book_name",
            nullable = false
    )
    private String book_name;
    @Column(
            name = "book_creation",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime created_at;

    @ManyToOne
    @JoinColumn(
        name = "student_id",
        referencedColumnName = "id",
        nullable = false,
        foreignKey = @ForeignKey(
                name = "student_id_fk"
        )
)
    private Student student;

    public Book(
            String book_name,
            LocalDateTime created_at
    ){
        this.book_name = book_name;
        this.created_at = created_at;
    }
}
