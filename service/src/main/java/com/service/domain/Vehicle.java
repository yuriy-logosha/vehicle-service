package com.service.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Vehicle {

    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private int stars;

    public Vehicle(String name) {
        this.name = name;
    }
}