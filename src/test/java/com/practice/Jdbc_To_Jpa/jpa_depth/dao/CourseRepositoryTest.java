package com.practice.Jdbc_To_Jpa.jpa_depth.dao;

import com.practice.Jdbc_To_Jpa.jpa_depth.entity.Course;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class CourseRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(CourseRepository.class);
    @Autowired
    private CourseRepository courseRepository;

    @Test
    void contextLoads() {
        logger.info("Test is running......");
        Course course = courseRepository.findById(1000L);
        assertNotNull(course);
        assertEquals("JPA in 50 steps", courseRepository.findById(1000L).getName());
    }

}
