package view;

import database.DatabaseConnection;

import java.sql.Connection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Connection db = DatabaseConnection.connect();

        UI patientManagementUI = new UI(scanner);
        patientManagementUI.start();

        Connection dbClose = DatabaseConnection.closeConnection(db);
    }

}
