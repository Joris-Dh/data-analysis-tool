package joris;

import java.io.*;

public class DataReader {
    private String filePath;

    // Constructor to set the file path
    public DataReader(String filePath) {
        this.filePath = filePath;
    }

    // Method to calculate monthly total for a specific month and year
    public double monthlyTotal(int month, int year) {
        BufferedReader reader = null;
        String line = "";
        double totalValue = 0.0;

        try {
            reader = new BufferedReader(new FileReader(filePath));
            reader.readLine(); // Skip the header row
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");

                // Extract relevant data
                String direction = row[0];
                int fileYear = Integer.parseInt(row[1]);
                String date = row[2];
                int fileMonth = Integer.parseInt(date.split("/")[1]); // Extract month from date

                // Check if the Value column is a valid number
                String valueString = row[8].replace("$", "").replace(",", "");
                if (isNumeric(valueString)) {
                    double value = Double.parseDouble(valueString);

                    // Check if this row matches the specified month and year
                    if (fileYear == year && fileMonth == month) {
                        totalValue += value;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return totalValue;
    }

    // Helper method to check if a string is numeric
    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Method to read the file and print its contents
    public void readFile() {
        BufferedReader reader = null;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(filePath));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                for (String index : row) {
                    System.out.printf("%-10s", index);
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
