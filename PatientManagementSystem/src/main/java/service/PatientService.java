package service;

import dao.PatientDAO;
import model.Patient;

import java.sql.SQLException;
import java.util.List;

public class PatientService {

    private final PatientDAO patientDAO = new PatientDAO();

    public void addPatient(Patient patient) {
        try {
            patientDAO.addPatient(patient);
        } catch (SQLException e){
            System.out.println("Couldn't add patient to DAO");
            e.printStackTrace();
        }
    }

    public void updatePatientFirstName(int patientID, String newFirstName){
        try {
            patientDAO.updateFirstName(patientID, newFirstName);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void updatePatientLastName(int patientID, String newLastName){
        try {
            patientDAO.updateLastName(patientID, newLastName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePatientAddress(int patientId, String street, String city, String state, String zip){
        try {
            patientDAO.updateAddress(patientId, street, city, state, zip);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePatientPhone(int patientId, String phone) {
        try {
            patientDAO.updatePhone(patientId, phone);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEmergencyContact(int patientId, String contactName, String contactPhone){
        try {
            patientDAO.updateContact(patientId, contactName, contactPhone);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deletePatientRecord(int patientId){
        try {
            patientDAO.deletePatientRecord(patientId);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }


    public void lookupPatient(String firstName, String lastName){
        try {
            patientDAO.lookupPatient(firstName, lastName);
        } catch (SQLException e) {
            System.out.println("Patient not found.");
            e.printStackTrace();
        }
    }

    public List<Patient> displayAllPatientRecords() {
        List<Patient> records = null;
        try {
            records = patientDAO.getAllPatients();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return records;
    }

    public List<Patient> getAllPatients() throws SQLException {
        return patientDAO.getAllPatients();
    }

}
