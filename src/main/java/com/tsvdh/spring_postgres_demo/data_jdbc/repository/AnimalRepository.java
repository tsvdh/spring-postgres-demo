package com.tsvdh.spring_postgres_demo.data_jdbc.repository;

import com.tsvdh.spring_postgres_demo.shared.model.Animal;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository extends CrudRepository<Animal, Integer> {
}
