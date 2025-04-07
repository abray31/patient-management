package dao;

import database.DatabaseConnection;
import model.Prescription;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PrescriptionDAO {

    public void addPrescription(Prescription prescription) throws SQLException {

        String sqlStatement = "INSERT INTO prescriptions (patient_id, medication_name, dosage, start_date, end_date," +
                "refills) VALUES (?, ?, ?, ?, ?, ?)";

        try(Connection connection = DatabaseConnection.connect();
            PreparedStatement statement = connection.prepareStatement(sqlStatement)){


            statement.setInt(1, prescription.getPatientId());
            statement.setString(2, prescription.getMedicationName());
            statement.setString(3, prescription.getDosage());
            statement.setDate(4, Date.valueOf(prescription.getStartDate()));
            statement.setDate(5, Date.valueOf(prescription.getEndDate()));
            statement.setString(6, prescription.getRefills());

            statement.executeUpdate();

        }
    }

    public void updateDosage(int id, String info) throws SQLException {
        String sqlStatement = "UPDATE prescriptions SET dosage = ? WHERE patient_id = ?";

        try(Connection connection = DatabaseConnection.connect();
            PreparedStatement statement = connection.prepareStatement(sqlStatement)){

            statement.setString(1, info);
            statement.setInt(2, id);

            int updated = statement.executeUpdate();

            if(updated > 0){
                System.out.println("Dosage successfully updated.");
            } else {
                System.out.println("Could not update prescription record.");
            }

        }
    }

    public void updateRefill(int id, String info) throws SQLException {
        String sqlStatement = "UPDATE prescriptions SET refills = ? WHERE patient_id = ?";

        try (Connection connection = DatabaseConnection.connect();
            PreparedStatement statement = connection.prepareStatement(sqlStatement)){

            statement.setString(1, info);
            statement.setInt(2, id);

            int updated = statement.executeUpdate();

            if(updated > 0){
                System.out.println("Refill info successfully updated.");
            } else {
                System.out.println("Could not update prescription record.");
            }
        }
    }

    public void deletePrescription (int id) throws SQLException {

        String sqlStatement = "DELETE FROM prescriptions WHERE patient_id = ?";

        try(Connection connection = DatabaseConnection.connect();
            PreparedStatement statement = connection.prepareStatement(sqlStatement)){

            statement.setInt(1, id);

            int deleted = statement.executeUpdate();

            if(deleted > 0){
                System.out.println("Prescription successfully deleted.");
            } else {
                System.out.println("Prescription could not be deleted.");
            }

        }

    }

    public void viewPrescription(int id) throws SQLException {
        String sqlStatement = "SELECT * FROM prescriptions WHERE patient_id = ?";

        try(Connection connection = DatabaseConnection.connect();
            PreparedStatement statement = connection.prepareStatement(sqlStatement)){

            statement.setInt(1, id);

            ResultSet results = statement.executeQuery();

            while(results.next()){

                int prescriptionId = results.getInt("prescription_id");
                int patientId = results.getInt("patient_id");
                String medication = results.getString("medication_name");
                String dosage = results.getString("dosage");
                LocalDate startDate = results.getDate("start_date").toLocalDate();
                LocalDate endDate = results.getDate("end_date").toLocalDate();
                String refills = results.getString("refills");

                Prescription prescription = new Prescription(prescriptionId, patientId, medication, dosage, startDate,
                        endDate, refills);

                System.out.println(prescription);

            }

        }
    }

    public List<Prescription> getAllPrescriptions() throws SQLException {

        List<Prescription> prescriptions = new ArrayList<>();

        String sqlStatement = "SELECT * FROM prescriptions";

        try (Connection connection = DatabaseConnection.connect();
            Statement statement = connection.createStatement()) {

            ResultSet results = statement.executeQuery(sqlStatement);

            while (results.next()){

                int prescriptionId = results.getInt("prescription_id");
                int patientId = results.getInt("patient_id");
                String medication = results.getString("medication_name");
                String dosage = results.getString("dosage");
                LocalDate startDate = results.getDate("start_date").toLocalDate();
                LocalDate endDate = results.getDate("end_date").toLocalDate();
                String refills = results.getString("refills");

                Prescription prescription = new Prescription(prescriptionId, patientId, medication, dosage, startDate,
                        endDate, refills);

                prescriptions.add(prescription);
            }

        }

        return prescriptions;
    }

}
