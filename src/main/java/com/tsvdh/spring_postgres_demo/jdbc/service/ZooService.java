package com.tsvdh.spring_postgres_demo.jdbc.service;

import com.tsvdh.spring_postgres_demo.jdbc.model.Animal;
import com.tsvdh.spring_postgres_demo.jdbc.model.Enclosure;
import com.tsvdh.spring_postgres_demo.jdbc.model.projection.AnimalsByEnclosure;
import com.tsvdh.spring_postgres_demo.jdbc.repository.ZooRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ZooService {
    
    private static final Logger logger = LoggerFactory.getLogger(ZooService.class);

    private final ZooRepository zooRepository;

    public Optional<Animal> getAnimal(int id) {
        try {
            return Optional.of(zooRepository.getAnimal(id));
        } catch (DataAccessException e) {
            logger.warn(e.getMessage());
            return Optional.empty();
        }
    }

    public Collection<Animal> getAnimals() {
        return zooRepository.getAnimals();
    }

    public Optional<Integer> addAnimal(Animal animal) {
        try {
            return Optional.of(zooRepository.addAnimal(animal));
        } catch (DataAccessException e) {
            logger.warn(e.getMessage());
            return Optional.empty();
        }
    }

    public boolean updateAnimal(int id, Animal animal) {
        try {
            return zooRepository.updateAnimal(id, animal);
        } catch (DataAccessException e) {
            logger.warn(e.getMessage());
            return false;
        }
    }

    public boolean deleteAnimal(int id) {
        try {
            return zooRepository.deleteAnimal(id);
        } catch (DataAccessException e) {
            logger.warn(e.getMessage());
            return false;
        }
    }

    public Optional<Enclosure> getEnclosure(int id) {
        try {
            return Optional.of(zooRepository.getEnclosure(id));
        } catch (DataAccessException e) {
            logger.warn(e.getMessage());
            return Optional.empty();
        }
    }

    public Collection<Enclosure> getEnclosures() {
        return zooRepository.getEnclosures();
    }

    public Optional<Integer> addEnclosure(Enclosure enclosure) {
        try {
            return Optional.of(zooRepository.addEnclosure(enclosure));
        } catch (DataAccessException e) {
            logger.warn(e.getMessage());
            return Optional.empty();
        }
    }

    public boolean updateEnclosure(int id, Enclosure enclosure) {
        try {
            return zooRepository.updateEnclosure(id, enclosure);
        } catch (DataAccessException e) {
            logger.warn(e.getMessage());
            return false;
        }
    }

    public boolean deleteEnclosure(int id) {
        try {
            return zooRepository.deleteEnclosure(id);
        } catch (DataAccessException e) {
            logger.warn(e.getMessage());
            return false;
        }
    }

    public Optional<Collection<AnimalsByEnclosure>> getAnimalsByEnclosure(int id) {
        try {
            return Optional.of(zooRepository.getAnimalsByEnclosure(id));
        } catch (DataAccessException e) {
            logger.warn(e.getMessage());
            return Optional.empty();
        }
    }

    public Collection<AnimalsByEnclosure> getAnimalsByEnclosure() {
        return zooRepository.getAnimalsByEnclosure();
    }
}
