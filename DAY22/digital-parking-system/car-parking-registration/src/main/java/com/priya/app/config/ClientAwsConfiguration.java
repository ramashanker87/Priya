 package com.priya.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.core.*;


@Configuration

public class ClientAwsConfiguration {
  private final AwsCredentials awsCredentials;



    public ClientAwsConfiguration(AwsCredentials awsCredentials) {
        this.awsCredentials = awsCredentials;
    }

@Bean
  public DynamoDbClient dynamoDbClient() {
    return DynamoDbClient
        .builder()
        .region(Region.of("eu-west-1"))
            .credentialsProvider(DefaultCredentialsProvider.create()) // Automatically use default credentials

        .build();
  }
}
