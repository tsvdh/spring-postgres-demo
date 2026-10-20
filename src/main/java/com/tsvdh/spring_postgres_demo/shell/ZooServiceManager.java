package com.tsvdh.spring_postgres_demo.shell;

import com.tsvdh.spring_postgres_demo.data_jdbc.service.ZooServiceDataJDBC;
import com.tsvdh.spring_postgres_demo.jdbc.service.ZooServiceJDBC;
import com.tsvdh.spring_postgres_demo.shared.service.ZooService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.shell.core.command.annotation.Argument;
import org.springframework.shell.core.command.annotation.Command;
import org.springframework.shell.core.command.annotation.CommandGroup;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@CommandGroup(name = "Service commands", prefix = "service")
public class ZooServiceManager {

    private ZooService zooService;
    private final ZooServiceJDBC zooServiceJDBC;
    private final ZooServiceDataJDBC zooServiceDataJDBC;

    public ZooServiceManager(ZooServiceJDBC zooServiceJDBC, ZooServiceDataJDBC zooServiceDataJDBC) {
        this.zooServiceJDBC = zooServiceJDBC;
        this.zooServiceDataJDBC = zooServiceDataJDBC;

        log.info("Using 'Spring Data JDBC' service by default");
        this.zooService = zooServiceDataJDBC;
    }

    public ZooService getService() {
        return zooService;
    }

    @Command(name = "current", description = "Get current zoo service")
    public void current() {
        IO.println(zooService.getClass().getSimpleName());
    }

    @Command(name = "use", description = "Switch the zoo service")
    public void use(@Argument(index = 0, description = "name") String name) {
        switch (name) {
            case "jdbc" -> zooService = zooServiceJDBC;
            case "data_jdbc" -> zooService = zooServiceDataJDBC;
            default -> IO.println("Unknown service name");
        }
    }
}
