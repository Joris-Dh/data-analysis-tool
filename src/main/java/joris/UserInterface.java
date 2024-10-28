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
        DataReader dataReader = new DataReader(file);

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
        System.out.println();
        String input = scanner.nextLine();

        if (input.equals("monthly_total")) {
            // Input month and year from the user
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the year (e.g., 2015): ");
            int year = scanner.nextInt();
            System.out.println("Enter the month (1-12): ");
            int month = scanner.nextInt();
            scanner.close();

            // Call monthlyTotal method and display the result
            double total = dataReader.monthlyTotal(month, year);
            System.out.printf("Total import and export value for %02d/%d: $%.2f%n", month, year, total);
        }

        if (input.equals("monthly_average")) {
            // Input month and year from the user
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the year (e.g., 2015): ");
            int year = scanner.nextInt();
            System.out.println("Enter the month (1-12): ");
            int month = scanner.nextInt();
            scanner.close();

            // Call monthlyTotal method and display the result
            double total = dataReader.monthlyAverage(month, year);
            System.out.printf("The monthly average for %02d/%d: $%.2f%n", month, year, total);
        }

    }
}
