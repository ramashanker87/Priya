package com.priya.app.controller;

import com.priya.app.model.Car;
import com.priya.app.model.ParkingEnd;
import com.priya.app.model.ParkingStart;
import com.priya.app.service.DynamodbService;
import com.priya.app.service.ParkingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Component
@RestController
@RequestMapping("/parking")
public class ParkingProducerController {
    private final ParkingStart parkingStart;

    private ParkingService parkingService;


    private DynamodbService dynamodbService;

    public ParkingProducerController(ParkingService parkingService, ParkingStart parkingStart) {
         this.parkingService = parkingService;
         this.parkingStart = parkingStart;
     }
     private static final Logger logger = LoggerFactory.getLogger(ParkingProducerController.class);
    @PostMapping("/start")
    public ParkingStart startParking(@RequestBody Car car, @RequestParam String parkingNo) {
        logger.info("Starting parking for car");
        dynamodbService.storeParkingStart(
                parkingStart.getParkingNo(),
                parkingStart.getStatus(),
                parkingStart.getRegNo(),
        parkingStart.getStartTime());
        return parkingService.startParking(car,parkingNo);
    }
    @PostMapping("/end")
    public ParkingEnd endParking(@RequestParam String regNo) {
        logger.info("Ending car parking");
        return parkingService.endParking(regNo);
    }
}
