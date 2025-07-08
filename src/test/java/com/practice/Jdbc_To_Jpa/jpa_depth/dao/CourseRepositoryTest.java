package com.practice.Jdbc_To_Jpa.jpa_depth.dao;

import com.practice.Jdbc_To_Jpa.jpa_depth.entity.Course;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;


@SpringBootTest
class CourseRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(CourseRepository.class);
    @Autowired
    private CourseRepository courseRepository;

    @Test
    @Order(1)
    void testFindById() {
        logger.info("Test case 1.....");
        Course course = courseRepository.findById(1000L);
        assertNotNull(course);
        assertEquals("JPA in 50 steps", courseRepository.findById(1000L).getName());
    }

    @Test
    @Order(2)
    @DirtiesContext
    void testDeleteById() {
        logger.info("Test case 2.....");
        courseRepository.deleteById(1003L);
        assertNull(courseRepository.findById(1003L));
    }

    @Test
    @Order(3)
    void TestDirtiesContext() {
        assertNotNull(courseRepository.findById(1003L)); //DirtiesContext don't work. Because - entityManager.flush() is done internally, even before @DirtiesContext or @Rollback is applied.
    }

    @Test
    void TestSave() {
        //test update
        Course course = courseRepository.findById(1L);
        course.setName("SQL in 20 steps - Updated!");
        courseRepository.save(course);

        assertEquals("SQL in 20 steps - Updated!", courseRepository.findById(1L).getName());
    }

}
