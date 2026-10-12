package com.tsvdh.spring_postgres_demo.jdbc.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Aspect
@Component
public class DataAccessExceptionCatcher {

    @AfterThrowing(
            pointcut = "execution(java.util.Optional com.tsvdh.spring_postgres_demo.jdbc.service.ZooService.*(..))",
            throwing = "e")
    public <T> Optional<T> catchAndReturn(DataAccessException e) {
        log.warn(e.getMessage());
        return Optional.empty();
    }

    @AfterThrowing(
            pointcut = "execution(boolean com.tsvdh.spring_postgres_demo.jdbc.service.ZooService.*(..))",
            throwing = "e")
    public boolean catchAndReturnBool(DataAccessException e) {
        log.warn(e.getMessage());
        return false;
    }
}
