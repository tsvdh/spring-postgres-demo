package com.tsvdh.spring_postgres_demo.jdbc.model.projection;

import java.util.Set;

public record AnimalsByEnclosure(Set<String> types, int summedWeight, float averageWeight, int summedHunger, int enclosureId) {
}
