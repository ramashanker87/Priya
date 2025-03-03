package com.priya.app.service;

import com.priya.app.model.ParkingEnd;
import com.priya.app.model.ParkingStart;

import com.priya.app.resporitory.ParkingEndResporitory;
import com.priya.app.resporitory.ParkingStartResporitory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;

@Service
public class ParkingResponseService {
    private static final Logger logger = LoggerFactory.getLogger(ParkingResponseService.class);


@Autowired
private ParkingStartResporitory parkingStartResporitory;

@Autowired
private ParkingEndResporitory parkingEndResporitory;

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    @RabbitListener(queues= "${rabbitmq.parkingStart.queue.name}")
    public void receiveStartRequest(Map<String, Object> message){

        logger.info("receive message: {}" + message);
        ParkingStart parkingStarted = new ParkingStart();
      parkingStartResporitory.save(parkingStarted);
    }

    @RabbitListener(queues= "${rabbitmq.parkingEnd.queue.name}")
    public void receiveParkingEnd(ParkingEnd parkingEnd) {
        logger.info("receive message: {}",parkingEnd.toString());
    }
}

