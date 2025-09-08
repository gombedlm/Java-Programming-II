/**
 * Author: Layken Gombeda
 * Date: 2025-09-08
 * Time: 12:43 AM
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

/**
 * Collects Product records using SafeInputObj,
 * stores them in an ArrayList<Product>, and writes them to a CSV file.
 */
public class ProductGenerator {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        SafeInputObj input = new SafeInputObj();  // object-based input helper

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath(), "ProductData.csv");

        boolean done = false;

        do {
            String id = input.getNonZeroLenString("Enter the Product ID [6 Digits]");
            String name = input.getNonZeroLenString("Enter the Product Name");
            String description = input.getNonZeroLenString("Enter the Product Description");
            double cost = input.getDouble("Enter the Product Cost");

            // Create a Product object and add to list
            products.add(new Product(name, description, id, cost));

            done = input.getYNConfirm("Are you done adding records?");
        } while (!done);

        // Print products to console
        for (Product p : products) {
            System.out.println(p.toCSV());
        }

        // Write to file
        try (OutputStream out = Files.newOutputStream(file, CREATE);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out))) {

            for (Product p : products) {
                writer.write(p.toCSV());
                writer.newLine();
            }
            System.out.println("Data file written to: " + file.toAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
