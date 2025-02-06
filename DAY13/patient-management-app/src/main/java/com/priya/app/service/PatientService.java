package com.priya.app.service;

import com.priya.app.model.Patient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PatientService {
    Map<String, Patient> patients = new HashMap<>();
    public  Patient createPatient(Patient patient){
        patients.put(patient.getId(),patient);
        return patient;
    }
 public Patient updatePatient(String hostipalName,String newHospitalName){
        Patient patient1= patients.get(hostipalName);
        patient1.setHospitalName(newHospitalName);
        return patient1;
    }

public void deletePatient(String id){patients.remove(id);}

public Patient readPatientByName(String Name){
    Patient result=patients.get(Name);
    return result;

    }
 public Map<String,Patient>  readAllPatient()
 {return patients;
 }
}

