import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Collects Product records using SafeInputObj,
 * stores them in an ArrayList, and writes to a CSV file.
 */
public class ProductGenerator {
    public static void main(String[] args) {
        SafeInputObj input = new SafeInputObj();  // object-oriented SafeInput
        ArrayList<Product> products = new ArrayList<>();
        boolean more = true;

        while (more) {
            String name = input.getNonZeroLenString("Enter product name");
            String desc = input.getNonZeroLenString("Enter product description");
            String id = input.getNonZeroLenString("Enter product ID");
            double cost = input.getDouble("Enter product cost");

            products.add(new Product(name, desc, id, cost));
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
