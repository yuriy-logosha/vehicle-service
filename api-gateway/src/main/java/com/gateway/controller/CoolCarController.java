package com.gateway.controller;

import com.gateway.client.VehicleClient;
import com.gateway.domain.Vehicle;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class CoolCarController {

    private final VehicleClient vehicleClient;

    public CoolCarController(VehicleClient vehicleClient) {
        this.vehicleClient = vehicleClient;
    }

    private Collection<Vehicle> fallback() {
        return new ArrayList<>();
    }

    @GetMapping("/cool-cars")
    @CrossOrigin
    @HystrixCommand(fallbackMethod = "fallback")
    public Collection<Vehicle> goodCars() {
        return vehicleClient.readVehicles()
                .getContent()
                .stream()
                .filter(Vehicle::isCool)
                .collect(Collectors.toList());
    }
}
