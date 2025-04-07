package dao;

import database.DatabaseConnection;
import model.Patient;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {

    public void addPatient(Patient patient) throws SQLException {
        String sqlStatement = "INSERT INTO patients (first_name, last_name, sex, dob, street, city, state, zipcode," +
                "phone, email, emergency_contact, emergency_phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(sqlStatement)){

            statement.setString(1, patient.getFirstName());
            statement.setString(2, patient.getLastName());
            statement.setString(3, patient.getSex());
            statement.setDate(4, Date.valueOf(patient.getDob()));
            statement.setString(5, patient.getStreet());
            statement.setString(6, patient.getCity());
            statement.setString(7, patient.getState());
            statement.setString(8, patient.getZipcode());
            statement.setString(9, patient.getPhone());
            statement.setString(10, patient.getEmail());
            statement.setString(11, patient.getEmergencyContact());
            statement.setString(12, patient.getEmergencyPhone());

            statement.executeUpdate();
        }
    }

    public void updateFirstName(int patientId, String newFirstName) throws SQLException {
        String sqlStatement = "UPDATE patients SET first_name = ? WHERE patient_id = ?";

        try (Connection connection = DatabaseConnection.connect();
            PreparedStatement statement = connection.prepareStatement(sqlStatement)) {

            statement.setString(1, newFirstName);
            statement.setInt(2, patientId);

            int updated = statement.executeUpdate();

            if(updated > 0) {
                System.out.println("Successfully updated patient first name.");
            } else {
                System.out.println("Could not update patient record.");
            }

        }
    }

    public void updateLastName(int patientId, String newLastName) throws SQLException {
        String sqlStatement = "UPDATE patients SET last_name = ? WHERE patient_id = ?";

        try (Connection connection = DatabaseConnection.connect();
            PreparedStatement statement = connection.prepareStatement(sqlStatement)) {

            statement.setString(1, newLastName);
            statement.setInt(2, patientId);

            int updated = statement.executeUpdate();

            if (updated > 0) {
                System.out.println("Successfully updated patient last name.");
            } else {
                System.out.println("Could not update patient record.");
            }
        }
    }

    public void updateAddress(int patientId, String street, String city, String state, String zip) throws SQLException {

        String sqlStatement = "UPDATE patients SET street = ?, city = ?, state = ?, zipcode = ? WHERE patient_id = ?";

        try (Connection connection = DatabaseConnection.connect();
            PreparedStatement statement = connection.prepareStatement(sqlStatement)){

            statement.setString(1, street);
            statement.setString(2, city);
            statement.setString(3, state);
            statement.setString(4, zip);
            statement.setInt(5, patientId);

            int updated = statement.executeUpdate();

            if(updated > 0) {
                System.out.println("Successfully update patient address.");
            } else {
                System.out.println("Could not update patient record.");
            }
        }

    }

    public void updatePhone(int patientId, String phone) throws SQLException {
        String sqlStatement = "UPDATE patients SET phone = ? WHERE patient_id = ?";

        try (Connection connection = DatabaseConnection.connect();
            PreparedStatement statement = connection.prepareStatement(sqlStatement)) {
            statement.setString(1, phone);
            statement.setInt(2, patientId);

            int updated = statement.executeUpdate();

            if(updated > 0) {
                System.out.println("Successfully updated patient address.");
            } else {
                System.out.println("Could not update patient record.");
            }
        }

    }

    public void updateContact(int patientId, String name, String emergencyPhone) throws SQLException {
        String sqlStatement = "UPDATE patients SET emergency_contact = ?, emergency_phone = ? WHERE patient_id = ?";

        try(Connection connection = DatabaseConnection.connect();
            PreparedStatement statement = connection.prepareStatement(sqlStatement)){
            statement.setString(1, name);
            statement.setString(2, emergencyPhone);
            statement.setInt(3, patientId);

            int updated = statement.executeUpdate();

            if(updated > 0){
                System.out.println("Successfully updated patient address.");
            } else {
                System.out.println("Could not update patient record.");
            }
        }
    }

    public void deletePatientRecord(int patientId) throws SQLException {
        String sqlStatement = "DELETE FROM patients WHERE patient_id = ?";

        try (Connection connection = DatabaseConnection.connect();
            PreparedStatement statement = connection.prepareStatement(sqlStatement)){
            statement.setInt(1, patientId);

            int deleted = statement.executeUpdate();

            if(deleted > 0){
                System.out.println("Patient record was successfully deleted from database.");
            } else {
                System.out.println("Could not delete patient record.");
            }
        }

    }

    public void lookupPatient(String firstName, String lastName) throws SQLException {
        String sqlStatement = "SELECT patient_id, first_name, last_name, sex, dob, street, city, state, zipcode, phone," +
                "email, emergency_contact, emergency_phone FROM patients WHERE " +
                "LOWER(patients.first_name) = ? AND LOWER(patients.last_name) = ?";

        try(Connection connection = DatabaseConnection.connect();
            PreparedStatement statement = connection.prepareStatement(sqlStatement)) {
            statement.setString(1, firstName.toLowerCase());
            statement.setString(2, lastName.toLowerCase());


            ResultSet result = statement.executeQuery();
            int resultCount = 0;
            while (result.next()) {
                int id = result.getInt("patient_id");
                String firstname = result.getString("first_name");
                String lastname = result.getString("last_name");
                String sex = result.getString("sex");
                LocalDate dob = result.getDate("dob").toLocalDate();
                String street = result.getString("street");
                String city = result.getString("city");
                String state = result.getString("state");
                String zip = result.getString("zipcode");
                String phone = result.getString("phone");
                String email = result.getString("email");
                String emergencyContact = result.getString("emergency_contact");
                String emergencyPhone = result.getString("emergency_phone");

                resultCount++;

                System.out.println(resultCount + " patient(s) found.");
                System.out.println();
                System.out.println("Patient id: " + id + "\n" +
                        "First name: " + firstname + "\n" +
                        "Last name: " + lastname + "\n" +
                        "Sex: " + sex + "\n" +
                        "DOB: " + dob + "\n" +
                        "Address: " + street + " " + city + ", " + state + " " + zip + "\n" +
                        "Phone: " + phone + "\n" +
                        "Email: " + email + "\n" +
                        "Emergency contact: " + emergencyContact + "\n" +
                        "Emergency phone: " + emergencyPhone + "\n" +
                        "-------------------------------------------------------------------");

            }

            if(resultCount == 0){
                System.out.println(resultCount + " patient(s) found.");
            }

        } catch (SQLException e) {
//            System.out.println("Patient not found in database.");
            e.printStackTrace();
        }

    }

    public List<Patient> getAllPatients() throws SQLException {
        List<Patient> patients = new ArrayList<>();

        String sqlStatement = "SELECT * FROM patients ORDER BY patient_id";

        try (Connection connection = DatabaseConnection.connect();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(sqlStatement)){


            while(result.next()){
                int id = result.getInt("patient_id");
                String firstname = result.getString("first_name");
                String lastname = result.getString("last_name");
                String sex = result.getString("sex");
                LocalDate dob = result.getDate("dob").toLocalDate();
                String street = result.getString("street");
                String city = result.getString("city");
                String state = result.getString("state");
                String zip = result.getString("zipcode");
                String phone = result.getString("phone");
                String email = result.getString("email");
                String emergencyContact = result.getString("emergency_contact");
                String emergencyPhone = result.getString("emergency_phone");


                patients.add(new Patient(id, firstname, lastname, sex, dob, street, city, state, zip, phone, email, emergencyContact, emergencyPhone));

            }
        }

        return patients;
    }


}
