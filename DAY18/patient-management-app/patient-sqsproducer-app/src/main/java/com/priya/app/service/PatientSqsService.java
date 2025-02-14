package com.priya.app.service;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PatientSqsService {
    private static final Logger log = LoggerFactory.getLogger(PatientSqsService.class);
    private final SqsTemplate sqsTemplate;
    @Value("${amazon.aws.sqs.queue}")
    private String queue;

    public PatientSqsService(SqsTemplate sqsTemplate) {
        this.sqsTemplate = sqsTemplate;

    }
    public void sendMessage(String message, Map<String,Object> headers) {
        log.info("Sending message on queue: {} with message :{} headers: {}", queue,message,headers);
        this.sqsTemplate
                .send(queue,
                        MessageBuilder.withPayload(message)
                                .copyHeaders(headers).build());
    }
}
