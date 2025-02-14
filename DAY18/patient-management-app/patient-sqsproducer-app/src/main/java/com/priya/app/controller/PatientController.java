package com.priya.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.priya.app.model.Patient;
import com.priya.app.service.PatientSqsService;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientSqsService patientSqsService;
    private final ObjectMapper objectMapper;

    public PatientController(PatientSqsService patientSqsService, ObjectMapper objectMapper) {
        this.patientSqsService = patientSqsService;
        this.objectMapper = objectMapper;
    }
    @PostMapping("/send")
    public String sendMessage(@RequestBody Patient patient, @RequestHeader("disease") String disease) throws JsonProcessingException {
        Map<String, Object> headers = new HashMap<>();
        String correlationId = UUID.randomUUID().toString();
        headers.put("disease", disease);
        String requestMessage = objectMapper.writeValueAsString(patient);
        patientSqsService.sendMessage(requestMessage, headers);
        return disease;

    }

}
