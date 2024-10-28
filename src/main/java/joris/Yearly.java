package joris;

import java.text.DecimalFormat;

import java.io.*;

public class Yearly {
    private String csvData;
    private double totalValue;

    public Yearly(String csvData) {
        this.csvData = csvData;
        this.totalValue = 0.0;
    }

    public void yearlyTotal(int year) {
        BufferedReader reader = null;
        String line = "";

        // monthly totals
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

        // Define a DecimalFormat to display full numbers without scientific notation
        DecimalFormat df = new DecimalFormat("#,##0");

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
        System.out.println("January: " + df.format(january));
        System.out.println("February: " + df.format(february));
        System.out.println("March: " + df.format(march));
        System.out.println("April: " + df.format(april));
        System.out.println("May: " + df.format(may));
        System.out.println("June: " + df.format(june));
        System.out.println("July: " + df.format(july));
        System.out.println("August: " + df.format(august));
        System.out.println("September: " + df.format(september));
        System.out.println("October: " + df.format(october));
        System.out.println("November: " + df.format(november));
        System.out.println("December: " + df.format(december));
        System.out.println();
        System.out.println("Total: " + df.format(totalValue));
    }

    // Getter for totalValue
    public double getTotalValue() {
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
