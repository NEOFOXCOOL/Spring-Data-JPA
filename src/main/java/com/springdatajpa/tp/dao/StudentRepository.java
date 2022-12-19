package com.springdatajpa.tp.dao;

import com.springdatajpa.tp.entity.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student ,Long> {


    @Query(value = "select * from Student s where s.id = ?1",nativeQuery = true)
    List<Student> findStudentsbyId(Long id);

//Student findStudentByFirst_name(String first_name);

//    @Query("select s from Student s where s.email=?1")
//    Optional<Student> findStudentsByEmail(String email);
//
//@Query("select s from Student  s where s.first_name=?1")
//    List<Student> findStudentByName(String name);
//@Query("select s from  Student s where s.first_name=?1 and  s.age=?2")
//Optional<Student> findStudentByNameEqualsAndAgeEquals(String name,Integer age);
//@Query(value = "SELECT * FROM student where student_name = :studentName and  student_age >= :studentAge",nativeQuery = true)
//Optional<Student> selectStudentwithnameandage(
//        @Param("studentName")String name,
//        @Param("studentAge") Integer age
//);
//@Modifying
//@Query("delete from Student u where u.id = ?1")
//    int deleteStudentById(Long id);
//
//@Query(value = "select * from student order by student_age asc",nativeQuery = true)
//List<Student> findOrderByAgeAsc(Pageable pageable);


}
