package Final_rdbms;

import java.sql.*;
import java.util.Scanner;

public class itc3160 {

    public static void main(String[] args) throws ClassNotFoundException {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Oracle Driver not found");
            System.exit(0);
        }


        Connection connection = null;
        try {
            connection =
                    DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xepdb1", "newUser", "oracle");
            System.out.println("Connection  to DB successful");
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
            System.exit(0);
        }
        DisplayMenu(connection);
    }


    private static void DisplayMenu(Connection connection) {
        while (true) {
            Scanner x = new Scanner(System.in);
            int choice;


            System.out.println("------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("DataBase Information");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("1. Display information about patients that have a last name ending in 'ou' and both see doctor with id 2019.");
            System.out.println("2. Display data on all patients and what tests they have done and when. ");
            System.out.println("3. Display all data that result from the union of two tables, patient_to_tests and test.");
            System.out.println("4. Display the patients and how much their most expensive test cost.");
            System.out.println("5. Display the patient/s that have done tests that cost more than 13$.");
            System.out.println("6. Display all the names of the patients in capital letters and a formatted date of when they have tests done.");
            System.out.println("7. Display doctors, name of patient, code of test and date of test of any test that happened after the minimum in our database.");
            System.out.println("8. Exit.");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Give me your choice : ");


            choice = x.nextInt();
            switch (choice) {
                case 1:
                    executeQ1(connection);
                    break;
                case 2:
                    executeQ2(connection);
                    break;
                case 3:
                    executeQ3(connection);
                    break;
                case 4:
                    executeQ4(connection);
                    break;
                case 5:
                    executeQ5(connection);
                    break;
                case 6:
                    executeQ6(connection);
                    break;
                case 7:
                    executeQ7(connection);
                    break;
                case 8:
                    System.out.println("Hope you enjoyed your stay, Bye Bye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid input");

            }

        }
    }
// List of methods that are called depending on user's input.
    public static void executeQ1(Connection c) {
        Statement stmt;
        ResultSet rs;

        try {
            stmt = c.createStatement();
            rs = stmt.executeQuery("select * from q1a");
            System.out.println("FIRST_NAME" + " " + "LAST_NAME");
            while (rs.next()) {
                System.out.println(rs.getString("FIRST_NAME") + " " + rs.getString("LAST_NAME"));
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong with query:" + e.getMessage());
        }
    }

    public static void executeQ2(Connection c) {

        Statement stmt;
        ResultSet rs;

        try {
            stmt = c.createStatement();
            rs = stmt.executeQuery("select * from q2a");
            System.out.println("PATIENT_ID" + " " + "TEST_DATE" + " " + "TEST_CODE");
            System.out.println("---------------------------------------------");
            while (rs.next()) {
                System.out.println(rs.getInt("PATIENT_PATIENT_ID") + ", " + rs.getDate("TEST_DATE") + ", " + rs.getInt("TEST_CODE"));
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong with query:" + e.getMessage());
        }
    }

    public static void executeQ3(Connection c) {
        Statement stmt;
        ResultSet rs;

        try {
            stmt = c.createStatement();
            rs = stmt.executeQuery("select * from q3a");
            System.out.println("ID | TESTCODE  | DATE | RESULT | TESTCODE | PRICE  | TEST_DESCRIPTION  |  REAGENT DESCRIPTION");
            while (rs.next()) {
                System.out.println(rs.getInt("PATIENT_PATIENT_ID") + ", " + rs.getInt("TEST_TEST_CODE") + ", " + rs.getDate("TEST_DATE") + ", " + rs.getInt("RESULT") + ", " + rs.getInt("TEST_CODE") + ", " + rs.getInt("TEST_PRICE") + ", " + rs.getString("TEST_DESCRIPTION")+ ", " + rs.getString("REAGENT_DESCRIPTION"));
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong with query:" + e.getMessage());
        }

    }

    public static void executeQ4(Connection c) {
        Statement stmt;
        ResultSet rs;

        try {
            stmt = c.createStatement();
            rs = stmt.executeQuery("select * from q4a");
            System.out.println("FIRST_NAME " + "| " + "LAST_NAME " + "| " +"TEST_PRICE");
            while (rs.next()) {
                System.out.println(rs.getString("FIRST_NAME") +", " + rs.getString("LAST_NAME") +", " + rs.getInt("MAX_PRICE"));
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong with query:" + e.getMessage());
        }

    }

    public static void executeQ5(Connection c) {
        Statement stmt;
        ResultSet rs;

        try {
            stmt = c.createStatement();
            rs = stmt.executeQuery("select * from q5a");
            System.out.println("FIRST_NAME " + "| " + "LAST_NAME " +"| " +"MOST_EXPENSIVE_TEST");
            while (rs.next()) {
                System.out.println(rs.getString("FIRST_NAME") +", " + rs.getString("LAST_NAME") +", " + rs.getInt("MAX_PRICE"));
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong with query:" + e.getMessage());
        }

    }


    public static void executeQ6(Connection c) {
        Statement stmt;
        ResultSet rs;

        try {
            stmt = c.createStatement();
            rs = stmt.executeQuery("select * from q6a");
            System.out.println("LAST_NAME " +"| " + "FIRST_NAME " +"| " + "DATE");
            while (rs.next()) {
                System.out.println(rs.getString("LAST_NAME_IN_CAPITAL") +", " + rs.getString("FIRST_NAME_IN_CAPITAL") +", " + rs.getString("DATE_OF_TEST"));
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong with query:" + e.getMessage());
        }

    }

    public static void executeQ7(Connection c) {
        Statement stmt;
        ResultSet rs;

        try {
            stmt = c.createStatement();
            rs = stmt.executeQuery("select * from q7a");
            System.out.println("DOCTOR_FIRST " + "| " + "DOCTOR_LAST" +"| " + "ID " +"| " + "FIRST_NAME" +"| " +"LAST_NAME" +"| " +"TEST_CODE" +"| " +"");
            while (rs.next()) {
                System.out.println(rs.getString("DOCTOR_FIRST_NAME") + ", " + rs.getString("DOCTOR_LAST_NAME") + ", " + rs.getInt("DOCTOR_ID") + ", " + rs.getString("PATIENT_FIRST_NAME") + ", " + rs.getString("PATIENT_LAST_NAME") + ", " + rs.getInt("PATIENT_ID") + ", " + rs.getInt("TESTCODE")+ ", " + rs.getDate("DATEFORTEST"));
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong with query:" + e.getMessage());
        }

    }
}



