/**
 * Author: Layken Gombeda
 * Date: 2025-09-07
 * Time: 08:12 PM
 */

public class SafeInputTestDriver {
    public static void main(String[] args) {
        SafeInputObj input = new SafeInputObj();

        // Test each method
        String name = input.getNonZeroLenString("Enter your name");
        int age = input.getRangedInt("Enter your age", 1, 120);
        double price = input.getRangedDouble("Enter a price", 0.0, 1000.0);
        String code = input.getRegExString("Enter a 3-letter code", "^[A-Z]{3}$");
        boolean confirm = input.getYNConfirm("Do you like Java?");

        // Print summary
        System.out.printf("\nYou entered:\nName: %s\nAge: %d\nPrice: %.2f\nCode: %s\nConfirm: %b\n",
                name, age, price, code, confirm);
    }
}
