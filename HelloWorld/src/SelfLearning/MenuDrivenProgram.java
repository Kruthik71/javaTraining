package SelfLearning;

import java.util.Scanner;

public class MenuDrivenProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add your code for option 1 here
                    System.out.println("Option 1 selected.");
                    break;
                case 2:
                    // Addchoic your code for option 2 here
                    System.out.println("Option 2 selected.");
                    break;
                case 3:
                    // Add your code for option 3 here
                    System.out.println("Option 3 selected.");
                    break;
                case 4:
                    // Add your code for option 4 here
                    System.out.println("Option 4 selected.");
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option (1-5).");
            }
        } while (choice != 5);

        scanner.close();
    }

    public static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Option 1");
        System.out.println("2. Option 2");
        System.out.println("3. Option 3");
        System.out.println("4. Option 4");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }
}

