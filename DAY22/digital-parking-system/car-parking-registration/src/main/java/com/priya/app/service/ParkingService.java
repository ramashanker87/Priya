package com.priya.app.service;

import com.priya.app.exception.ParkingException;
import com.priya.app.model.Car;
import com.priya.app.model.ParkingEnd;
import com.priya.app.model.ParkingStart;
import com.priya.app.model.ParkingStartTable;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemResponse;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


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
}
