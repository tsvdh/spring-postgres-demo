package com.tsvdh.spring_postgres_demo.shared.model.projection;

import java.util.Set;

public record AnimalsByEnclosure(int enclosureId, Set<String> types, int amount, int summedWeight, float averageWeight, int summedHunger) {
}
