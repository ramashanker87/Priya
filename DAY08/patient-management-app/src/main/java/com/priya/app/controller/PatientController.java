package com.priya.app.controller;


import com.priya.app.model.Patient;
import com.priya.app.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/patient")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/get/all/patient")
    public Map<String, Patient> getAllPatients() {
        return patientService.readAllPatient();
    }

    @GetMapping("/get/patient")
    public static void getAllPatientByName() {
    }

    @PostMapping("/create/patient")
    public Patient createPatients(@RequestBody Patient patient) {
        return patientService.createPatient(patient);
    }

    @PutMapping("/update/patient")
    public Patient updatePatient(@RequestParam("id") String id, @RequestParam("hospitalName") String hospitalName) {
    return  patientService.updatePatient(id,hospitalName);
    }
@DeleteMapping("/delete/patient")
    public void deletePatient(@RequestParam("id") String id){
 patientService.deletePatient(id);
}
}





