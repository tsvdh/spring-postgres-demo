package com.tsvdh.spring_postgres_demo.data_jdbc.repository;

import com.tsvdh.spring_postgres_demo.shared.model.Enclosure;
import org.springframework.data.repository.CrudRepository;

public interface EnclosureRepository extends CrudRepository<Enclosure, Integer> {
}
