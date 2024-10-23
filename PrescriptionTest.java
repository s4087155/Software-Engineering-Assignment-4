import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.FileWriter;


public class PrescriptionTest {
    
    Prescription prescription;
    FileWriter fileWriter;
    FileWriter fileWriter2;
    
    @Before
    public void setUp() throws Exception {
        prescription = new Prescription();
         
     

    }

    //Data Set 1

    // Valid prescription
    @Test
    public void testValidPrescription() throws Exception {
        prescription.setFirstName("Klaus");
        prescription.setLastName("Mikaelson");
        prescription.setAddress("615 Pere Antoine Alley, New Orleans, LA 70116, USA");
        prescription.setSphere(12.00f);
        prescription.setCylinder(2.00f);
        prescription.setAxis(82);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
        prescription.setExaminationDate(dateFormat.parse("03-10-13"));
        prescription.setOptometrist("Dr. O'Connell");
        
        assertTrue(Prescription.addPrescription());
    }

    // First name too short
    @Test
    public void testFirstNameTooShort() {
        prescription.setFirstName("Nik");  // Less than 5 characters
        prescription.setLastName("Mikaelson");
        prescription.setAddress("615 Pere Antoine Alley, New Orleans, LA 70116, USA");
        prescription.setSphere(12.00f);
        prescription.setCylinder(2.00f);
        prescription.setAxis(82);
        prescription.setExaminationDate(new Date());
        prescription.setOptometrist("Dr. O'Connell");
        
        assertFalse(Prescription.addPrescription());
    }

    // First name too long
    @Test
    public void testFirstNameTooLong() {
        prescription.setFirstName("Niklaus Anselson");  // Exceeds 15 characters
        prescription.setLastName("Mikaelson");
        prescription.setAddress("615 Pere Antoine Alley, New Orleans, LA 70116, USA");
        prescription.setSphere(12.00f);
        prescription.setCylinder(2.00f);
        prescription.setAxis(82);
        prescription.setExaminationDate(new Date());
        prescription.setOptometrist("Dr. Cami O'Connell");
        
        assertFalse(Prescription.addPrescription());
    }

    // Last name too short
    @Test
    public void testLastNameTooShort() {
        prescription.setFirstName("Klaus");
        prescription.setLastName("Mik");  // Less than 5 characters
        prescription.setAddress("615 Pere Antoine Alley, New Orleans, LA 70116, USA");
        prescription.setSphere(12.00f);
        prescription.setCylinder(2.00f);
        prescription.setAxis(82);
        prescription.setExaminationDate(new Date());
        prescription.setOptometrist("Dr. Cami O'Connell");
        
        assertFalse(Prescription.addPrescription());
    }

    // Sphere out of range
    @Test
    public void testSphereOutOfRange() {
        prescription.setFirstName("Klaus");
        prescription.setLastName("Mikaelson");
        prescription.setAddress("615 Pere Antoine Alley, New Orleans, LA 70116, USA");
        prescription.setSphere(-21.00f);  // Invalid sphere value
        prescription.setCylinder(2.00f);
        prescription.setAxis(82);
        prescription.setExaminationDate(new Date());
        prescription.setOptometrist("Dr. Cami O'Connell");
        
        assertFalse(Prescription.addPrescription());
    }

    // Examination date is null
    @Test
    public void testExaminationDateNull() {
        prescription.setFirstName("Klaus");
        prescription.setLastName("Mikaelson");
        prescription.setAddress("615 Pere Antoine Alley, New Orleans, Louisiana 70116, USA");
        prescription.setSphere(-2.00f);
        prescription.setCylinder(2.00f);
        prescription.setAxis(82);
        prescription.setExaminationDate(null);  // Examination date is not provided
        prescription.setOptometrist("Dr. Cami O'Connell");
        
        assertFalse(Prescription.addPrescription());
    }



//Data Set 2

    // Valid prescription
    @Test
    public void testValidPrescription2() throws Exception {
        prescription.setFirstName("Elena");
        prescription.setLastName("Gilbert");
        prescription.setAddress("2104 Maple Street, Mystic Falls, Virginia 5520 , USA");
        prescription.setSphere(-4.00f);
        prescription.setCylinder(1.30f);
        prescription.setAxis(55);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
        prescription.setExaminationDate(dateFormat.parse("10-09-09"));
        prescription.setOptometrist("Dr. Katherine Pierce");
        
        assertTrue(Prescription.addPrescription());
    }

    // First name too short
    @Test
    public void testFirstNameTooShort2() {
        prescription.setFirstName("Ele");  // Less than 5 characters
        prescription.setLastName("Gilbert");
        prescription.setAddress("2104 Maple Street, Mystic Falls, Virginia 5520 , USA");
        prescription.setSphere(-4.00f);
        prescription.setCylinder(1.30f);
        prescription.setAxis(55);
        prescription.setExaminationDate(new Date());
        prescription.setOptometrist("Dr. Katherine Pierce");
        
        
        assertFalse(Prescription.addPrescription());
    }

    // First name too long
    @Test
    public void testFirstNameTooLong2() {
        prescription.setFirstName("Elena Marionette Rose");  // Exceeds 15 characters
        prescription.setLastName("Gilbert");
        prescription.setAddress("2104 Maple Street, Mystic Falls, Virginia 5520 , USA");
        prescription.setSphere(-4.00f);
        prescription.setCylinder(1.30f);
        prescription.setAxis(55);
        prescription.setExaminationDate(new Date());
        prescription.setOptometrist("Dr. Katherine Pierce");
        
        assertFalse(Prescription.addPrescription());
    }

    // Last name too short
    @Test
    public void testLastNameTooShort2() {
        prescription.setFirstName("Elena");
        prescription.setLastName("Gi");  // Less than 5 characters
        prescription.setAddress("2104 Maple Street, Mystic Falls, Virginia 5520 , USA");
        prescription.setSphere(-4.00f);
        prescription.setCylinder(1.30f);
        prescription.setAxis(55);
        prescription.setExaminationDate(new Date());
        prescription.setOptometrist("Dr. Katherine Pierce");
        
        assertFalse(Prescription.addPrescription());
    }

    // Sphere out of range
    @Test
    public void testSphereOutOfRange2() {
        prescription.setFirstName("Elena");
        prescription.setLastName("Gilbert");
        prescription.setAddress("2104 Maple Street, Mystic Falls, Virginia 5520 , USA");
        prescription.setSphere(74.00f);  // Invalid sphere value
        prescription.setCylinder(1.30f);
        prescription.setAxis(55);
        prescription.setExaminationDate(new Date());
        prescription.setOptometrist("Dr. Katherine Pierce");
        
        assertFalse(Prescription.addPrescription());
    }

    // Examination date is null
    @Test
    public void testExaminationDateNull2() {
        prescription.setFirstName("Elena");
        prescription.setLastName("Gilbert");
        prescription.setAddress("2104 Maple Street, Mystic Falls, Virginia 5520 , USA");
        prescription.setSphere(-4.00f);
        prescription.setCylinder(1.30f);
        prescription.setAxis(55);
        prescription.setExaminationDate(null);  // Examination date is not provided
        prescription.setOptometrist("Dr. Katherine Pierce");
        
        assertFalse(Prescription.addPrescription());
    }
}


