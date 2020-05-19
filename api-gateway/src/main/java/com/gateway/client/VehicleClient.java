package com.gateway.client;

import com.gateway.domain.Vehicle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("vehicle-service")
public interface VehicleClient {

    @GetMapping("/vehicles")
    @CrossOrigin
    CollectionModel<Vehicle> readVehicles();
}
