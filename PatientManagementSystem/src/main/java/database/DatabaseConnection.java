package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/patient_management";
    private static final String USER = "app_user";
    private static final String PASSWORD = "user12345";

    public static Connection connect(){
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            return conn;
        } catch (SQLException e){
            System.out.println("Connection failed");
            e.printStackTrace();
            return null;
        }
    }

    public static Connection closeConnection(Connection connection){
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database closed.");
            } catch (SQLException e){
                System.out.println("Failed to close database connection.");
                e.printStackTrace();
            }
        }
        return connection;
    }



}
