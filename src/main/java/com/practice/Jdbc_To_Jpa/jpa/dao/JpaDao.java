package com.practice.Jdbc_To_Jpa.jpa.dao;

import com.practice.Jdbc_To_Jpa.jpa.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class JpaDao {

    @PersistenceContext
    EntityManager entityManager;

    public Person findById(Integer id){
        return entityManager.find(Person.class, id);
    }

    public Person save(Person person){
        return entityManager.merge(person);
    }

    public Person update(Person person){
        return entityManager.merge(person);
    }
}
