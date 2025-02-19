package com.priya.app.controller;

import com.priya.app.model.Car;
import com.priya.app.model.ParkingEnd;
import com.priya.app.model.ParkingStart;
import com.priya.app.service.ParkingService;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Map;

@RestController
@RequestMapping("/parking")
public class ParkingController {
    private ParkingService parkingService;
     public ParkingController(ParkingService parkingService) {
         this.parkingService = parkingService;
     }
     private static final Logger logger = LoggerFactory.getLogger(ParkingController.class);
    @PostMapping("/start")
    public ParkingStart startParking(@RequestBody Car car, @RequestParam String parkingNo) {
        logger.info("Starting parking for car");
        return parkingService.startParking(car,parkingNo);
    }
    @PostMapping("/end")
    public ParkingEnd endParking(@RequestParam String regNo) {
        logger.info("Ending car parking");
        return parkingService.endParking(regNo);
    }
}
