package com.tsvdh.spring_postgres_demo.jdbc.repository;

import com.tsvdh.spring_postgres_demo.jdbc.model.Animal;
import com.tsvdh.spring_postgres_demo.jdbc.model.Enclosure;
import com.tsvdh.spring_postgres_demo.jdbc.model.projection.AnimalsByEnclosure;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ZooRepository {

    private static Animal makeAnimal(ResultSet resultSet) throws SQLException {
        return new Animal(
                resultSet.getInt("id"),
                resultSet.getString("type"),
                resultSet.getInt("weight"),
                resultSet.getInt("enclosure_id"),
                resultSet.getInt("hunger")
        );
    }

    private static Enclosure makeEnclosure(ResultSet resultSet) throws SQLException {
        return new Enclosure(
                resultSet.getInt("id"),
                resultSet.getInt("capacity"),
                resultSet.getInt("food"));
    }

    private static AnimalsByEnclosure makeAnimalsByEnclosure(ResultSet resultSet) throws SQLException {
        return new AnimalsByEnclosure(
                resultSet.getInt("enclosure_id"),
                Arrays.stream(resultSet.getString("types")
                                       .split(",")).collect(Collectors.toSet()),
                resultSet.getInt("amount"),
                resultSet.getInt("summed_weight"),
                resultSet.getFloat("avg_weight"),
                resultSet.getInt("summed_weight")
        );
    }

    private final JdbcTemplate jdbcTemplate;

    public Animal getAnimal(int id) {
        return jdbcTemplate.query(
                """
                SELECT * FROM animals
                WHERE id = ?
                """,
                rs -> {
                    rs.next();
                    return makeAnimal(rs);
                },
                id
        );
    }

    public Collection<Animal> getAnimals() {
        return jdbcTemplate.query(
                """
                SELECT * FROM animals
                """,
                (rs, _) -> makeAnimal(rs)
        );
    }

    public int addAnimal(Animal animal) {
        return jdbcTemplate.query(
                """
                INSERT INTO animals VALUES (default, ?, ?, ?, ?)
                """,
                rs -> {
                    rs.next();
                    return rs.getInt("id");
                },
                animal.type(), animal.weight(), animal.enclosure_id(), animal.hunger()
        );
    }

    public boolean updateAnimal(int id, Animal animal) {
        return jdbcTemplate.update(
                """
                UPDATE animals
                SET type = ?, weight = ?, enclosure_id = ?, hunger = ?
                WHERE id = ?
                """,
                animal.type(), animal.weight(), animal.enclosure_id(), animal.hunger(), id
        ) > 0;
    }

    public boolean deleteAnimal(int id) {
        return jdbcTemplate.update(
                """
                DELETE FROM animals
                WHERE id = ?
                """,
                id
        ) > 0;
    }

    public Enclosure getEnclosure(int id) {
        return jdbcTemplate.query(
                """
                SELECT * FROM enclosures
                WHERE id = ?
                """,
                rs -> {
                    rs.next();
                    return makeEnclosure(rs);
                },
                id
        );
    }

    public Collection<Enclosure> getEnclosures() {
        return jdbcTemplate.query(
                """
                SELECT * FROM enclosures
                """,
                (rs, _) -> makeEnclosure(rs)
        );
    }

    public int addEnclosure(Enclosure enclosure) {
        return jdbcTemplate.query(
                """
                INSERT INTO enclosures VALUES (default, ?, ?) RETURNING id;
                """,
                rs -> {
                    rs.next();
                    return rs.getInt("id");
                },
                enclosure.capacity(), enclosure.food()
        );
    }

    public boolean updateEnclosure(int id, Enclosure enclosure) {
        return jdbcTemplate.update(
                """
                UPDATE enclosures
                SET capacity = ?, food = ?
                WHERE id = ?
                """,
                enclosure.capacity(), enclosure.food(), id
        ) > 0;
    }

    public boolean deleteEnclosure(int id) {
        return jdbcTemplate.update(
                """
                DELETE FROM enclosures
                WHERE id = ?
                """,
                id
        ) > 0;
    }

    public Collection<AnimalsByEnclosure> getAnimalsByEnclosure(int id) {
        return jdbcTemplate.query(
                """
                SELECT e.id as enclosure_id,
                       string_agg(a.type, ',') as types,
                       count(*) as amount,
                       sum(a.weight) as summed_weight,
                       avg(a.weight) as avg_weight,
                       sum(a.hunger) as summed_hunger
                FROM animals a JOIN enclosures e ON a.enclosure_id = e.id
                WHERE e.id = ?
                GROUP BY e.id
                """,
                (rs, _) -> makeAnimalsByEnclosure(rs),
                id
        );
    }

    public Collection<AnimalsByEnclosure> getAnimalsByEnclosure() {
        return jdbcTemplate.query(
                """
                SELECT e.id as enclosure_id,
                       string_agg(a.type, ',') as types,
                       count(*) as amount,
                       sum(a.weight) as summed_weight,
                       avg(a.weight) as avg_weight,
                       sum(a.hunger) as summed_hunger
                FROM animals a JOIN enclosures e ON a.enclosure_id = e.id
                GROUP BY e.id
                """,
                (rs, _) -> makeAnimalsByEnclosure(rs)
        );
    }
}
