package com.tsvdh.spring_postgres_demo.shell;

import com.tsvdh.spring_postgres_demo.shared.model.Enclosure;
import com.tsvdh.spring_postgres_demo.shared.service.ZooService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.shell.core.command.annotation.Argument;
import org.springframework.shell.core.command.annotation.Command;
import org.springframework.shell.core.command.annotation.CommandGroup;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
@CommandGroup(name = "Enclosure commands", prefix = "enclosures")
public class EnclosureCommands {

    private final ZooServiceManager zooServiceManager;

    private ZooService getService() {
        return zooServiceManager.getService();
    }

    @Command(name = "get", description = "Get enclosure")
    public void get(@Argument(index = 0, description = "id") int id) {
        System.out.println(getService().getEnclosure(id));
    }

    @Command(name = "get-all", description = "Get all enclosures")
    public void getAll() {
        getService().getEnclosures().forEach(System.out::println);
    }

    @Command(name = "add", description = "Add enclosure")
    public void add(@Argument(index = 0, description = "capacity") int capacity,
                    @Argument(index = 1, description = "food") int food
    ) {
        Optional<Integer> newId = getService().addEnclosure(new Enclosure(null, capacity, food));
        newId.ifPresent(System.out::println);
    }

    @Command(name = "update", description = "Update enclosure")
    public void update(@Argument(index = 0, description = "id") int id,
                       @Argument(index = 1, description = "capacity") int capacity,
                       @Argument(index = 2, description = "food") int food
    ) {
        boolean success = getService().updateEnclosure(new Enclosure(id, capacity, food));
        System.out.printf("Success: %s\n", success);
    }

    @Command(name = "delete", description = "Delete enclosure")
    public void delete(@Argument(index = 0, description = "id") int id) {
        boolean success = getService().deleteEnclosure(id);
        System.out.printf("Success: %s\n", success);
    }
}
