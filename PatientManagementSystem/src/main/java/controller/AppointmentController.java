package controller;

import model.Appointment;
import service.AppointmentService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class AppointmentController {

    Scanner scanner = new Scanner(System.in);

    private AppointmentService appointmentService = new AppointmentService();

    public void handleAddAppointment(){

        System.out.println("Enter the ID of the patient you wish to add an appointment for (see above record): ");
        int id = Integer.parseInt(scanner.nextLine());
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
        System.out.println("Enter the appointment date and time (mm-dd-yyyy hh:mm): ");
        LocalDateTime appointment = LocalDateTime.parse(scanner.nextLine(), format);
        System.out.println("Enter practitioner name: ");
        String practitioner = scanner.nextLine();
        System.out.println("Reason for visit: ");
        String reasonForVisit = scanner.nextLine();

        Appointment newAppointment = new Appointment();
        newAppointment.setPatientId(id);
        newAppointment.setAppointmentDate(appointment);
        newAppointment.setPractitionerName(practitioner);
        newAppointment.setReasonForVisit(reasonForVisit);

        try {
            appointmentService.addAppointment(newAppointment);
            System.out.println("Appointment added successfully.");
        } catch (Error e){
            e.printStackTrace();
        }

    }

    public void handleUpdateAppointmentDate(){
        System.out.println("Enter the ID of the patient whose record you will be updating (see above): ");
        int id = Integer.parseInt(scanner.nextLine());
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
        System.out.println("Enter the new date for appointment: ");
//        LocalDateTime appointment = LocalDateTime.parse(scanner.nextLine(), format);

        LocalDate appointment = LocalDate.parse(scanner.nextLine());

        try {
            appointmentService.updateAppointmentDate(id, appointment);
        } catch (Error e){
            e.printStackTrace();
        }

    }

    public void handleUpdatePractitioner(){
        System.out.println("Enter the ID of the patient whose record you will be updating (see above): ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the name of the new practitioner for the appointment: ");
        String updatedPractitioner = scanner.nextLine();

        try {
            appointmentService.updatePractitioner(id, updatedPractitioner);
        } catch (Error e){
            e.printStackTrace();
        }

    }

    public void handleUpdateReason(){
        System.out.println("Enter the ID of the patient whose record you will be updating (see above): ");
        int id = Integer.valueOf(scanner.nextLine());
        System.out.println("Enter the new reason for visit: ");
        String reason = scanner.nextLine();

        try {
            appointmentService.updateReason(id, reason);
        } catch (Error e){
            e.printStackTrace();
        }

    }

    public void handleDeleteAppointment(){
        System.out.println("Enter the ID of the patient whose appointment you wish to delete (see above): ");
        int id = Integer.valueOf(scanner.nextLine());

        try {
            appointmentService.deleteAppointment(id);
        } catch (Error e){
            e.printStackTrace();
        }

    }

    public void handleViewAppointmentRecord(){

        System.out.println("Enter the ID of the patient whose appointment you wish to view (see above): ");
        int id = Integer.valueOf(scanner.nextLine());

        try {
            appointmentService.viewAppointmentRecord(id);
        } catch (Error e){
            e.printStackTrace();
        }

    }

    public void displayAllAppointments(){
        try {
            List<Appointment> appointments = appointmentService.viewAllAppointments();

            for(Appointment appointment : appointments){
                System.out.println(appointment);
            }

        } catch (Error e){
            e.printStackTrace();
        }
    }


}
