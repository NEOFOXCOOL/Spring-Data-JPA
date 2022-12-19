package com.springdatajpa.tp;

import com.springdatajpa.tp.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/info/${id}")
    public void getStudentInfo(@PathVariable("id") Long id){
    }
}
