package com.tsvdh.spring_postgres_demo.jdbc.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Aspect
@Component
public class DataAccessExceptionCatcher {

    @Around("execution(java.util.Optional com.tsvdh.spring_postgres_demo.jdbc.service.ZooService.*(..))")
    public Optional<?> catchAndReturnOptional(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            Object obj = joinPoint.proceed();
            if (obj instanceof Optional<?>)
                return (Optional<?>) obj;
            throw new RuntimeException("Method did not return 'Optional'");
        }
        catch (DataAccessException e) {
            log.warn(e.getMessage());
            return Optional.empty();
        }
    }

    @Around("execution(Boolean com.tsvdh.spring_postgres_demo.jdbc.service.ZooService.*(..))")
    public boolean catchAndReturnBool(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            Object obj = joinPoint.proceed();
            if (obj instanceof Boolean)
                return (Boolean) obj;
            throw new RuntimeException("Method did not return 'Boolean'");
        }
        catch (DataAccessException e) {
            log.warn(e.getMessage());
            return false;
        }
    }
}
