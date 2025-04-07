package controller;

import model.Prescription;
import service.PrescriptionService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class PrescriptionController {

    Scanner scanner = new Scanner(System.in);

    private PrescriptionService prescriptionService = new PrescriptionService();

    public void handleAddPrescription(){
        System.out.println("Enter the ID of the patient you are adding a prescription for (see above): ");
        int patientId = Integer.valueOf(scanner.nextLine());
        System.out.println("Enter the name of the medication: ");
        String medication = scanner.nextLine();
        System.out.println("Enter the dosage amount: ");
        String dosage = scanner.nextLine();
        System.out.println("Enter the start date for the medication (yyyy-mm-dd): ");
        LocalDate startDate = LocalDate.parse(scanner.nextLine());
        System.out.println("Enter the end date for the medication (yyyy-mm-dd): ");
        LocalDate endDate = LocalDate.parse(scanner.nextLine());
        System.out.println("Enter amount of refills for prescription. If none, enter N/A: ");
        String refills = scanner.nextLine();

        Prescription prescription = new Prescription();
        prescription.setPatientId(patientId);
        prescription.setMedicationName(medication);
        prescription.setDosage(dosage);
        prescription.setStartDate(startDate);
        prescription.setEndDate(endDate);
        prescription.setRefills(refills);

        try {
            prescriptionService.addPrescription(prescription);
        } catch (Error e){
            e.printStackTrace();
        }

    }

    public void handleUpdateDosage(){
        System.out.println("Enter the ID of the patient you are altering the dosage for (See above): ");
        int patientId = Integer.valueOf(scanner.nextLine());
        System.out.println("Enter the new dosage information: ");
        String dosage = scanner.nextLine();

        try {
            prescriptionService.updateDosage(patientId, dosage);
        } catch (Error e){
            e.printStackTrace();
        }

    }

    public void handleUpdateRefills(){

        System.out.println("Enter the ID of the patient you are altering the refill information for (see above): ");
        int patientId = Integer.valueOf(scanner.nextLine());
        System.out.println("Enter refill info: ");
        String updatedRefillInfo = scanner.nextLine();

        try {
            prescriptionService.updateRefillInfo(patientId, updatedRefillInfo);
        } catch (Error e){
            e.printStackTrace();
        }

    }

    public void deletePrescription(){

        System.out.println("Enter the ID of the patient whose prescription you wish to delete (see above): ");
        int patientId = Integer.valueOf(scanner.nextLine());

        try {
            prescriptionService.deletePrescription(patientId);
        } catch (Error e){
            e.printStackTrace();
        }

    }

    public void viewPrescription(){

        System.out.println("Enter the ID of the patient whose prescription record you wish to view (see above): ");
        int patientId = Integer.valueOf(scanner.nextLine());

        try {
            prescriptionService.viewPrescription(patientId);
        } catch (Error e){
            e.printStackTrace();
        }

    }

    public void getAllPrescriptions(){

        List<Prescription> prescriptions;

        try {
            prescriptions = prescriptionService.getAllPrescriptions();

            for(Prescription prescription : prescriptions){
                System.out.println(prescription);
            }
        } catch (Error e){
            e.printStackTrace();
        }

    }




}
