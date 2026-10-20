package com.tsvdh.spring_postgres_demo.data_jdbc.service;

import com.tsvdh.spring_postgres_demo.data_jdbc.repository.AnimalRepository;
import com.tsvdh.spring_postgres_demo.data_jdbc.repository.EnclosureRepository;
import com.tsvdh.spring_postgres_demo.shared.model.Animal;
import com.tsvdh.spring_postgres_demo.shared.model.Enclosure;
import com.tsvdh.spring_postgres_demo.shared.model.projection.AnimalsByEnclosure;
import com.tsvdh.spring_postgres_demo.shared.service.ZooService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ZooServiceDataJDBC implements ZooService {

    private final AnimalRepository animalRepository;
    private final EnclosureRepository enclosureRepository;

    @Override
    public Optional<Animal> getAnimal(int id) {
        return animalRepository.findById(id);
    }

    @Override
    public Collection<Animal> getAnimals() {
        var animals = new ArrayList<Animal>();
        animalRepository.findAll().forEach(animals::add);
        return animals;
    }

    @Override
    public Optional<Integer> addAnimal(Animal animal) {
        return Optional.of(animalRepository.save(animal).getId());
    }

    @Override
    public Boolean updateAnimal(Animal newAnimal) {
        Optional<Animal> optAnimal = animalRepository.findById(newAnimal.getId());
        if (optAnimal.isEmpty())
            return false;

        var animal = optAnimal.get();
        animal.updateWithOther(newAnimal);
        animalRepository.save(animal);
        return true;
    }

    @Override
    public Boolean deleteAnimal(int id) {
        if (animalRepository.findById(id).isEmpty())
            return false;

        animalRepository.deleteById(id);
        return true;
    }

    @Override
    public Optional<Enclosure> getEnclosure(int id) {
        return enclosureRepository.findById(id);
    }

    @Override
    public Collection<Enclosure> getEnclosures() {
        var enclosures = new ArrayList<Enclosure>();
        enclosureRepository.findAll().forEach(enclosures::add);
        return enclosures;
    }

    @Override
    public Optional<Integer> addEnclosure(Enclosure enclosure) {
        return Optional.of(enclosureRepository.save(enclosure).getId());
    }

    @Override
    public Boolean updateEnclosure(Enclosure newEnclosure) {
        Optional<Enclosure> optEnclosure = enclosureRepository.findById(newEnclosure.getId());
        if (optEnclosure.isEmpty())
            return false;

        var enclosure = optEnclosure.get();
        enclosure.updateWithOther(newEnclosure);
        enclosureRepository.save(enclosure);
        return true;
    }

    @Override
    public Boolean deleteEnclosure(int id) {
        if (enclosureRepository.findById(id).isEmpty())
            return false;

        enclosureRepository.deleteById(id);
        return true;
    }

    @Override
    public Optional<Collection<AnimalsByEnclosure>> getAnimalsByEnclosure(int id) {
        return Optional.empty();
    }

    @Override
    public Collection<AnimalsByEnclosure> getAnimalsByEnclosure() {
        return Collections.emptyList();
    }
}
