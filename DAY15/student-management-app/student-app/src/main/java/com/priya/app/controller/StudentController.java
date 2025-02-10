package com.priya.app.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@RestController
@RequestMapping("/student")

public class StudentController {
    private static final Logger LOGGER =(Logger) LoggerFactory.getLogger(StudentController.class);

    private final RestTemplate restTemplate;

    public StudentController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Value("${get.receive.url}")
    String receivegetUrl; //http://localhost:10082/receiver/get

    @Value("${post.receive.url}")
    String receivepostUrl; //http://localhost:10082/receiver/post

    @Value("${put.receive.url}")
    String receiveputUrl; //http://localhost:10082/receiver/put

    @Value("${delete.receive.url}")
    String receivedeleteUrl; //http://localhost:10082/receiver/delete


    @GetMapping("/read")
    public String getDetail() {

        ResponseEntity<String> response
                = restTemplate.exchange(receivegetUrl,HttpMethod.GET, null,String.class);
        LOGGER.info(response.getStatusCode().toString());
        LOGGER.info(response.getBody());
        return response.getBody();
    }

    @PostMapping("/save")
    public String postDetail() {
        ResponseEntity<String> response
                = restTemplate.exchange(receivepostUrl, HttpMethod.POST,null, String.class);
        LOGGER.info(response.getStatusCode().toString());
        LOGGER.info(response.getBody());
        return response.getBody();
    }

    @PutMapping ("/update")
    public String putDetail() {
        ResponseEntity<String> response
                = restTemplate.exchange(receiveputUrl, HttpMethod.PUT,null, String.class);
        LOGGER.info(response.getStatusCode().toString());
        LOGGER.info(response.getBody());
        return response.getBody();
    }

    @DeleteMapping("/delete")
    public String deleteDetail() {
        ResponseEntity<String> response
                = restTemplate.exchange(receivedeleteUrl, HttpMethod.DELETE,null, String.class);
        LOGGER.info(response.getStatusCode().toString());
        LOGGER.info(response.getBody());
        return response.getBody();
    }

}
