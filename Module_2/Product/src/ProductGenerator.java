/**
 * Author: Layken Gombeda
 * Date: 2025-09-08
 * Time: 12:43 AM
 */

import java.io.PrintWriter;
import java.util.ArrayList;

public class ProductGenerator {
    public static void main(String[] args) {
        SafeInputObj input = new SafeInputObj();
        ArrayList<Product> products = new ArrayList<>();
        boolean more = true;

        while (more) {
            String id = input.getNonZeroLenString("Enter Product ID");
            String name = input.getNonZeroLenString("Enter Product Name");
            String description = input.getNonZeroLenString("Enter Product Description");
            double cost = input.getDouble("Enter Product Cost");

            products.add(new Product(name, description, id, cost));
            more = input.getYNConfirm("Add another product?");
        }

        String fileName = input.getNonZeroLenString("Enter filename to save (e.g., ProductData.csv)");

        try (PrintWriter out = new PrintWriter(fileName)) {
            for (Product p : products) {
                out.println(p.toCSV());
            }
            System.out.println("Saved " + products.size() + " records to " + fileName);
        } catch (Exception e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
