import model.Patient;
import org.junit.Test;

import java.time.LocalDate;

import static junit.framework.TestCase.assertEquals;

public class patientTest {

    @Test
    public void testPatientGettersAndSetters(){
        Patient patient = new Patient();
        patient.setPatientId(1);
        patient.setFirstName("John");
        patient.setLastName("Doe");
        patient.setSex("M");
        patient.setDob(LocalDate.parse("2000-12-20"));
        patient.setStreet("123 Main St");
        patient.setCity("Chicago");
        patient.setState("IL");
        patient.setZipcode("60007");
        patient.setPhone("000-000-0000");
        patient.setEmail("johndoe@gmail.com");
        patient.setEmergencyContact("Jane Doe");
        patient.setEmergencyPhone("111-111-1111");

        assertEquals(1, patient.getPatientId());
        assertEquals("John", patient.getFirstName());
        assertEquals("Doe", patient.getLastName());
        assertEquals("M", patient.getSex());
        assertEquals("2000-12-20", patient.getDob().toString());
        assertEquals("123 Main St", patient.getStreet());
        assertEquals("Chicago", patient.getCity());
        assertEquals("IL", patient.getState());
        assertEquals("60007", patient.getZipcode());
        assertEquals("000-000-0000", patient.getPhone());
        assertEquals("johndoe@gmail.com", patient.getEmail());
        assertEquals("Jane Doe", patient.getEmergencyContact());
        assertEquals("111-111-1111", patient.getEmergencyPhone());


    }


}
