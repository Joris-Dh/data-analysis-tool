package joris;

import java.text.DecimalFormat;

import java.io.*;

public class Yearly {
    private String csvData;
    private double totalValue;
    private int totalRows;

    public Yearly(String csvData) {
        this.csvData = csvData;
        this.totalValue = 0.0;
        this.totalRows = 0;
    }

    // YEARLY TOTAL

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

    // YEARLY AVERAGE

    public void yearlyAverage(int year) {
        BufferedReader reader = null;
        String line = "";

        // monthly totals
        double january = 0.0;
        int amountJanuary = 0;
        double february = 0.0;
        int amountFebruary = 0;
        double march = 0.0;
        int amountMarch = 0;
        double april = 0.0;
        int amountApril = 0;
        double may = 0.0;
        int amountMay = 0;
        double june = 0.0;
        int amountJune = 0;
        double july = 0.0;
        int amountJuly = 0;
        double august = 0.0;
        int amountAugust = 0;
        double september = 0.0;
        int amountSeptember = 0;
        double october = 0.0;
        int amountOctober = 0;
        double november = 0.0;
        int amountNovember = 0;
        double december = 0.0;
        int amountDecember = 0;

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
                        totalRows += 1;

                        if (fileMonth == 1) {
                            january += value;
                            amountJanuary += 1;
                        } else if (fileMonth == 2) {
                            february += value;
                            amountFebruary += 1;
                        } else if (fileMonth == 3) {
                            march += value;
                            amountMarch += 1;
                        } else if (fileMonth == 4) {
                            april += value;
                            amountApril += 1;
                        } else if (fileMonth == 5) {
                            may += value;
                            amountMay += 1;
                        } else if (fileMonth == 6) {
                            june += value;
                            amountJune += 1;
                        } else if (fileMonth == 7) {
                            july += value;
                            amountJuly += 1;
                        } else if (fileMonth == 8) {
                            august += value;
                            amountAugust += 1;
                        } else if (fileMonth == 9) {
                            september += value;
                            amountSeptember += 1;
                        } else if (fileMonth == 10) {
                            october += value;
                            amountOctober += 1;
                        } else if (fileMonth == 11) {
                            november += value;
                            amountNovember += 1;
                        } else if (fileMonth == 12) {
                            december += value;
                            amountDecember += 1;
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
        System.out.println("January: " + df.format(january / amountJanuary));
        System.out.println("February: " + df.format(february / amountFebruary));
        System.out.println("March: " + df.format(march / amountMarch));
        System.out.println("April: " + df.format(april / amountApril));
        System.out.println("May: " + df.format(may / amountMay));
        System.out.println("June: " + df.format(june / amountJune));
        System.out.println("July: " + df.format(july / amountJuly));
        System.out.println("August: " + df.format(august / amountAugust));
        System.out.println("September: " + df.format(september / amountSeptember));
        System.out.println("October: " + df.format(october / amountOctober));
        System.out.println("November: " + df.format(november / amountNovember));
        System.out.println("December: " + df.format(december / amountDecember));
        System.out.println();
        System.out.println("Total: " + df.format(totalValue / totalRows));
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
