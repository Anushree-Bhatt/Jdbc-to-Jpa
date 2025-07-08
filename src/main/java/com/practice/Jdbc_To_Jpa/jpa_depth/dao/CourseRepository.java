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

    public void PlayWithEntityManager() {
        Course c1 = em.find(Course.class, 1000L);

        Course d1 = new Course("Dummy Course");
        em.persist(d1);

        em.detach(d1);
//        em.clear();

        c1.setName("JPA in 50 steps - updated");
        d1.setName("Dummy Course - updated!"); //detached

        em.flush(); // c1 changes are flushed to db
        em.detach(c1);

        c1.setName("JPA in 50 steps - updated again!");//detached

    }


}
