package com.priya.app.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class rabbitMqConsumer {
    @Configuration
    public class RabbitMqConfigProducer {
        @Value("${rabbitmq.exchange.name}")
        String exchangeName;
        @Value("${rabbitmq.parkingStartResponse.queue.name}")
        String parkingStartResponsequeuename;
        @Value("${rabbitmq.parkingStartResponse.routingkey.name}")
        String parkingStartResponseRoutingKeyName;
        @Value("${rabbitmq.parkingEndResponse.queue.name}")
        String parkingEndResponsequeuename;
        @Value("${rabbitmq.parkingEndResponse.routingkey.name}")
        String parkingEndResponseRoutingKeyName;
        @Bean
        public Queue parkingStartresponsequeue() {
            return new Queue(parkingStartResponsequeuename, true) {
            };

        }
        @Bean
        public Queue parkingEndresponsequeue() {
            return new Queue(parkingEndResponsequeuename, true) {};
        }
        @Bean
        public DirectExchange exchange() {
            return new DirectExchange(exchangeName);
        }

        @Bean
        public Binding parkingStartresponseBinding(Queue parkingStartResponsequeuename, DirectExchange exchange) {
            return BindingBuilder.bind(parkingStartResponsequeuename).to(exchange).with(parkingStartResponseRoutingKeyName);
        }
        @Bean
        public Binding parkingEndResponseBinding(Queue parkingEndResponsequeuename, DirectExchange exchange) {
            return BindingBuilder.bind(parkingEndResponsequeuename).to(exchange).with(parkingEndResponseRoutingKeyName);
        }
        @Bean
        public MessageConverter JsonMessageConverter() {
            return new Jackson2JsonMessageConverter();
        }
        @Bean
        public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
            final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
            rabbitTemplate.setMandatory(true);
            rabbitTemplate.setMessageConverter(JsonMessageConverter());
            return rabbitTemplate;
        }
    }


}
