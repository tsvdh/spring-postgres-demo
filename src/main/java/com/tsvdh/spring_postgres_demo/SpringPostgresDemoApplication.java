package com.tsvdh.spring_postgres_demo;

import com.tsvdh.spring_postgres_demo.jdbc.repository.ZooRepository;
import com.tsvdh.spring_postgres_demo.jdbc.model.Animal;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringPostgresDemoApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(SpringPostgresDemoApplication.class);
	private static final RandomStringUtils stringUtils = RandomStringUtils.insecure();

	static void main(String[] args) {
		SpringApplication.run(SpringPostgresDemoApplication.class, args);
	}

	private final ZooRepository zooRepository;

	@Override
	public void run(String... args) throws Exception {
		logger.info("Hello world!");

		// for (int i = 0; i < 8; i++)
		// 	zooDAO.addAnimal(new Animal(-1, "monkey", 20 + i, 2, 1));

		// zooRepository.addAnimal(new Animal(-1, "baby lion", 50, 1, 2));
		logger.info(zooRepository.getAnimalsByEnclosure().toString());

		// logger.info(zooDAO.getAnimal(1).toString());
		// stringUtils.nextAlphabetic(5);
	}
}
