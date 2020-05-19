package com.gateway.domain;

import lombok.Data;

@Data
public class Vehicle {
    private String name;

    private int stars;

    public static boolean isCool(Vehicle car) {
        return car.getStars() >= 5;
    }
}
