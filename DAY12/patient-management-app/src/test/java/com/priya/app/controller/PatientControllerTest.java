package com.priya.app.controller;


import com.priya.app.model.Patient;
import com.priya.app.service.PatientService;
import com.priya.app.service.PatientServiceTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.HashMap;
import java.util.Map;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

@RunWith(MockitoJUnitRunner.class)
public class PatientControllerTest {
    @InjectMocks
    PatientController patientcontroller;
    @Mock
    PatientService patientService;

    @Test
    public void testgetallpatients() {
        Map<String, Patient> patientMap = new HashMap<>();
        Patient patient1 = new Patient("patient1", "p1", "hospital1", 55, "M");
        Patient patient2 = new Patient("patient2", "p2", "hospital2", 46, "F");
        Patient patient3 = new Patient("patient3", "p3", "hospital3", 34, "M");
        patientMap.put(patient1.getId(), patient1);
        patientMap.put(patient2.getId(), patient2);
        patientMap.put(patient2.getId(), patient3);
        when(patientService.readAllPatient()).thenReturn(patientMap);
        Map<String, Patient> patientResultMap = patientcontroller.getAllPatients();
        assert patientResultMap != null;
        assert patientResultMap.size() == 3;
        assert patientResultMap.get(patient1.getId()) == patient1;
        assert patientResultMap.get(patient2.getId()) == patient2;
        assert patientResultMap.get(patient3.getId()) == patient3;
    }

    @Test
    public void testCreatePatients() {
        Patient patient1 = new Patient("patient1", "p1", "hospital1", 55, "M");
        when(patientService.createPatient(patient1)).thenReturn(patient1);
        Patient resultPatient = patientcontroller.createPatients(patient1);
        assert resultPatient != null;
        assert resultPatient.getId() == patient1.getId();
        assert resultPatient.getName().equals("patient1");
        assert resultPatient.getAge() == 55;
        assert resultPatient.getHospitalName() == "hospital1";
        assert resultPatient.getGender() == "M";
    }

    @Test
    public void testUpdatePatients(){
        Patient patient1 = new Patient("patient1", "p1", "hospital1", 55, "M");
        Patient patient2 = new Patient("patient2", "p2", "hospital2", 46, "F");
        when(patientService.updatePatient(anyString(), String.valueOf(anyInt()))).thenReturn(patient2);
        Patient resultPatient=patientcontroller.updatePatient(patient1.getHospitalName(),"hospital4");
        assert resultPatient!=null;
        assert resultPatient.getId()==patient1.getId();
        assert resultPatient.getName().equals("patient2");
        assert resultPatient.getAge()==46;
        assert resultPatient.getHospitalName()=="hospital2";
        assert resultPatient.getGender()=="F";
    }
    @Test
    public void testDeletePatients() {
        doNothing().when(patientService).deletePatient(anyString());
        patientcontroller.deletePatient("patient1");
        verify(patientService,atLeast(1)).deletePatient(anyString());
    }
    @Test
    public void testGetPatientsByName() {
        PatientController.getAllPatientByName();
    }


}




