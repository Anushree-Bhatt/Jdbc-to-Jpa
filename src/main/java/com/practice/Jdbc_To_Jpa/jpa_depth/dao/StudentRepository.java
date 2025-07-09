package com.practice.Jdbc_To_Jpa.jpa_depth.dao;

import com.practice.Jdbc_To_Jpa.jpa_depth.entity.Course;
import com.practice.Jdbc_To_Jpa.jpa_depth.entity.Passport;
import com.practice.Jdbc_To_Jpa.jpa_depth.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class StudentRepository {
    @PersistenceContext
    private EntityManager em;

    private Logger logger = LoggerFactory.getLogger(StudentRepository.class);

    public Student findById(Long id) {
        Student s = em.find(Student.class, id);
        logger.info("student : {}",s);
//        logger.info("student's passport: {}", s.getPassport());
        return s;
    }

    public void save(Student s) {
        //save passport before persisting student obj.
        Passport passport = new Passport("TN23654");
        em.persist(passport);

        s.setPassport(passport);
        em.persist(s);
    }




}
