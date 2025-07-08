package com.practice.Jdbc_To_Jpa;

import com.practice.Jdbc_To_Jpa.jdbc.Dao;
import com.practice.Jdbc_To_Jpa.jdbc.entity.Person;
import com.practice.Jdbc_To_Jpa.jpa_depth.dao.CourseRepository;
import com.practice.Jdbc_To_Jpa.jpa_depth.entity.Course;
import com.practice.Jdbc_To_Jpa.jpa_intro.dao.JpaDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;


@SpringBootApplication
public class JdbcToJpaApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(JdbcToJpaApplication.class);

	@Autowired
	private Dao dao;
	@Autowired
	private JpaDao jpaDao;
	@Autowired
	private CourseRepository courseRepo;


	public static void main(String[] args) {
		SpringApplication.run(JdbcToJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		jdbc();
//		jpa();
		complete_jpa();
	}

	private void complete_jpa() {
		Course course = courseRepo.findById(1000L);
		logger.info("Course with id - 1000L : {} ", course);
	}

	private void jpa(){
		logger.info("Person with id = 1000: {}", jpaDao.findById(1000));
		logger.info("Inserting new Person: {}", jpaDao.save( new com.practice.Jdbc_To_Jpa.jpa_intro.entity.Person("Sara", "New Jersey, USA", LocalDate.now())));
		logger.info("Updated Person: {}", jpaDao.save( new com.practice.Jdbc_To_Jpa.jpa_intro.entity.Person(1000, "John updated", "San Fransisco, USA-updated", LocalDate.now())));
		jpaDao.deleteById(1001);
		logger.info("Deleted person with id = 1001");
		logger.info("All persons: {}", jpaDao.findAll());
	}

	private void jdbc(){
		logger.info("Person with id = 1000: {}", dao.findById(1000));
		logger.info("All the person details: {}", dao.findAll());

		dao.save(new Person(1003, "Sara", "New Jersey, USA", LocalDate.now()));
		logger.info("Inserted new person. Details: {}", dao.findById(1003));
		logger.info("Updated the person details. No of rows affected: {}", dao.update(new Person(1000, "John updated", "San Fransisco, USA-updated", LocalDate.now())));
		logger.info("Delete persons whose id = 1000 or 1001. no of rows affected = {}",
				dao.deleteById(1000, 1001));
	}
}
