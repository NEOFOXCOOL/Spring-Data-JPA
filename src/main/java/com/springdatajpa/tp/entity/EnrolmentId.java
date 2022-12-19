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
    private Long studentId;
    private Long coursId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnrolmentId that = (EnrolmentId) o;
        return Objects.equals(studentId, that.studentId) && Objects.equals(coursId, that.coursId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, coursId);
    }
}
