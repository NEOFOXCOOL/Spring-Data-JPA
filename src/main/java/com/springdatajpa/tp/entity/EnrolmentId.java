package com.springdatajpa.tp.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EnrolmentId implements Serializable {
    private Long student_id;
    private Long cours_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnrolmentId that = (EnrolmentId) o;
        return Objects.equals(student_id, that.student_id) && Objects.equals(cours_id, that.cours_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student_id, cours_id);
    }
}
