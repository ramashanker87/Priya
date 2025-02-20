package com.priya.app.controller;

import com.priya.app.model.Owner;
import com.priya.app.model.Registration;
import com.priya.app.model.Vehicle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("/register")
public class VehicleController   {
    private static final Logger logger = LoggerFactory.getLogger(VehicleController.class);

    private VehicleController vehicleController;

    private Map<String, Registration> registry = new HashMap<>();
    public void registerVehicle(String vehicleNumber, Registration registration) {
        registry.put(vehicleNumber, registration);
    }
    public void deregisterVehicle(String vehicleNumber, Registration registration) {
        registry.remove(vehicleNumber);
    }
    public Map<String, Registration> getRegistry() {
        return registry;
    }

    @PostMapping("/vehicle")
    public String registerVehicle(@RequestBody Vehicle vehicle, @RequestBody Owner owner) {
        Registration registration = new Registration(owner, vehicle);
        vehicleController.registerVehicle(vehicle.getVehicleNumber(), registration);
        logger.info("Vehicle registered{}", vehicle);
        return "Vehicle registered successfully!";
    }
        @DeleteMapping("/vehicle")
        public String deregisterVehicle(@RequestParam String vehicleNumber) {
            vehicleController.deregisterVehicle( vehicleNumber);
            logger.info("Vehicle deregistered" + vehicleNumber);
            return "Vehicle deregistered successfully!";

        }
    }
