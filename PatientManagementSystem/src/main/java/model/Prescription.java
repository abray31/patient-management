package model;

import java.time.LocalDate;

public class Prescription {

    private int prescriptionId;
    private int patientId;
    private String medicationName;
    private String dosage;
    private LocalDate startDate;
    private LocalDate endDate;
    private String refills;

    public Prescription() {

    }

    public Prescription(int prescriptionId, int patientId, String medicationName, String dosage, LocalDate startDate, LocalDate endDate, String refills) {
        this.prescriptionId = prescriptionId;
        this.patientId = patientId;
        this.medicationName = medicationName;
        this.dosage = dosage;
        this.startDate = startDate;
        this.endDate = endDate;
        this.refills = refills;
    }

    public int getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getRefills() {
        return refills;
    }

    public void setRefills(String refills) {
        this.refills = refills;
    }

    @Override
    public String toString() {
        return "Prescription: \n" +
                "Prescription Id: " + prescriptionId + "\n" +
                "Patient Id: " + patientId + "\n" +
                "Medication: " + medicationName + "\n" +
                "Dosage: " + dosage + "\n" +
                "Start date: " + startDate + "\n" +
                "End date: " + endDate + "\n" +
                "Refills: " + refills + "\n" +
                "--------------------------------------------";
    }
}
