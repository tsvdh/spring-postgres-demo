package com.tsvdh.spring_postgres_demo.shell;

import com.tsvdh.spring_postgres_demo.jdbc.model.Animal;
import com.tsvdh.spring_postgres_demo.jdbc.model.projection.AnimalsByEnclosure;
import com.tsvdh.spring_postgres_demo.jdbc.service.ZooService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.shell.core.command.annotation.Argument;
import org.springframework.shell.core.command.annotation.Command;
import org.springframework.shell.core.command.annotation.CommandGroup;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
@CommandGroup(name = "Animal commands", prefix = "animals")
public class AnimalCommands {

    private final ZooService zooService;

    @Command(name = "get", description = "Get animal")
    public void get(@Argument(index = 0, description = "index") int index) {
        System.out.println(zooService.getAnimal(index));
    }

    @Command(name = "get-all", description = "Get all animals")
    public void getAll() {
        zooService.getAnimals().forEach(System.out::println);
    }

    @Command(name = "add", description = "Add animal")
    public void add(@Argument(index = 0, description = "enclosure_id") int enclosure_id,
                    @Argument(index = 1, description = "type") String type,
                    @Argument(index = 2, description = "weight") int weight,
                    @Argument(index = 3, description = "hunger") int hunger
    ) {
        Optional<Integer> newId = zooService.addAnimal(new Animal(-1, enclosure_id, type, weight, hunger));
        newId.ifPresent(System.out::println);
    }

    @Command(name = "update", description = "Update animal")
    public void update(@Argument(index = 0, description = "id") int id,
                       @Argument(index = 0, description = "enclosure_id") int enclosure_id,
                       @Argument(index = 1, description = "type") String type,
                       @Argument(index = 2, description = "weight") int weight,
                       @Argument(index = 3, description = "hunger") int hunger
    ) {
        boolean success = zooService.updateAnimal(id, new Animal(-1, enclosure_id, type, weight, hunger));
        System.out.printf("Success: %s\n", success);
    }

    @Command(name = "delete", description = "Delete animal")
    public void delete(@Argument(index = 0, description = "id") int id) {
        boolean success = zooService.deleteAnimal(id);
        System.out.printf("Success: %s\n", success);
    }

    @Command(name = "get-by-enclosure", description = "Get animals by enclosure")
    public void getByEnclosure(@Argument(index = 0, description = "id") int id) {
        Optional<Collection<AnimalsByEnclosure>> animalsByEnclosure = zooService.getAnimalsByEnclosure(id);
        if (animalsByEnclosure.isEmpty())
            return;
        animalsByEnclosure.get().forEach(System.out::println);
    }

    @Command(name = "get-all-by-enclosure", description = "Get all animals by enclosure")
    public void getAllByEnclosure() {
        Collection<AnimalsByEnclosure> animalsByEnclosure = zooService.getAnimalsByEnclosure();
        animalsByEnclosure.forEach(System.out::println);
    }
}
