package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Appointment {

    private int appointmentId;
    private int patientId;
    private LocalDate appointmentDate;
    private String practitionerName;
    private String reasonForVisit;

    public Appointment(){

    }

    public Appointment(int appointmentId, int patientId, LocalDate appointmentDate, String practitionerName, String reasonForVisit) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.appointmentDate = appointmentDate;
        this.practitionerName = practitionerName;
        this.reasonForVisit = reasonForVisit;
    }


    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public LocalDate getAppointmentDate() {
        return this.appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate.toLocalDate();
    }

    public String getPractitionerName() {
        return practitionerName;
    }

    public void setPractitionerName(String practitionerName) {
        this.practitionerName = practitionerName;
    }

    public String getReasonForVisit() {
        return reasonForVisit;
    }

    public void setReasonForVisit(String reasonForVisit) {
        this.reasonForVisit = reasonForVisit;
    }

    @Override
    public String toString(){
        return "Appointment ID: " + this.appointmentId + "\n" +
                "Patient ID: " + this.patientId + "\n" +
                "Appointment Date: " + this.appointmentDate + "\n" +
                "Practitioner: " + this.practitionerName + "\n" +
                "Reason for visit: " + this.reasonForVisit + "\n" +
                "----------------------------------------------------";
    }
}
