package com.josuejs23.cruddemoterminal.dao;

import com.josuejs23.cruddemoterminal.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);
    Student findById(int id);
    List<Student> findAll();
    List<Student> findByFirstName(String firstName);
    void update(Student student);
    void delete(int id);
    int deleteAll();
}
