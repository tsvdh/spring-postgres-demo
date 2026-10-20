package com.tsvdh.spring_postgres_demo.shared.service;

import com.tsvdh.spring_postgres_demo.shared.model.Animal;
import com.tsvdh.spring_postgres_demo.shared.model.Enclosure;
import com.tsvdh.spring_postgres_demo.shared.model.projection.AnimalsByEnclosure;

import java.util.Collection;
import java.util.Optional;

public interface ZooService {

    Optional<Animal> getAnimal(int id);

    Collection<Animal> getAnimals();

    Optional<Integer> addAnimal(Animal animal);

    Boolean updateAnimal(Animal newAnimal);

    Boolean deleteAnimal(int id);

    Optional<Enclosure> getEnclosure(int id);

    Collection<Enclosure> getEnclosures();

    Optional<Integer> addEnclosure(Enclosure enclosure);

    Boolean updateEnclosure(Enclosure newEnclosure);

    Boolean deleteEnclosure(int id);

    Optional<Collection<AnimalsByEnclosure>> getAnimalsByEnclosure(int id);

    Collection<AnimalsByEnclosure> getAnimalsByEnclosure();
}
