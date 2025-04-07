package view;

import controller.AppointmentController;
import controller.PatientController;
import controller.PrescriptionController;

import java.util.Scanner;

public class UI {

    private final Scanner scanner;

    public UI(Scanner scanner){
        this.scanner = scanner;
    }

    public void start(){

        System.out.println("WELCOME TO THE PATIENT MANAGEMENT SYSTEM");
        System.out.println("----------------------------------------");

        boolean logicLoop = true;


        while(logicLoop) {

            final int PATIENTS = 1;
            final int APPOINTMENTS = 2;
            final int PRESCRIPTIONS = 3;
            final int EXIT = 4;

            displayInitialMenu();
            System.out.println("Enter selection: ");
            int initialMenuSelection = Integer.parseInt(scanner.nextLine());


            if(initialMenuSelection == EXIT){
                System.out.println("Program ended.");
                logicLoop = false;
            } else if (initialMenuSelection == PATIENTS){
                System.out.println("You selected Patients.");
                boolean confirm = carryOn();

                if(!confirm){
                    System.out.println("Returning to main menu.");
                    System.out.println();
                    break;
                } else {
                    runPatients();
                }
            } else if (initialMenuSelection == APPOINTMENTS) {
                System.out.println("You selected Appointments.");
                boolean confirm = carryOn();

                if(!confirm){
                    System.out.println("Returning to main menu.");
                    System.out.println();
                    break;
                } else {
                    runAppointments();
                }

            } else if (initialMenuSelection == PRESCRIPTIONS) {
                System.out.println("You selected Prescriptions");

                boolean confirm = carryOn();

                if(!confirm){
                    System.out.println("Returning to main menu.");
                    System.out.println();
                    break;
                } else {
                    runPrescriptions();
                }

            } else {
                System.out.println("Input not recognized.");
            }

        }

    }

    private void displayInitialMenu(){
        System.out.println("PLEASE ENTER ONE OF THE FOLLOWING OPTIONS: ");
        System.out.println("1 - PATIENTS");
        System.out.println("2 - APPOINTMENTS");
        System.out.println("3 - PRESCRIPTIONS");
        System.out.println("4 - EXIT PROGRAM");
    }

    private void displayPatientsMenu(){
        System.out.println("SELECT ONE OF THE FOLLOWING OPTIONS: ");
        System.out.println("1 - ADD NEW PATIENT TO SYSTEM");
        System.out.println("2 - UPDATE EXISTING PATIENT RECORD");
        System.out.println("3 - VIEW EXISTING PATIENT RECORDS");
        System.out.println("4 - DELETE EXISTING PATIENT FROM SYSTEM");
        System.out.println("5 - EXIT PATIENT MENU");
    }

    private void displayUpdateOptions(){
        System.out.println("SELECT ONE OF THE FOLLOWING TO UPDATE: ");
        System.out.println("1 - FIRST NAME");
        System.out.println("2 - LAST NAME");
        System.out.println("3 - ADDRESS");
        System.out.println("4 - PHONE");
        System.out.println("5 - EMERGENCY CONTACT");
    }

    private void displayViewRecords(){
        System.out.println("SELECT ONE: ");
        System.out.println("1 - LOOKUP PATIENT");
        System.out.println("2 - VIEW ALL PATIENTS");
    }

    private void displayAppointmentsMenu(){
        System.out.println("SELECT ONE OF THE FOLLOWING OPTIONS: ");
        System.out.println("1 - ADD NEW APPOINTMENT");
        System.out.println("2 - UPDATE EXISTING APPOINTMENT");
        System.out.println("3 - VIEW APPOINTMENTS");
        System.out.println("4 - DELETE APPOINTMENT");
        System.out.println("5 - EXIT APPOINTMENT MENU");
    }

    private void updateAppointments(){
        System.out.println("TO UPDATE THE APPOINTMENT, PLEASE SELECT ONE OF THE FOLLOWING: ");
        System.out.println("1 - UPDATE APPOINTMENT DATE");
        System.out.println("2 - UPDATE PRACTITIONER");
        System.out.println("3 - UPDATE REASON FOR VISIT");
    }

    private void viewAppointmentMenu(){
        System.out.println("SELECT ONE OF THE FOLLOWING: ");
        System.out.println("1 - VIEW ONE APPOINTMENT RECORD");
        System.out.println("2 - VIEW ALL APPOINTMENTS");
    }

    private void displayPrescriptionsMenu(){
        System.out.println("SELECT ONE OF THE FOLLOWING OPTIONS: ");
        System.out.println("1 - ADD NEW PRESCRIPTION");
        System.out.println("2 - UPDATE EXISTING PRESCRIPTION");
        System.out.println("3 - VIEW PRESCRIPTION");
        System.out.println("4 - DELETE PRESCRIPTION");
        System.out.println("5 - EXIT PRESCRIPTION MENU");
    }

    private void updatePrescriptions(){
        System.out.println("SELECT ONE OF THE FOLLOWING TO UPDATE: ");
        System.out.println("1 - DOSAGE");
        System.out.println("2 - REFILLS");
    }

    private void viewPrescriptionsMenu(){
        System.out.println("SELECT ONE OF THE FOLLOWING OPTIONS: ");
        System.out.println("1 - FIND ONE PRESCRIPTION RECORD");
        System.out.println("2 - VIEW ALL PRESCRIPTIONS");
    }

    private boolean carryOn(){
        System.out.println("Continue? (y/n): ");
        String choice = scanner.nextLine();

        return choice.equalsIgnoreCase("y");
    }

    private void runPatients(){
        displayPatientsMenu();
        System.out.println("Enter selection: ");
        int patientsMenuSelection = Integer.parseInt(scanner.nextLine());

        switch (patientsMenuSelection){
            case 1:
                System.out.println("You selected Add Patient.");
                runAddPatient();
                break;
            case 2:
                System.out.println("You selected Update Patient.");
                runUpdatePatients();
                break;
            case 3:
                System.out.println("You selected View Patient Records.");
                runViewPatients();
                break;
            case 4:
                System.out.println("You selected Delete Patient Record.");
                runDeletePatients();
                break;
            case 5:
                System.out.println("You selected Exit Patient Menu.");
                boolean confirm = carryOn();

                if(!confirm){
                    System.out.println("Returning to Patient menu.");
                    System.out.println();
                } else {
                    break;
                }
            default:
                System.out.println("Selection not recognized.");
        }


    }

    private void runAddPatient() {
        PatientController pc = new PatientController();
        pc.handleAddPatient();
    }

    private void runUpdatePatients(){

        boolean foundPatient;

        PatientController pc = new PatientController();

        displayUpdateOptions();
        System.out.println("Enter selection: ");
        int updateSelection = Integer.parseInt(scanner.nextLine());

        switch (updateSelection) {
            case 1:
                System.out.println("You selected update first name.");
                System.out.println("First ensure patient is in database: ");
                foundPatient = pc.handleLookUp();

                if(foundPatient){
                    pc.handleUpdateFirstName();
                }
                break;
            case 2:
                System.out.println("You selected update last name.");
                System.out.println("First ensure patient is in database: ");
                foundPatient = pc.handleLookUp();

                if(foundPatient) {
                    pc.handleUpdateLastName();
                }
                break;
            case 3:
                System.out.println("You selected update address.");
                System.out.println("First ensure patient is in database: ");
                foundPatient = pc.handleLookUp();

                if(foundPatient) {
                    pc.handleUpdateAddress();
                }
                break;
            case 4:
                System.out.println("You selected update phone.");
                System.out.println("First ensure patient is in database: ");
                foundPatient = pc.handleLookUp();

                if(foundPatient) {
                    pc.handleUpdatePhone();
                }
                break;
            case 5:
                System.out.println("You selected update emergency contact");
                System.out.println("First ensure patient is in database: ");
                foundPatient = pc.handleLookUp();

                if(foundPatient){
                    pc.handleUpdateEmergencyContact();
                }
                break;
            default:
                System.out.println("Selection not recognized");
                break;
        }
    }

    private void runViewPatients(){

        PatientController pc = new PatientController();

        displayViewRecords();
        System.out.println("Enter selection: ");
        int recordsSelection = Integer.parseInt(scanner.nextLine());

        if(recordsSelection == 1){
            pc.handleLookUp();
        } else if (recordsSelection == 2) {
            System.out.println("Displaying all patient records: ");
            System.out.println("---------------------------------");
            pc.displayAllPatientRecords();
        }

    }

    private void runDeletePatients(){
        PatientController pc = new PatientController();

        pc.handleLookUp();

        System.out.println("WARNING!! You are about to delete this patient from the system!");
        boolean confirm = carryOn();

        if(!confirm){
            System.out.println("Returning to main menu.");
            System.out.println();
        } else {
            pc.handleDeletePatient();
        }

    }

    private void runAppointments(){
        displayAppointmentsMenu();

        boolean foundPatient;

        PatientController pc = new PatientController();

        System.out.println("Enter selection: ");
        int appointmentsMenuSelection = Integer.parseInt(scanner.nextLine());

        switch (appointmentsMenuSelection){
            case 1:
                System.out.println("You selected add appointment.");
                foundPatient = pc.handleLookUp();

                if(foundPatient){
                    runAddAppointment();
                } else {
                    System.out.println("Patient must be added to database before adding an appointment.");
                }
                break;
            case 2:
                System.out.println("You selected update appointment.");
                runUpdateAppointment();
                break;
            case 3:
                System.out.println("You selected view appointment.");
                runViewAppointments();
                break;
            case 4:
                System.out.println("You selected delete appointment.");
                runDeleteAppointment();
                break;
            default:
                System.out.println("Selection not recognized.");
        }

    }

    private void runAddAppointment(){
        AppointmentController ac = new AppointmentController();
        ac.handleAddAppointment();

    }

    private void runUpdateAppointment(){

        PatientController pc = new PatientController();
        AppointmentController ac = new AppointmentController();

        boolean found;

        updateAppointments();
        System.out.println("Enter selection: ");
        int selection = Integer.parseInt(scanner.nextLine());

        switch (selection) {
            case 1:
                System.out.println("You selected update appointment date.");

                found = pc.handleLookUp();

                if(found){
                    ac.handleUpdateAppointmentDate();
                } else {
                    System.out.println("Patient must be added to database before modifying appointment records.");
                }
                break;
            case 2:
                System.out.println("You selected update practitioner.");

                found = pc.handleLookUp();

                if(found){
                    ac.handleUpdatePractitioner();
                } else {
                    System.out.println("Patient must be in database before appointment record can be modified.");
                }
                break;
            case 3:
                System.out.println("You selected update reason for visit.");

                found = pc.handleLookUp();

                if(found){
                    ac.handleUpdateReason();
                } else {
                    System.out.println("Patient must be in database before appointment record can be modified.");
                }
                break;
            default:
                System.out.println("Selection not recognized");

        }

    }

    private void runViewAppointments(){
        PatientController pc = new PatientController();
        AppointmentController ac = new AppointmentController();

        boolean found;

        viewAppointmentMenu();
        System.out.println("Enter selection: ");
        int selection = Integer.valueOf(scanner.nextLine());

        if(selection == 1){
            System.out.println("Which patient do you want to find an appointment for? ");

            found = pc.handleLookUp();

            if(found){
                ac.handleViewAppointmentRecord();
            } else {
                System.out.println("Patient must have an appointment in order to view appointment record.");
            }

        } else if (selection == 2) {
            ac.displayAllAppointments();
        } else {
            System.out.println("Selection not recognized.");
        }


    }

    private void runDeleteAppointment(){

        PatientController pc = new PatientController();
        AppointmentController ac = new AppointmentController();

        System.out.println("Which patient's appointment do you want to delete from the system?");
        pc.handleLookUp();

        System.out.println("WARNING!! You are about to delete this patient's appointment from the system!");
        boolean confirm = carryOn();

        if(!confirm){
            System.out.println("Returning to main menu.");
            System.out.println();
        } else {
            ac.handleDeleteAppointment();
        }
    }

    private void runPrescriptions(){

        displayPrescriptionsMenu();
        System.out.println("Enter selection: ");
        int choice = Integer.valueOf(scanner.nextLine());

        switch (choice){
            case 1:
                System.out.println("You selected add prescription.");
                runAddPrescription();
                break;
            case 2:
                System.out.println("You selected update prescription.");
                runUpdatePrescription();
                break;
            case 3:
                System.out.println("You selected view prescription.");
                runViewPrescriptions();
                break;
            case 4:
                System.out.println("You selected delete prescription.");
                runDeletePrescription();
                break;
            default:
                System.out.println("Selection not recognized.");
        }

    }

    private void runAddPrescription(){

        PrescriptionController prescriptionController = new PrescriptionController();
        PatientController pc = new PatientController();

        pc.handleLookUp();

        prescriptionController.handleAddPrescription();

    }

    private void runUpdatePrescription(){

        boolean found;

        PrescriptionController prescriptionController = new PrescriptionController();
        PatientController pc = new PatientController();

        updatePrescriptions();
        System.out.println("Enter selection: ");
        int choice = Integer.valueOf(scanner.nextLine());

        if(choice == 1){
            System.out.println("You selected update dosage. Which patient do you wish to update the info for? ");
            found = pc.handleLookUp();

            if(!found){
                System.out.println("Patient must have a prescription before you can update dosage.");
            } else {
                prescriptionController.handleUpdateDosage();
            }

        } else if (choice == 2){
            System.out.println("You selected update refill: ");

            found = pc.handleLookUp();

            if(!found){
                System.out.println("Patient must have an existing prescription before you can update refill.");
            } else {
                prescriptionController.handleUpdateRefills();
            }

        } else {
            System.out.println("Selection not recognized.");
        }

    }

    private void runViewPrescriptions(){
        PrescriptionController prescriptionController = new PrescriptionController();

        viewPrescriptionsMenu();
        System.out.println("Enter selection: ");
        int choice = Integer.valueOf(scanner.nextLine());

        if(choice == 1){
            prescriptionController.viewPrescription();
        } else if(choice == 2) {
            prescriptionController.getAllPrescriptions();
        } else {
            System.out.println("Selection not recognized.");
        }

    }

    private void runDeletePrescription(){

        PrescriptionController prescriptionController = new PrescriptionController();
        PatientController pc = new PatientController();


        System.out.println("Which patient's prescription will be deleted?");
        pc.handleLookUp();

        System.out.println("WARNING!! You are about to delete this patient's prescription from the system!");
        boolean confirm = carryOn();

        if(!confirm){
            System.out.println("Returning to main menu.");
            System.out.println();
        } else {
            prescriptionController.deletePrescription();
        }

    }




}
