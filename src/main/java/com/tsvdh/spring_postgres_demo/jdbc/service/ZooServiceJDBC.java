package com.tsvdh.spring_postgres_demo.jdbc.service;

import com.tsvdh.spring_postgres_demo.shared.model.Animal;
import com.tsvdh.spring_postgres_demo.shared.model.Enclosure;
import com.tsvdh.spring_postgres_demo.shared.model.projection.AnimalsByEnclosure;
import com.tsvdh.spring_postgres_demo.jdbc.repository.ZooRepository;
import com.tsvdh.spring_postgres_demo.shared.service.ZooService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ZooServiceJDBC implements ZooService {

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

    public Boolean updateAnimal(Animal animal) {
        return zooRepository.updateAnimal(animal);
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

    public Boolean updateEnclosure(Enclosure enclosure) {
        return zooRepository.updateEnclosure(enclosure);
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
