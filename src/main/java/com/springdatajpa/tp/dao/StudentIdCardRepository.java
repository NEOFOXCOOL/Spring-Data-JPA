package com.springdatajpa.tp.dao;

import com.springdatajpa.tp.entity.StudentCard;
import org.springframework.data.repository.CrudRepository;

public interface StudentIdCardRepository
        extends CrudRepository<StudentCard,Long> {

}
