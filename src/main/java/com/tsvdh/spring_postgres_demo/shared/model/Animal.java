package com.tsvdh.spring_postgres_demo.shared.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter @Setter
@AllArgsConstructor
@ToString
@Table(name = "animals")
public class Animal {

    @Id Integer id;

    int enclosureId;
    String type;
    int weight;
    int hunger;

    public void updateWithOther(Animal other) {
        enclosureId = other.enclosureId;
        type = other.type;
        weight = other.weight;
        hunger = other.hunger;
    }
}
