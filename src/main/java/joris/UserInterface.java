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
                scanner.nextLine();
                System.out.println("Enter the country (default: 'All'):");
                String country = scanner.nextLine();
                System.out.println("Enter the commodity (default: 'All'):");
                String commodity = scanner.nextLine();
                System.out.println("Enter the transport mode (default: 'All'):");
                String transport_mode = scanner.nextLine();
                System.out.println("Enter the measure (default: '$'):");
                String measure = scanner.nextLine();

                // Call monthlyTotal method and display the result
                double total = monthlyData.monthlyTotal(month, year, country, commodity, transport_mode, measure);
                System.out.printf("Total import and export value for %02d/%d: $%.2f%n", month, year, total);
            }

            if (input.equals("monthly_average")) {

                System.out.println("Enter the year (e.g., 2015): ");
                int year = scanner.nextInt();
                System.out.println("Enter the month (1-12): ");
                int month = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the country (default: 'All')");
                String country = scanner.nextLine();
                System.out.println("Enter the commodity (default: 'All')");
                String commodity = scanner.nextLine();
                System.out.println("Enter the transport mode (default: 'All')");
                String transport_mode = scanner.nextLine();
                System.out.println("Enter the measure (default: '$')");
                String measure = scanner.nextLine();

                double total = monthlyData.monthlyAverage(month, year, country, commodity, transport_mode, measure);
                System.out.printf("The monthly average for %02d/%d: $%.2f%n", month, year, total);
            }

            if (input.equals("yearly_total")) {
                System.out.println("Enter the year (e.g., 2015): ");
                int year = scanner.nextInt();
                scanner.nextLine();

                yearlyData.yearlyTotal(year);
            }

            if (input.equals("yearly_average")) {
                System.out.println("Enter the year (e.g., 2015): ");
                int year = scanner.nextInt();
                scanner.nextLine();

                yearlyData.yearlyAverage(year);
            }

            // HELP
            if (input.equals("help")) {
                System.out.println();
                System.out.println("COMMANDS:");
                System.out.println();
                System.out.println("help - Show available commands");
                System.out.println("monthly_total - Get total for a specific month and year");
                System.out.println("monthly_average - Get monthly average for a specific month and year");
                System.out.println("yearly_total - Get total for a specific year");
                System.out.println("yearly_average - Get yearly average");
                System.out.println("overview - Display a summary of the data");
            }

            if (input.equals("help monthly_total")) {
                System.out.println();
                System.out.println(
                        "Description: This command calculates and displays the total trade value (import and export combined) for a specified month in a specified year.");
                System.out.println();
                System.out.println("Parameters:");
                System.out.println("- Year: The year for which the monthly total is required. Example: 2015.");
                System.out.println(
                        "- Month: The month for which the total is calculated, specified as an integer between 1 and 12 (where 1 represents January, and 12 represents December).");
            }

            if (input.equals("help monthly_average")) {
                System.out.println();
                System.out.println(
                        "Description: This command calculates the average trade value for each day in a specified month and year.");
                System.out.println();
                System.out.println("Parameters:");
                System.out.println("- Year: The year for which the monthly average is required. Example: 2015.");
                System.out.println(
                        "- Month: The month for which the average is calculated, specified as an integer between 1 and 12.");
            }

            if (input.equals("help yearly_total")) {
                System.out.println();
                System.out.println(
                        "Description: This command calculates and displays the total trade value (import and export combined) for an entire year.");
                System.out.println();
                System.out.println("Parameters:");
                System.out.println("- Year: The year for which the yearly total is required. Example: 2015.");
            }

            if (input.equals("help yearly_average")) {
                System.out.println();
                System.out.println(
                        "Description: This command (if implemented) would calculate and display the average monthly trade value over a specified year. This is useful for understanding the general trade trend over the year.");
                System.out.println();
                System.out.println("Parameters:");
                System.out.println("- Year: The year for which the average is required. Example: 2015.");
            }

            // EXIT
            if (input.equals("exit")) {
                System.out.println("Exiting the Data Analysis Tool. Goodbye!");
                break;
            }
        }
    }
}
