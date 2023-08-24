package com.josuejs23.cruddemoterminal.dao;

import com.josuejs23.cruddemoterminal.entity.Student;

public interface StudentDAO {

    void save(Student student);
    Student findById(int id);
}
