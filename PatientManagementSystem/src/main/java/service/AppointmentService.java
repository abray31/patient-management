package service;

import dao.AppointmentDAO;
import model.Appointment;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class AppointmentService {

    private final AppointmentDAO appointmentDAO = new AppointmentDAO();

    public void addAppointment(Appointment appointment){
        try {
            appointmentDAO.addAppointment(appointment);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateAppointmentDate(int patientId, LocalDate newAppointmentDate){
        try {
            appointmentDAO.updateAppointmentDate(patientId, newAppointmentDate);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updatePractitioner(int patientId, String practitioner){
        try{
            appointmentDAO.updatePractitioner(patientId, practitioner);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateReason(int patientId, String reason){
        try {
            appointmentDAO.updateReason(patientId, reason);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteAppointment(int patientId){
        try {
            appointmentDAO.deleteAppointment(patientId);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void viewAppointmentRecord(int patientId){
        try {
            appointmentDAO.viewAppointmentRecord(patientId);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Appointment> viewAllAppointments(){

        List<Appointment> appointmentList = null;
        try {
            appointmentList = appointmentDAO.getAllAppointments();
        } catch (SQLException e){
            e.printStackTrace();
        }

        return appointmentList;

    }


}
