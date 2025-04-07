package dao;

import database.DatabaseConnection;
import model.Appointment;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {

    public void addAppointment(Appointment appointment) throws SQLException {
        String sqlStatement = "INSERT INTO appointments (patient_id, appointment_date, practitioner_name, reason_for_visit) " +
                "VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(sqlStatement)){

            statement.setInt(1, appointment.getPatientId());
            statement.setDate(2, Date.valueOf(appointment.getAppointmentDate()));
            statement.setString(3, appointment.getPractitionerName());
            statement.setString(4, appointment.getReasonForVisit());

            statement.executeUpdate();

        }
    }

    public void updateAppointmentDate(int patientId, LocalDate appointmentDate) throws SQLException {

        String sqlStatement = "UPDATE appointments SET appointment_date = ? WHERE patient_id = ?";

        try (Connection connection = DatabaseConnection.connect();
            PreparedStatement statement = connection.prepareStatement(sqlStatement)){
            statement.setDate(1, Date.valueOf(appointmentDate));
            statement.setInt(2, patientId);

            int updated = statement.executeUpdate();

            if(updated > 0){
                System.out.println("Successfully updated appointment date.");
            } else {
                System.out.println("Could not update appointment record.");
            }
        }

    }

    public void updatePractitioner(int patientId, String name) throws SQLException {
        String sqlStatement = "UPDATE appointments SET practitioner_name = ? WHERE patient_id = ?";

        try(Connection connection = DatabaseConnection.connect();
            PreparedStatement statement = connection.prepareStatement(sqlStatement)){
            statement.setString(1, name);
            statement.setInt(2, patientId);

            int updated = statement.executeUpdate();

            if(updated > 0){
                System.out.println("Successfully updated appointment record.");
            } else {
                System.out.println("Could not update appointment record.");
            }
        }

    }

    public void updateReason(int patientId, String reason) throws SQLException {
        String sqlStatement = "UPDATE appointments SET reason_for_visit = ? WHERE patient_id = ?";

        try(Connection connection = DatabaseConnection.connect();
            PreparedStatement statement = connection.prepareStatement(sqlStatement)){
            statement.setString(1, reason);
            statement.setInt(2, patientId);

            int updated = statement.executeUpdate();

            if(updated > 0){
                System.out.println("Successfully updated appointment record.");
            } else {
                System.out.println("Could not update appointment record.");
            }
        }
    }

    public void deleteAppointment(int patientID) throws SQLException {

        String sqlStatement = "DELETE FROM appointments WHERE patient_id = ?";

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(sqlStatement)){

            statement.setInt(1, patientID);

            int deleted = statement.executeUpdate();

            if(deleted > 0){
                System.out.println("Appointment deleted from database.");
            } else {
                System.out.println("Could not delete appointment record.");
            }

        }

    }

    public void viewAppointmentRecord(int patientId) throws SQLException {
        String sqlStatement = "SELECT * FROM appointments WHERE patient_id = ?";

        try (Connection connection = DatabaseConnection.connect();
            PreparedStatement statement = connection.prepareStatement(sqlStatement)){

            statement.setInt(1, patientId);

            ResultSet result = statement.executeQuery();

            int resultCount = 0;


            while (result.next()){
                int appointment_id = result.getInt("appointment_id");
                int patient_id = result.getInt("patient_id");

//                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyy HH:mm");
//                LocalDateTime appointmentDate = LocalDateTime.parse(result.getObject("appointment_date", LocalDateTime.class).format(dtf));

                LocalDate date = result.getDate("appointment_date").toLocalDate();

                String practitioner = result.getString("practitioner_name");
                String reason = result.getString("reason_for_visit");

                Appointment appointment = new Appointment(appointment_id, patient_id, date, practitioner, reason);

                System.out.println(appointment);

                resultCount++;

            }
        }
    }

    public List<Appointment> getAllAppointments() throws SQLException {
        List<Appointment> appointments = new ArrayList<>();

        String sqlStatement = "SELECT * FROM appointments ORDER BY appointment_id";

        try(Connection connection = DatabaseConnection.connect();
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(sqlStatement)){


            while(results.next()){
                int appointmentId = results.getInt("appointment_id");
                int patientId = results.getInt("patient_id");

                LocalDate date = results.getDate("appointment_date").toLocalDate();

                String practitioner = results.getString("practitioner_name");
                String reason = results.getString("reason_for_visit");


                appointments.add(new Appointment(appointmentId, patientId, date, practitioner, reason));

            }

        }

        return appointments;

    }



}
