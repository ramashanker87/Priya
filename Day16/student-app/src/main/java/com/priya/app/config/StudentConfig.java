package com.priya.app.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import java.time.Duration;
@Configuration
public class StudentConfig {


    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder)
        {
           return builder.build();

        }

}
