package com.practice.cruddemo.dao;

import com.practice.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImp implements StudentDAO {
    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired // is optional if you have only one constructor
    public StudentDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save method, since we are performing the update in the database we will use the transactional annotation
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
//        entityManager.flush();
    }

    @Override
    public Student findBytId(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
//        create query
        TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);
//        return result query
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
//        create query
        TypedQuery<Student> query = entityManager.createQuery(
                "FROM Student WHERE lastName = :theData", Student.class);
//      set query parameters
        query.setParameter("theData", lastName);
//        return query results

        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
//        retrieve the student
        Student theStudent = entityManager.find(Student.class, id);
//        delete the student
        entityManager.remove(theStudent);

    }

    @Override
    @Transactional
    public int deleteAll() {
        int numsRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numsRowsDeleted;
    }

}


