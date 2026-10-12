package com.tsvdh.spring_postgres_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringPostgresDemoApplication {

	static void main(String[] args){
		SpringApplication.run(SpringPostgresDemoApplication.class, args);
	}
}
