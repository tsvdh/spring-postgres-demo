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
@Table(name = "enclosures")
public class Enclosure {

    @Id Integer id;

    int capacity;
    int food;

    public void updateWithOther(Enclosure other) {
        capacity = other.capacity;
        food = other.food;
    }
}
