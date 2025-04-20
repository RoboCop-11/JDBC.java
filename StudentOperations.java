// Name: Manan
// PRN: 23070126156
// Batch: AIML-B3

import java.sql.*;
import java.util.Scanner;

// Class for handling student database operations
public class StudentOperations {

    // JDBC credentials
    private static final String URL = "jdbc:mysql://localhost:3306/student_db";
    private static final String USER = "root";
    private static final String PASSWORD = "A1s2D3f4@1";

    /**
     * Inserts a student record into the database
     */
    public void insertStudent() {
        try (
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement stmt = conn.prepareStatement(
                        "INSERT INTO students (PRN, Name, Branch, Batch, CGPA) VALUES (?, ?, ?, ?, ?)"
                );
                Scanner scanner = new Scanner(System.in)
        ) {
            // Input details from user
            System.out.print("Enter PRN: ");
            int prn = scanner.nextInt();
            scanner.nextLine(); // consume leftover newline
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Branch: ");
            String branch = scanner.nextLine();
            System.out.print("Enter Batch: ");
            String batch = scanner.nextLine();
            System.out.print("Enter CGPA: ");
            float cgpa = scanner.nextFloat();

            // Set values to prepared statement
            stmt.setInt(1, prn);
            stmt.setString(2, name);
            stmt.setString(3, branch);
            stmt.setString(4, batch);
            stmt.setFloat(5, cgpa);

            // Execute insert
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Student record inserted successfully!");
            }

        } catch (SQLException e) {
            System.out.println(" Failed to insert student.");
            e.printStackTrace();
        }
    }

    /**
     * Displays all student records from the database
     */
    public void viewStudents() {
        try (
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM students")
        ) {
            // Display records
            System.out.println("\n--- Student Records ---");
            System.out.printf("%-10s %-20s %-10s %-10s %-5s%n", "PRN", "Name", "Branch", "Batch", "CGPA");
            System.out.println("-----------------------------------------------------------");

            

