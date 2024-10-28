package joris;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {

        // Specify the file path
        String file = "src//covid_and_trade.csv";

        // Create a DataReader instance
        Monthly monthlyData = new Monthly(file);
        Yearly yearlyData = new Yearly(file);

        System.out.println();
        System.out.println("Welcome to this Data Analysis Tool!");
        System.out.println();
        System.out.println("Commands:");
        System.out.println("help");
        System.out.println("help <command>");
        System.out.println("monthly_total");
        System.out.println("monthly_average");
        System.out.println("yearly_total");
        System.out.println("yearly_average");
        System.out.println("overview");

        while (true) {
            System.out.println();
            System.out.println("Enter command:");
            String input = scanner.nextLine();

            if (input.equals("monthly_total")) {

                // Input month and year from the user
                System.out.println("Enter the year (e.g., 2015): ");
                int year = scanner.nextInt();
                System.out.println("Enter the month (1-12): ");
                int month = scanner.nextInt();

                // Call monthlyTotal method and display the result
                double total = monthlyData.monthlyTotal(month, year);
                System.out.printf("Total import and export value for %02d/%d: $%.2f%n", month, year, total);
            }

            if (input.equals("monthly_average")) {

                System.out.println("Enter the year (e.g., 2015): ");
                int year = scanner.nextInt();
                System.out.println("Enter the month (1-12): ");
                int month = scanner.nextInt();

                double total = monthlyData.monthlyAverage(month, year);
                System.out.printf("The monthly average for %02d/%d: $%.2f%n", month, year, total);
            }

            if (input.equals("yearly_total")) {

                System.out.println("Enter the year (e.g., 2015): ");
                int year = scanner.nextInt();

                double total = yearlyData.yearlyTotal(year);
                System.out.println(total);
            }

            if (input.equals("help")) {
                System.out.println();
                System.out.println("COMMANDS:");
                System.out.println();
                System.out.println("help - Show available commands");
                System.out.println("monthly_total - Get total for a specific month and year");
                System.out.println("monthly_average - Get monthly average for a specific month and year");
                System.out.println("yearly_total - Get total for a specific year");
                System.out.println("yearly_average - Get yearly average (if implemented)");
                System.out.println("overview - Display a summary of the data (if implemented)");
            }

            if (input.equals("help monthly_total")) {
                System.out.println();
            }

            if (input.equals("help monthly_average")) {
                System.out.println();
            }

            if (input.equals("help yearly_total")) {
                System.out.println();
            }

            if (input.equals("help yearly_average")) {
                System.out.println();
            }

            if (input.equals("exit")) {
                System.out.println("Exiting the Data Analysis Tool. Goodbye!");
                break;
            }
        }
    }
}
