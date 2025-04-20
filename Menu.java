// Name: Manan
// PRN: 23070126156
// Batch: AIML-B3

import java.util.Scanner;

// Class to display and handle user menu
public class Menu {

    public static void displayMenu(StudentOperations studentOps) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Data Entry System ---");
            System.out.println("1. Insert Student");
            System.out.println("2. View All Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            // Perform operation based on user input
            switch (choice) {
                case 1:
                    studentOps.insertStudent();
                    break;
                case 2:
                    studentOps.viewStudents();
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 3);
    }
}
