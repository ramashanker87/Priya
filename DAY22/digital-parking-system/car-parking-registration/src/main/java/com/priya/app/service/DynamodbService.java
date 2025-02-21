package com.priya.app.service;

import com.priya.app.exception.ParkingException;
import com.priya.app.model.ParkingStart;
import com.priya.app.model.ParkingStartTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemResponse;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class DynamodbService {
    private static final Logger logger = LoggerFactory.getLogger(DynamodbService.class);
    private final ParkingStart parkingStart;
    @Value("amazon.aws.dynamodb.parking.table")
    String parkingStartTable;
    private DynamoDbClient dynamoDbClient;
    public DynamodbService(DynamoDbClient dynamoDbClient, ParkingStart parkingStart) {

        this.parkingStart = parkingStart;
        this.dynamoDbClient = dynamoDbClient;
    }

    public ParkingStart storeParkingStart(String parkingNo, String Status, String regNo , Date startTime) throws ParkingException {
        logger.info("Retrieve parking status from dynamodb table:{}", parkingStartTable);
        Map<String, AttributeValue> item = new HashMap<>();
        item.put(ParkingStartTable.FIELD_PARKING_NO, AttributeValue.builder().s(parkingNo).build());
        item.put(ParkingStartTable.FIELD_START_TIME, AttributeValue.builder().s(String.valueOf(startTime)).build());
        item.put(ParkingStartTable.FIELD_STATUS, AttributeValue.builder().s(Status).build());
        item.put(ParkingStartTable.FIELD_REG_NO, AttributeValue.builder().s(regNo).build());
        PutItemRequest putItemRequest = PutItemRequest.builder()
                .tableName(parkingStartTable)
                .item(item)
                .build();
        try {
            PutItemResponse putItemResponse = dynamoDbClient.putItem(putItemRequest);
            logger.info(putItemResponse.toString());
        } catch (DynamoDbException e) {
            logger.error("Unable to add item in dynamodb table:{}", parkingStartTable, e);
            throw new ParkingException("Aws Dynamodb Data Store exception:" + e.getMessage());
        }
        return parkingStart;
}}
