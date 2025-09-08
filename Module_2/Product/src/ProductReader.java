/**
 * Author: Layken Gombeda
 * Date: 2025-09-08
 * Time: 12:43 AM
 */

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        ArrayList<Product> products = new ArrayList<>();

        try {
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                Scanner scanner = new Scanner(file);

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] fields = line.split(",");

                    if (fields.length == 4) {   // ✅ safety check
                        String name = fields[0];
                        String description = fields[1];
                        String id = fields[2];
                        double cost = Double.parseDouble(fields[3]);

                        products.add(new Product(name, description, id, cost));
                    }
                }
                scanner.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        // Print formatted table
        System.out.printf("%-10s %-20s %-25s %-10s%n", "ID", "Name", "Description", "Cost");
        System.out.println("-----------------------------------------------------------------------");
        for (Product p : products) {
            System.out.printf("%-10s %-20s %-25s %-10.2f%n",
                    p.getID(), p.getName(), p.getDescription(), p.getCost());
        }
    }
}
