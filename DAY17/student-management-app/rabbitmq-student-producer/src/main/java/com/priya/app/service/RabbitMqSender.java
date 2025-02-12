package com.priya.app.service;

import com.priya.app.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqSender
{
    private static final Logger logger = LoggerFactory.getLogger(RabbitMqSender.class.getName());
    private final AmqpTemplate amqpTemplate;
    @Value("${rabbitmq.exchange.name}")
    String exchangeName;
    @Value("${rabbitmq.student.routingkey.name}")
    String studentRoutingKeyName;
    @Value("${rabbitmq.name.routingkey.name}")
    String nameRoutingKeyName;
    public RabbitMqSender(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }
    public void sendStudent(Student student) {
        logger.info("sending student: {}", student.toString());
        amqpTemplate.convertAndSend(exchangeName, studentRoutingKeyName,student);
    }
    public void deleteName(String student) {
        logger.info("deleting student: {}", student.toString());
        amqpTemplate.convertAndSend(exchangeName, nameRoutingKeyName,student);
    }
}
