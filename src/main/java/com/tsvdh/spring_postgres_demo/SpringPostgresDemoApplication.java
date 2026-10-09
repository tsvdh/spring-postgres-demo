package com.tsvdh.spring_postgres_demo;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Random;

@SpringBootApplication
public class SpringPostgresDemoApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(SpringPostgresDemoApplication.class);
	private static final RandomStringUtils stringUtils = RandomStringUtils.insecure();

	static void main(String[] args) {
		SpringApplication.run(SpringPostgresDemoApplication.class, args);
	}

	private final JdbcTemplate jdbcTemplate;

	public SpringPostgresDemoApplication(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Hello world!");

		logger.info(jdbcTemplate.query("SELECT * from house;",
									   (a, b) -> a.getString("color")).toString());
		// stringUtils.nextAlphabetic(5);
	}
}
