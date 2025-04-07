package controller;

import model.Patient;
import service.PatientService;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class PatientController {


    Scanner scanner = new Scanner(System.in);
    private PatientService patientService = new PatientService();

    public void handleAddPatient(){
        System.out.println("Enter patient first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter patient last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter patient sex (M/F): ");
        String sex = scanner.nextLine();
        System.out.println("Enter patient's dob (yyyy-mm-dd): ");
        LocalDate dob = Date.valueOf(scanner.nextLine()).toLocalDate();
        System.out.println("Enter street: ");
        String street = scanner.nextLine();
        System.out.println("Enter city: ");
        String city = scanner.nextLine();
        System.out.println("Enter state: ");
        String state = scanner.nextLine();
        System.out.println("Enter zipcode: ");
        String zipcode = scanner.nextLine();
        System.out.println("Enter patient's phone number (000-000-0000): ");
        String patientPhone = scanner.nextLine();
        System.out.println("Enter patient's email: ");
        String email = scanner.nextLine();
        System.out.println("Enter patient's emergency contact (first and last name): ");
        String emergencyContact = scanner.nextLine();
        System.out.println("Enter emergency contact's phone: ");
        String emergencyPhone = scanner.nextLine();

        Patient patient = new Patient();
        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setSex(sex);
        patient.setDob(dob);
        patient.setStreet(street);
        patient.setCity(city);
        patient.setState(state);
        patient.setZipcode(zipcode);
        patient.setPhone(patientPhone);
        patient.setEmail(email);
        patient.setEmergencyContact(emergencyContact);
        patient.setEmergencyPhone(emergencyPhone);

        try {
            patientService.addPatient(patient);
            System.out.println("Patient added successfully");
        } catch (Error e){
            System.out.println("Patient could not be added.");
            e.printStackTrace();
        }

    }

    public boolean handleLookUp(){
        System.out.println("Enter patient first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter patient last name: ");
        String lastName = scanner.nextLine();

        boolean patientFound = false;

        try {
            patientService.lookupPatient(firstName, lastName);
            patientFound = true;
        } catch (Error e){
//            System.out.println("Patient not found");
            e.printStackTrace();
        }

        return patientFound;
    }

    public void handleUpdateFirstName(){
        System.out.println("Enter patient ID (see above record): ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter new first name for patient: ");
        String newFirstName = scanner.nextLine();

        try {
            patientService.updatePatientFirstName(id, newFirstName);
        } catch (Error e) {
            e.printStackTrace();
        }

    }

    public void handleUpdateLastName() {
        System.out.println("Enter patient ID (see above record): ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter new last name for patient: ");
        String newLastName = scanner.nextLine();
        try {
            patientService.updatePatientLastName(id, newLastName);
        } catch (Error e){
            e.printStackTrace();
        }
    }

    public void handleUpdateAddress(){
        System.out.println("Enter patient ID (see above record): ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter updated street name and number: ");
        String updatedStreet = scanner.nextLine();
        System.out.println("Enter city: ");
        String updatedCity = scanner.nextLine();
        System.out.println("Enter state: ");
        String updatedState = scanner.nextLine();
        System.out.println("Enter zipcode: ");
        String updatedZip = scanner.nextLine();

        try {
            patientService.updatePatientAddress(id, updatedStreet, updatedCity, updatedState, updatedZip);
        } catch (Error e) {
            e.printStackTrace();
        }
    }

    public void handleUpdatePhone() {
        System.out.println("Enter patient ID (see above record): ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter updated phone number: ");
        String updatedPhone = scanner.nextLine();

        try {
            patientService.updatePatientPhone(id, updatedPhone);
        } catch (Error e) {
            e.printStackTrace();
        }
    }

    public void handleUpdateEmergencyContact() {
        System.out.println("Enter patient ID (see above record): ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter full name of emergency contact: ");
        String updatedContact = scanner.nextLine();
        System.out.println("Enter phone number for " + updatedContact + ": ");
        String updatedPhone = scanner.nextLine();

        try {
            patientService.updateEmergencyContact(id, updatedContact, updatedPhone);
        } catch (Error e){
            e.printStackTrace();
        }
    }

    public void handleDeletePatient(){
        System.out.println("Enter the ID of the patient you wish to delete (see above record): ");
        int id = Integer.parseInt(scanner.nextLine());

        try {
            patientService.deletePatientRecord(id);
        } catch (Error e){
            e.printStackTrace();
        }

    }

    public void displayAllPatientRecords(){
        try {
            List<Patient> patientRecords = patientService.displayAllPatientRecords();

            for(Patient patient : patientRecords){
                System.out.println(patient);
            }

        } catch (Error e){
            e.printStackTrace();
        }
    }



}
