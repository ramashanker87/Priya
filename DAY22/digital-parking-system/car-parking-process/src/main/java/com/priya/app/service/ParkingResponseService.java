package com.priya.app.service;

import com.priya.app.model.ParkingEnd;
import com.priya.app.model.ParkingStart;
import com.priya.app.resporitory.ParkingEndResporitory;
import com.priya.app.resporitory.ParkingStartResporitory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParkingResponseService {
    private static final Logger logger = LoggerFactory.getLogger(ParkingResponseService.class);
 @Autowired
 private ResporitoryService resporitoryService;



    private final AmqpTemplate amqpTemplate;

    public ParkingResponseService(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;

    }

    @Value("${rabbitmq.exchange.name}")
    String exchangeName;

    @Value("${rabbitmq.parkingStartResponse.routingkey.name}")
    String parkingStartResponseRoutingKeyName;

    @Value("${rabbitmq.parkingEndResponse.routingkey.name}")
    String parkingEndResponseRoutingKeyName;

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @RabbitListener(queues= "${rabbitmq.parkingStart.queue.name}")


    public void receiveParkingstart(ParkingStart parkingStart) {
        logger.info("receive message: {}",parkingStart.toString());
      resporitoryService.handleParkingStart(parkingStart);

        rabbitTemplate.convertAndSend("parking-start-response", parkingStart);
    }

    @RabbitListener(queues= "${rabbitmq.parkingEnd.queue.name}")
    public void receiveParkingEnd(ParkingEnd parkingEnd) {
        logger.info("receive message: {}", parkingEnd.toString());
       resporitoryService.handleParkingEnd(String.valueOf(parkingEnd));
        rabbitTemplate.convertAndSend("parking-end-response", parkingEnd);



    }    }

