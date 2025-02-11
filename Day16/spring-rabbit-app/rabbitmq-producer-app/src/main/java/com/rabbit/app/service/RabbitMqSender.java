package com.rabbit.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqSender {
  private static final Logger logger = LoggerFactory.getLogger(RabbitMqSender.class.getName());
  private final AmqpTemplate amqpTemplate;
  @Value("${rabbitmq.exchange.name}")
  String exchangeName;
  @Value("${rabbitmq.routingkey.name}")
  String routingKeyName;

  public RabbitMqSender(AmqpTemplate amqpTemplate) {
    this.amqpTemplate = amqpTemplate;
  }

  public void send(String message) {
    logger.info("sending message: {}", message);
    amqpTemplate.convertAndSend(exchangeName, routingKeyName, message);
  }

}
