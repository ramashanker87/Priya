package com.priya.app.service;

import com.priya.app.model.Car;
import com.priya.app.model.ParkingEnd;
import com.priya.app.model.ParkingStart;
import com.priya.app.resporitory.CarResporitory;
import com.priya.app.resporitory.ParkingEndResporitory;
import com.priya.app.resporitory.ParkingStartResporitory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service

public class ResporitoryService {

    @Autowired
    private ParkingStartResporitory parkingStartResporitory;
    @Autowired
    private ParkingEndResporitory parkingEndResporitory;

    @Autowired
    private CarResporitory carResporitory;



    public void handleParkingStart(ParkingStart parkingStart) {
        Optional<Car> carOptional = Optional.ofNullable(carResporitory.findByRegNo(parkingStart.getCar().getRegNo()));
        if (carOptional.isPresent()) {
            Car car = carOptional.get();
            parkingStart.setCar(car); // Set the car object in ParkingStart
            parkingStart.setStartTime(new Date()); // Set the start time as the current time

            // Save ParkingStart to the database
            parkingStartResporitory.save(parkingStart);
            System.out.println("Parking Start processed for Parking No: " + parkingStart.getParkingNo());


        }
    }

    public void handleParkingEnd(String regNo) {
        Optional<Car> carOptional = Optional.ofNullable(carResporitory.findByRegNo(regNo));
        if (carOptional.isPresent()) {
            Car car = carOptional.get();
            // Fetch ParkingStart by parkingNo (or other unique identifier)
            Optional<ParkingStart> parkingStartOptional =Optional.ofNullable( parkingStartResporitory.findByRegNo(regNo)); // or some other identifier
            if (parkingStartOptional.isPresent()) {
                ParkingStart parkingStart = parkingStartOptional.get();
                Date startTime = parkingStart.getStartTime();
                Date endTime = new Date();  // Current time

                // Calculate price (Rs. 2 per minute)
                long durationMillis = endTime.getTime() - startTime.getTime();
                long durationMinutes = durationMillis / 60000;  // Convert to minutes
                int price = (int) (durationMinutes * 2);  // Rs. 2 per minute

                // Create the ParkingEnd object
                ParkingEnd parkingEnd = new ParkingEnd();
                parkingEnd.setParkingNo(parkingStart.getParkingNo());
                parkingEnd.setStartTime(startTime);
                parkingEnd.setEndTime(endTime);
                parkingEnd.setPrice(price);
                parkingEnd.setStatus("End");
                parkingEnd.setCar(car);  // Set the car reference

                // Save ParkingEnd to the database
                parkingEndResporitory.save(parkingEnd);
                System.out.println("Parking End processed for Parking No: " + parkingStart.getParkingNo());


            }
        }


    }
}

