package com.priya.app.service;

import com.priya.app.model.Car;
import com.priya.app.model.ParkingEnd;
import com.priya.app.model.ParkingStart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;



import java.util.Date;


@Component


public class ParkingService {

    private static final Logger logger = LoggerFactory.getLogger(ParkingService.class);
    private final AmqpTemplate amqpTemplate;
    @Value("${rabbitmq.exchange.name}")
    String exchangeName;
    @Value("${rabbitmq.parkingStart.routingkey.name}")
    String parkingStartRoutingKeyName;
    @Value("${rabbitmq.parkingStart.queue.name}")
    String parkingStartqueuename;
    @Value("parkingEnd.routingkey")
    String parkingEndRoutingKeyName;
    @Value("parking-end-request.out")
    String parkingEndRequestOut;



    private ParkingStart parkingStart;
   //private ParkingEnd parkingEnd;
    public ParkingService(AmqpTemplate amqpTemplate, ParkingStart parkingStart) {
        this.amqpTemplate = amqpTemplate;
        this.parkingStart = parkingStart;

    }
    public ParkingStart startParking(
            Car car, String parkingNo) {
        parkingStart.setParkingNo(parkingNo);
        parkingStart.setStartTime(new Date());
        parkingStart.setStatus("start");
        parkingStart.setRegNo(car.getRegNo());

        logger.info("ParkingStart: {}", parkingStart.toString());
        amqpTemplate.convertAndSend(exchangeName, parkingStartRoutingKeyName,parkingStart);
        return parkingStart;
    }


    public ParkingEnd endParking(String regNo) {
        ParkingEnd parkingEnd = new ParkingEnd();
        parkingEnd.setParkingNo(parkingStart.getParkingNo());
        parkingEnd.setStartTime(parkingStart.getStartTime());
        parkingEnd.setStatus("End");
        parkingEnd.setRegNo(regNo);
        parkingEnd.setEndTime(new Date());
        long timedifference =( parkingEnd.getEndTime().getTime() - parkingEnd.getStartTime().getTime());
        long mints =timedifference/(1000*60);
        parkingEnd.setPrice((int)(mints*2));
        logger.info(parkingEnd.toString());
        amqpTemplate.convertAndSend(exchangeName, parkingEndRoutingKeyName,parkingEnd);
        return parkingEnd;
    }

    @RabbitListener(queues = "${rabbitmq.parkingStartResponse.queue.name}")
    public void receiveStartResponse(String message) {
        logger.info("Received start response: " + message);
    }


    @RabbitListener(queues =
            "${rabbitmq.parkingEndResponse.queue.name}")
    public void receiveEndResponse(String message) {
        logger.info("Received end response: " + message);
    }



}
