package com.tsvdh.spring_postgres_demo.dao;

import com.tsvdh.spring_postgres_demo.model.Animal;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ZooDAO {

    private final JdbcTemplate jdbcTemplate;

    public Animal getAnimal(int id) {
        return jdbcTemplate.query(
                """
                SELECT * FROM animals
                WHERE id = ?
                """,
                rs -> {
                    rs.next();
                    return new Animal(
                            rs.getInt("id"),
                            rs.getString("type"),
                            rs.getInt("weight"),
                            rs.getInt("enclosure_id"),
                            rs.getInt("hunger"));
                },
                id
        );
    }

    public void addAnimal(Animal animal) {
        jdbcTemplate.update(
                """
                INSERT INTO animals VALUES (default, ?, ?, ?, ?);
                """,
                animal.type(), animal.weight(), animal.enclosure_id(), animal.hunger());
    }


}
