package Task_4_FileInputOutputAndCSVreadWrite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ProductFilter {
    public static void main(String[] args) {
        String inputFile = "C:\\Java Internship Task Work\\Task_4_FileInputOutputAndCSVreadWrite\\products.csv";
        String outputFile = "C:\\Java Internship Task Work\\Task_4_FileInputOutputAndCSVreadWrite\\expensive_products.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             FileWriter writer = new FileWriter(outputFile)) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    try {
                        String name = parts[0].trim();
                        double price = Double.parseDouble(parts[1].trim());
                        if (price > 1000) {
                            writer.write(name + "," + price + "\n");
                        }
                    } catch (NumberFormatException e) {
                        // Handle invalid price format
                        System.out.println("Invalid price format: " + parts[1]);
                    }
                }
            }
            System.out.println("Filtered products written to " + outputFile);
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }

}
