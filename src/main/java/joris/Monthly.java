package joris;

import java.io.*;

public class Monthly {
    private String csvData;

    // Constructor to set the file path
    public Monthly(String csvData) {
        this.csvData = csvData;
    }

    // Method to calculate monthly total for a specific month and year
    public double monthlyTotal(int month, int year, String country, String commodity, String transport_mode,
            String measure) {
        BufferedReader reader = null;
        String line = "";
        double totalValue = 0.0;

        try {
            reader = new BufferedReader(new FileReader(csvData));
            reader.readLine(); // Skip the header row
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");

                // Extract relevant data
                int fileYear = Integer.parseInt(row[1]);
                String date = row[2];
                int fileMonth = Integer.parseInt(date.split("/")[1]); // Extract month from date
                String fileCountry = row[4];
                String fileCommodity = row[5];
                String fileTransport_mode = row[6];
                String fileMeasure = row[7];

                // Check if the Value column is a valid number
                String valueString = row[8].replace("$ ", "").replace(",", "");
                if (isNumeric(valueString)) {
                    double value = Double.parseDouble(valueString);

                    // Check if this row matches the specified month and year
                    if (fileYear == year && fileMonth == month && fileCountry == country && fileCommodity == commodity
                            && fileTransport_mode == transport_mode && fileMeasure == measure) {
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

    // Method to calculate monthly average for a specific month and year
    public double monthlyAverage(int month, int year, String country, String commodity, String transport_mode,
            String measure) {
        BufferedReader reader = null;
        String line = "";
        double totalValue = 0.0;
        int totalRows = 0;

        try {
            reader = new BufferedReader(new FileReader(csvData));
            reader.readLine(); // Skip the header row
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");

                // Extract relevant data
                int fileYear = Integer.parseInt(row[1]);
                String date = row[2];
                int fileMonth = Integer.parseInt(date.split("/")[1]); // Extract month from date
                String fileCountry = row[4];
                String fileCommodity = row[5];
                String fileTransport_mode = row[6];
                String fileMeasure = row[7];

                // Check if the Value column is a valid number
                String valueString = row[8].replace("$ ", "").replace(",", "");
                if (isNumeric(valueString)) {
                    double value = Double.parseDouble(valueString);

                    // Check if this row matches the specified month and year
                    if (fileYear == year && fileMonth == month && fileCountry == country && fileCommodity == commodity
                            && fileTransport_mode == transport_mode && fileMeasure == measure) {
                        totalValue += value;
                        totalRows += 1;
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
        return totalValue / totalRows;
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
}
