package joris;

public class Main {
    public static void main(String[] args) {

        // Specify the file path
        String file = "src//covid_and_trade.csv";

        // Create a DataReader instance
        DataReader dataReader = new DataReader(file);

        // Call the method to read and display the file
        dataReader.readFile();
    }
}
