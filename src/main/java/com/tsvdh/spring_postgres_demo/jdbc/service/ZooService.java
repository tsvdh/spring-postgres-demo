package com.tsvdh.spring_postgres_demo.jdbc.service;

import com.tsvdh.spring_postgres_demo.jdbc.model.Animal;
import com.tsvdh.spring_postgres_demo.jdbc.model.Enclosure;
import com.tsvdh.spring_postgres_demo.jdbc.model.projection.AnimalsByEnclosure;
import com.tsvdh.spring_postgres_demo.jdbc.repository.ZooRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ZooService {

    private final ZooRepository zooRepository;

    public Optional<Animal> getAnimal(int id) {
        return zooRepository.getAnimal(id);
    }

    public Collection<Animal> getAnimals() {
        return zooRepository.getAnimals();
    }

    public Optional<Integer> addAnimal(Animal animal) {
        return Optional.of(zooRepository.addAnimal(animal));
    }

    public Boolean updateAnimal(int id, Animal animal) {
        return zooRepository.updateAnimal(id, animal);
    }

    public Boolean deleteAnimal(int id) {
        return zooRepository.deleteAnimal(id);
    }

    public Optional<Enclosure> getEnclosure(int id) {
        return zooRepository.getEnclosure(id);
    }

    public Collection<Enclosure> getEnclosures() {
        return zooRepository.getEnclosures();
    }

    public Optional<Integer> addEnclosure(Enclosure enclosure) {
        return Optional.of(zooRepository.addEnclosure(enclosure));
    }

    public Boolean updateEnclosure(int id, Enclosure enclosure) {
        return zooRepository.updateEnclosure(id, enclosure);
    }

    public Boolean deleteEnclosure(int id) {
        return zooRepository.deleteEnclosure(id);
    }

    public Optional<Collection<AnimalsByEnclosure>> getAnimalsByEnclosure(int id) {
        return Optional.of(zooRepository.getAnimalsByEnclosure(id));
    }

    public Collection<AnimalsByEnclosure> getAnimalsByEnclosure() {
        return zooRepository.getAnimalsByEnclosure();
    }
}
