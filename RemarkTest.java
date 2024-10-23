import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class RemarkTest {
    
    Prescription prescription;
    
    @Before
    public void setUp() throws Exception {
        prescription = new Prescription();
        prescription.getPostRemarks().clear(); // Clear remarks before each test
    }

    // Data Set 1

    // Valid remarks
    @Test
    public void testValidRemark() {
        assertTrue(Prescription.addRemark("Client", "Ensure the lenses are durable; I can't afford any distractions during my... quarrels."));
        assertTrue(Prescription.addRemark("Optometrist", "Patient exhibits good vision; recommend regular check-ups to monitor any changes in prescription."));
    }

    // Remark too short
    @Test
    public void testRemarkTooShort() {
        assertFalse(Prescription.addRemark("Client", "Ensure sharp vision for meetings."));  // Less than 6 words
        assertFalse(Prescription.addRemark("Optometrist", "Always prioritize eye protection."));  // Less than 6 words
    }

    // Remark too long
    @Test
    public void testRemarkTooLong() {
        assertFalse(Prescription.addRemark("Client", "Please ensure the prescription is tailored specifically to my unique needs. My vision has always been a matter of great importance."));
        assertFalse(Prescription.addRemark("Optometrist", "As Klaus's optometrist, I recommend regular check-ups. Given his unique history, personalized care is essential for optimal eye health and comfort."));
    }

    // Remark doesn't start with uppercase
    @Test
    public void testRemarkNotUppercase() {
        assertFalse(Prescription.addRemark("Client", "ensure my vision remains sharp for any unforeseen challenges ahead."));  // Doesn't start with an uppercase letter
        assertFalse(Prescription.addRemark("Optometrist", "keep an eye on changes; your health is just as important as your vision."));  // Doesn't start with an uppercase letter
    }

    // Invalid remark type
    @Test
    public void testInvalidRemarkType() {
        assertFalse(Prescription.addRemark("Friendly", "Ensure lenses enhance my vision for clarity and precision in every detail."));  // Invalid remark type
        assertFalse(Prescription.addRemark("Psycologist", "Klaus requires specialized lenses to accommodate his unique visual needs and enhance his overall sight quality."));  // Invalid remark type
    }

    // More than two remarks
    @Test
    public void testMoreThanTwoRemarks() {
        // Adding two valid remarks first
        Prescription.addRemark("Client", "Vision feels blurry at night; need sharper lenses for clarity.");
        Prescription.addRemark("Optometrist", "Klaus, remember to take breaks and relax your eyes.");

        // Attempt to add a third remark, should fail
        assertFalse(Prescription.addRemark("Client", "Ensure my vision is sharp; I can't afford any weakness."));
    }

    // Data Set 2

    // Valid remarks
    @Test
    public void testValidRemark2() {
        assertTrue(Prescription.addRemark("Client", "Looking for better comfort with my new lenses, please recommend options for sensitivity."));
        assertTrue(Prescription.addRemark("Optometrist", "Patient reported discomfort with current lenses; recommend a thorough examination for optimal fit and prescription adjustment."));
    }

    // Remark too short
    @Test
    public void testRemarkTooShort2() {
        assertFalse(Prescription.addRemark("Client", "Need to see clearer, please."));  // Less than 6 words
        assertFalse(Prescription.addRemark("Optometrist", "Ensure proper fitting for comfort."));  // Less than 6 words
    }

    // Remark too long
    @Test
    public void testRemarkTooLong2() {
        assertFalse(Prescription.addRemark("Client", "I've been experiencing occasional headaches and blurry vision, especially after long hours of studying or using my phone. Please ensure the prescription is accurate."));
        assertFalse(Prescription.addRemark("Optometrist", "Elena has reported increased sensitivity to light and difficulty focusing during extended reading sessions. It's crucial to monitor her vision closely for any changes."));
    }

    // Remark doesn't start with uppercase
    @Test
    public void testRemarkNotUppercase2() {
        assertFalse(Prescription.addRemark("Client", "please ensure the lenses enhance clarity for reading and driving. Thank you!"));  // Doesn't start with an uppercase letter
        assertFalse(Prescription.addRemark("Optometrist", "ensure lenses provide optimal comfort and clarity for prolonged use. Regular check-ups are advised."));  // Doesn't start with an uppercase letter
    }

    // Invalid remark type
    @Test
    public void testInvalidRemarkType2() {
        assertFalse(Prescription.addRemark("Blogger", "Vision feels slightly blurry; please ensure the prescription is accurate for my upcoming events."));  // Invalid remark type
        assertFalse(Prescription.addRemark("President", "Patient shows signs of strain; recommend regular check-ups and follow-up on any discomfort."));  // Invalid remark type
    }

    // More than two remarks
    @Test
    public void testMoreThanTwoRemarks2() {
        // Adding two valid remarks first
        Prescription.addRemark("Client", "Looking forward to clear vision for my studies and daily activities.");
        Prescription.addRemark("Optometrist", "Ensure Elena follows up regularly to monitor her vision and any changes. Consistency is key for optimal eye health.");

        // Attempt to add a third remark, should fail
        assertFalse(Prescription.addRemark("Client", "I really need these glasses to be perfect! I can't stand anything less than flawless!"));
    }
}
