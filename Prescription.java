import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class Prescription {

    private static int prescID;
    private static String firstName;
    private static String lastName;
    private static String address;
    private static float sphere;
    private static float axis;
    private static float cylinder;
    private static Date examinationDate;
    private static String optometrist;
    private String[] remarkTypes = {"Client", "Optometrist"};
    private static ArrayList<String> postRemarks = new ArrayList<>();

    public Prescription() {
        Prescription.prescID = generatePrescID(); // Generate prescID when the object is created
    }

    private int generatePrescID() {
        Random random = new Random();
        // Generate a random number between 10000000 and 99999999
        return 10000000 + random.nextInt(90000000); 
    }

    public int getPrescID() {
        return prescID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        Prescription.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        Prescription.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        Prescription.address = address;
    }

    public float getSphere() {
        return sphere;
    }

    public void setSphere(float sphere) {
        Prescription.sphere = sphere;
    }

    public float getAxis() {
        return axis;
    }

    public void setAxis(float axis) {
        Prescription.axis = axis;
    }

    public float getCylinder() {
        return cylinder;
    }

    public void setCylinder(float cylinder) {
        Prescription.cylinder = cylinder;
    }

    public Date getExaminationDate() {
        return examinationDate;
    }

    public void setExaminationDate(Date examinationDate) {
        Prescription.examinationDate = examinationDate;
    }

    public String getOptometrist() {
        return optometrist;
    }

    public void setOptometrist(String optometrist) {
        Prescription.optometrist = optometrist;
    }

    public String[] getRemarkTypes() {
        return remarkTypes;
    }

    public ArrayList<String> getPostRemarks() {
        return postRemarks;
    }

    public static void main(String[] args) throws ParseException {

        Scanner scanner = new Scanner(System.in);
        Prescription prescription = new Prescription(); // Create an instance of Prescription
    
        // Get user details
        System.out.println("Please Enter your first and last name (minimum of 4 characters and a maximum of 15 characters) ");
        prescription.firstName = scanner.next();
        prescription.lastName = scanner.next();
        scanner.nextLine(); // Clear the newline
    
        System.out.println("Please enter your address (minimum of 20 characters): ");
        prescription.address = scanner.nextLine();
    
        System.out.println("Please enter the date in this format: DD-MM-YY");
        String date = scanner.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
        prescription.examinationDate = dateFormat.parse(date);
    
        System.out.println("In the following format what are the numbers for the sphere (-20.00 and +20.00), cylinder(-4.00 to +4.00), axis (0 and 180): ");
        prescription.sphere = scanner.nextFloat();
        prescription.cylinder = scanner.nextFloat();
        prescription.axis = scanner.nextFloat();
        scanner.nextLine(); // Clear the newline

        System.out.println("Who is the optometrist? (minimum of 8 and maximum of 25 characters)");
        prescription.optometrist = scanner.nextLine();

        // Add the prescription to the file
        if (addPrescription()) {
            System.out.println("Prescription details saved successfully.");

            // Ask for remark details
            System.out.println("What type of remark would you like to write: A) Client or B) Optometrist");
            String remarkTypeInput = scanner.nextLine();
            String remarkType = remarkTypeInput.equalsIgnoreCase("A") ? "Client" : "Optometrist";

            System.out.println("Please enter your remark (minimum of 6 words and a maximum of 20 words): ");
            String remark = scanner.nextLine();

            // Add remark to the file
            if (addRemark(remarkType, remark)) {
                System.out.println("Remark added successfully.");
            } else {
                System.out.println("Failed to add the remark.");
            }
        } else {
            System.out.println("Failed to add prescription details.");
        }

        scanner.close();
    }

    public static boolean addPrescription() {
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("presc.txt", false))) {
            // Passing 'false' to FileWriter will overwrite the file, effectively clearing it
            writer.write(""); // Write an empty string to clear the file
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        // Validate and write prescription details to file
        if (firstName.length() >= 5 && firstName.length() <= 15) { 
            if (lastName.length() >= 5 && lastName.length() <= 15) {
                if (address.length() >= 20) {
                    if (sphere >= -20.00 && sphere <= 20.00 && cylinder >= -4.00 && cylinder <= 4.00 && axis >= 0 && axis <= 180) {
                        if (examinationDate != null) {
                            if (optometrist.length() >= 8 && optometrist.length() <= 25) {
                                // All fields are valid, so let's write the prescription to the file
                                try {
                                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("presc.txt", true)); // true for append mode
                                    
                                    // Write prescription details to the file
                                    bufferedWriter.write("Prescription ID: " + prescID);
                                    bufferedWriter.newLine();
                                    bufferedWriter.write("Name: " + firstName + " " + lastName);
                                    bufferedWriter.newLine();
                                    bufferedWriter.write("Address: " + address);
                                    bufferedWriter.newLine();
                                    bufferedWriter.write("Sphere: " + sphere + ", Cylinder: " + cylinder + ", Axis: " + axis);
                                    bufferedWriter.newLine();
                                    bufferedWriter.write("Examination Date: " + examinationDate);
                                    bufferedWriter.newLine();
                                    bufferedWriter.write("Optometrist: " + optometrist);
                                    bufferedWriter.newLine();
                                    bufferedWriter.newLine(); // Add an extra line for readability
                                    
                                    bufferedWriter.close(); // Close the writer
                                    return true;
                                } catch (IOException e) {
                                    e.printStackTrace();
                                    return false;
                                }
                            } else {
                                System.out.println("Optometrist name length is invalid.");
                                return false;
                            }
                        } else {
                            System.out.println("Examination date is null.");
                            return false;
                        }
                    } else {
                        System.out.println("Sphere, cylinder, or axis values are out of range.");
                        return false;
                    }
                } else {
                    System.out.println("Address length is too short.");
                    return false;
                }
            } else {
                System.out.println("Last name length is invalid.");
                return false;
            }
        } else {
            System.out.println("First name length is invalid.");
            return false;
        }
    }

    public static boolean addRemark(String remarkType, String remark) {
     
        int wordCount = remark.split("\\s+").length;

        // Validate remark: 6-20 words, starts with an uppercase letter, and correct remarkType
        if (wordCount >= 6 && wordCount <= 20 && Character.isUpperCase(remark.charAt(0))) {
            if (remarkType.equals("Client") || remarkType.equals("Optometrist")) {
                if (postRemarks.size() < 2) {  // Limit to 2 remarks
                    postRemarks.add(remark);  // Add the remark to the in-memory list

                    // Write the remark to the file
                    try {
                        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("presc.txt", true)); // Append mode
                        bufferedWriter.write(remarkType + " Remark: " + remark);
                        bufferedWriter.newLine();
                        bufferedWriter.close(); // Close the writer

                        return true;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return false;
                    }
                } else {
                    System.out.println("Maximum number of remarks reached.");
                    return false;
                }
            } else {
                System.out.println("Invalid remark type. Must be 'Client' or 'Optometrist'.");
                return false;
            }
        } else {
            System.out.println("Invalid remark format. Remark must be 6 to 20 words and start with an uppercase letter.");
            return false;
        }
    }
}

