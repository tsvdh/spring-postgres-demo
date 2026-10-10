package com.tsvdh.spring_postgres_demo.jdbc;

import com.tsvdh.spring_postgres_demo.jdbc.model.Animal;
import com.tsvdh.spring_postgres_demo.jdbc.repository.ZooRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ZooService {

    private final ZooRepository zooRepository;

    public Animal getAnimal(int id) {
        return zooRepository.getAnimal(id);
    }

    public void addAnimal(Animal animal) {
        zooRepository.addAnimal(animal);
    }


}
