package com.practice.Jdbc_To_Jpa;

import com.practice.Jdbc_To_Jpa.jdbc.Dao;
import com.practice.Jdbc_To_Jpa.jdbc.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;

@SpringBootApplication
public class JdbcToJpaApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(JdbcToJpaApplication.class);

	@Autowired
	private Dao dao;

	public static void main(String[] args) {
		SpringApplication.run(JdbcToJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Person with id = 1000: {}", dao.findById(1000));
		logger.info("All the person details: {}", dao.findAll());
		logger.info("Updated the person details. No of rows affected: {}", dao.update(new Person(1000, "John updated", "San Fransisco, USA-updated", LocalDate.now())));
//		logger.info("Delete persons whose id = 1000 or 1001. no of rows affected = {}",
//				dao.deleteById(1000, 1001));
	}
}
