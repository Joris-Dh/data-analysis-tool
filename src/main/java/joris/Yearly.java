package joris;

import java.io.*;

public class Yearly {
    private String csvData;

    // Constructor to set the file path
    public Yearly(String csvData) {
        this.csvData = csvData;
    }

    public double yearlyTotal(int year) {
        BufferedReader reader = null;
        String line = "";
        double totalValue = 0.0;
        double january = 0.0;
        double february = 0.0;
        double march = 0.0;
        double april = 0.0;
        double may = 0.0;
        double june = 0.0;
        double july = 0.0;
        double august = 0.0;
        double september = 0.0;
        double october = 0.0;
        double november = 0.0;
        double december = 0.0;

        try {
            reader = new BufferedReader(new FileReader(csvData));
            reader.readLine(); // Skip the header row
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");

                // Extract relevant data
                int fileYear = Integer.parseInt(row[1]);
                String date = row[2];
                int fileMonth = Integer.parseInt(date.split("/")[1]); // Extract month from date

                // Check if the Value column is a valid number
                String valueString = row[8].replace("$ ", "").replace(",", "");
                if (isNumeric(valueString)) {
                    double value = Double.parseDouble(valueString);

                    // Check if this row matches the specified month and year
                    if (fileYear == year) {
                        totalValue += value;

                        if (fileMonth == 1) {
                            january += value;
                        } else if (fileMonth == 2) {
                            february += value;
                        } else if (fileMonth == 3) {
                            march += value;
                        } else if (fileMonth == 4) {
                            april += value;
                        } else if (fileMonth == 5) {
                            may += value;
                        } else if (fileMonth == 6) {
                            june += value;
                        } else if (fileMonth == 7) {
                            july += value;
                        } else if (fileMonth == 8) {
                            august += value;
                        } else if (fileMonth == 9) {
                            september += value;
                        } else if (fileMonth == 10) {
                            october += value;
                        } else if (fileMonth == 11) {
                            november += value;
                        } else if (fileMonth == 12) {
                            december += value;
                        } else {
                            System.out.println("No valid month.");
                        }
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
        System.out.println();
        System.out.println("January: " + january);
        System.out.println("February: " + february);
        System.out.println("March: " + march);
        System.out.println("April: " + april);
        System.out.println("May: " + may);
        System.out.println("June: " + june);
        System.out.println("July: " + july);
        System.out.println("August: " + august);
        System.out.println("September: " + september);
        System.out.println("October: " + october);
        System.out.println("November: " + november);
        System.out.println("December: " + december);
        System.out.println();
        System.out.println("Total: ");
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
}
