package com.springdatajpa.tp.dao;

import com.springdatajpa.tp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student ,Long> {
Optional<Student> findStudentsByEmail(String email);
List<Student> findStudentByName(String name);
Optional<Student> findStudentByNameEqualsAndAgeEquals(String name,Integer age);

}
