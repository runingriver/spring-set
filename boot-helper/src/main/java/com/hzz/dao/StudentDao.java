package com.hzz.dao;


import com.hzz.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentDao extends CrudRepository<Student, Long> {
    List<Student> findAll();

    Student findStudentByName(String name);

    long countByName(String name);
}
