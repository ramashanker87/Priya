package com.priya.app.service;

import com.priya.app.model.Patient;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Map;



@RunWith(MockitoJUnitRunner.class)
public class PatientServiceTest {
    @InjectMocks
    PatientService patientService;

    @Test
    public void testCreatePatient() {
        Patient patient = new Patient("patient1", "p1", "hospital1", 55, "M");
        Patient exceptedPatient = patientService.createPatient(patient);
        assert exceptedPatient != null;
        assert exceptedPatient.getId() == patient.getId();
        assert exceptedPatient.getName() == patient.getName();
        assert exceptedPatient.getAge() == patient.getAge();
        assert exceptedPatient.getHospitalName() == patient.getHospitalName();
        assert exceptedPatient.getGender() == patient.getGender();

    }
    @Test
    public void testUpdatePatient(){
     Patient patient1 = new Patient("patient1", "p1", "hospital1", 55, "M");
        Patient expectedPatient=patientService.createPatient(patient1);
        Patient resultPatient=patientService.updatePatient(patient1.getHospitalName(),"hospital4");
        assert resultPatient != null;
        assert resultPatient.getId()== patient1.getId();
        assert resultPatient.getName()== patient1.getName();
        assert resultPatient.getAge()==patient1.getAge();
        assert resultPatient.getHospitalName()=="hospital4";
        assert resultPatient.getGender()== patient1.getGender();

    }
    @Test
    public void testDeletePatient() {
        Patient patient1 = new Patient("patient1", "p1", "hospital1", 55, "M");
        Patient expectedEmployee=patientService.createPatient(patient1);
        patientService.deletePatient(patient1.getName());
        Patient expectedResult=patientService.readPatientByName(patient1.getName());
        assert expectedResult== null;
    }

    @Test
    public void testReadPatientsBYName() {
        Patient patient1 = new Patient("patient1", "p1", "hospital1", 55, "M");
        Patient actualPatient=patientService.createPatient(patient1);
        Patient expectedResult=patientService.readPatientByName(patient1.getId());
        assert expectedResult != null;
        assert expectedResult.getId()== actualPatient.getId();
        assert expectedResult.getName()== actualPatient.getName();
        assert expectedResult.getAge()== actualPatient.getAge();
        assert expectedResult.getHospitalName()== actualPatient.getHospitalName();
        assert expectedResult.getGender()== actualPatient.getGender();
    }

@Test
    public void testReadAllPatients(){
    Patient patient1 = new Patient("patient1", "p1", "hospital1", 55, "M");
    Patient patient2 = new Patient("patient2", "p2", "hospital2", 46, "F");
    Patient patient3 = new Patient("patient3", "p3", "hospital3", 34, "M");
    patientService.createPatient(patient1);
    patientService.createPatient(patient2);
    patientService.createPatient(patient3);
    Map<String, Patient> resultPatients = patientService.readAllPatient();
    assert resultPatients.size()==3;
    assert resultPatients.containsKey(patient1.getId());
    assert resultPatients.containsKey(patient2.getId());
    assert resultPatients.containsKey(patient3.getId());

}

    }

