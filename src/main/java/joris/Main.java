package joris;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Specify the file path
        String file = "src//covid_and_trade.csv";

        // Create a DataReader instance
        DataReader dataReader = new DataReader(file);

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
}
