package com.practice.Jdbc_To_Jpa.jpa_depth.dao;

import com.practice.Jdbc_To_Jpa.jpa_depth.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class CourseRepository {
    @PersistenceContext
    private EntityManager em;

    public Course findById(Long id) {
        return em.find(Course.class, id);
    }

    public Course save(Course course) {// -> insert or update
        return em.merge(course);
    }

    public void deleteById(Long id) {
        Course course = findById(id);
        if (course != null) {
            em.remove(course);
        }
    }
}
