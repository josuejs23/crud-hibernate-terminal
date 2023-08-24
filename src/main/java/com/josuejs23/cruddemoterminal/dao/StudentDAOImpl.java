package com.josuejs23.cruddemoterminal.dao;

import com.josuejs23.cruddemoterminal.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> studentQuery = entityManager.createQuery("FROM Student ORDER BY firstName", Student.class);
        return studentQuery.getResultList();
    }

    @Override
    public List<Student> findByFirstName(String firstName) {
        TypedQuery<Student> studentQuery = entityManager.createQuery("FROM Student WHERE firstName = :theData ", Student.class);
        studentQuery.setParameter("theData", firstName );
        return studentQuery.getResultList();
    }
}
