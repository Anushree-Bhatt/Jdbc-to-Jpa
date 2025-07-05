package com.practice.Jdbc_To_Jpa;

import com.practice.Jdbc_To_Jpa.jdbc.Dao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
	}
}
