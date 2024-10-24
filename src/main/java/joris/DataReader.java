package joris;

import java.io.*;

public class DataReader {
    private String filePath;

    // Constructor to set the file path
    public DataReader(String filePath) {
        this.filePath = filePath;
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
