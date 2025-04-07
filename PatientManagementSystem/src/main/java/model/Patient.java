package model;

import java.time.LocalDate;

public class Patient {

    private int patientId;
    private String firstName;
    private String lastName;
    private String sex;
    private LocalDate dob;

    private String street;
    private String city;
    private String state;
    private String zipcode;
    private String phone;
    private String email;
    private String emergencyContact;
    private String emergencyPhone;

    public Patient(int patientId, String firstName, String lastName, String sex, LocalDate dob, String street, String city,
                   String state, String zipcode, String phone, String email, String emergencyContact,
                   String emergencyPhone) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.dob = dob;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.phone = phone;
        this.email = email;
        this.emergencyContact = emergencyContact;
        this.emergencyPhone = emergencyPhone;
    }

    public Patient(){

    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getEmergencyPhone() {
        return emergencyPhone;
    }

    public void setEmergencyPhone(String emergencyPhone) {
        this.emergencyPhone = emergencyPhone;
    }

    @Override
    public String toString(){
        return "ID: " + this.patientId + "\n" +
                "First name: " + this.firstName + "\n" +
                "Last name: " + this.lastName + "\n" +
                "Sex: " + this.sex + "\n" +
                "DOB: " + this.dob + "\n" +
                "Address: " + this.street + " " + this.city + ", " + this.state + " " + this.zipcode + "\n" +
                "Phone: " + this.phone + "\n" +
                "Email: " + this.email + "\n" +
                "Emergency contact: " + this.emergencyContact + "\n" +
                "Emergency phone: " + this.emergencyPhone + "\n" +
                "----------------------------------------------------------------------------------";
    }


}
