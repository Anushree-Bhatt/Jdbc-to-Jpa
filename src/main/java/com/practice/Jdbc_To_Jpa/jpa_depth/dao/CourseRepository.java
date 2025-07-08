package com.practice.Jdbc_To_Jpa.jpa_depth.dao;

import com.practice.Jdbc_To_Jpa.jpa_depth.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class CourseRepository {
    @PersistenceContext
    private EntityManager em;

    public Course findById(Long id) {
        return em.find(Course.class, id);
    }

    public List<Course> findAll() {
        TypedQuery<Course> res = em.createQuery("select c from Course c", Course.class);
        return res.getResultList();
    }

    public Course save(Course course) {// -> insert or update
        if (course.getId() == null) {
            //insert
            em.persist(course);
        } else{
            //update
             em.merge(course);
        }
        return course;
    }

    public void deleteById(Long id) {
        Course course = findById(id);
        if (course != null) {
            em.remove(course);
        }
    }


}
