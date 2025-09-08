import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Reads Product records from a CSV file chosen with JFileChooser
 * and prints them in a formatted table.
 */
public class ProductReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        ArrayList<Product> products = new ArrayList<>();

        try {
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                try (Scanner inFile = new Scanner(file)) {
                    while (inFile.hasNextLine()) {
                        String line = inFile.nextLine();
                        String[] parts = line.split(",");
                        if (parts.length == 4) {
                            String name = parts[0];
                            String desc = parts[1];
                            String id = parts[2];
                            double cost = Double.parseDouble(parts[3]);
                            products.add(new Product(name, desc, id, cost));
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Print table header
        System.out.printf("%-15s %-20s %-10s %-10s%n",
                "Name", "Description", "ID", "Cost");
        System.out.println("--------------------------------------------------------------");

        // Print each Product
        for (Product p : products) {
            System.out.printf("%-15s %-20s %-10s %-10.2f%n",
                    p.getName(), p.getDescription(), p.getID(), p.getCost());
        }
    }
}
