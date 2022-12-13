package com.springdatajpa.tp.service;

import com.springdatajpa.tp.dao.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
}
