/**
 * Author: Layken Gombeda
 * Date: 2025-09-07
 * Time: 02:45 PM
 */

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Object-oriented version of the SafeInput console helper library.
 * Provides validated input methods for Strings, ints, doubles, and yes/no confirmations.
 * Uses an internal Scanner (pipe) for all input.
 */
public class SafeInputObj {
    private Scanner pipe; // Scanner instance for all methods

    /**
     * Default constructor.
     * Initializes the Scanner to System.in
     */
    public SafeInputObj() {
        this.pipe = new Scanner(System.in);
    }

    /**
     * Alternate constructor.
     * Allows a custom Scanner to be passed in.
     * @param scanner The Scanner to use for input
     */
    public SafeInputObj(Scanner scanner) {
        this.pipe = scanner;
    }

    /**
     * Get a non-zero length String from the user.
     * @param prompt The input prompt to display
     * @return A non-empty String
     */
    public String getNonZeroLenString(String prompt) {
        String retString;
        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.trim().length() == 0);
        return retString;
    }

    /**
     * Get an int value from the user.
     * @param prompt The input prompt to display
     * @return A valid int value
     */
    public int getInt(String prompt) {
        int result = 0;
        boolean ok = false;
        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextInt()) {
                result = pipe.nextInt();
                pipe.nextLine();
                ok = true;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                pipe.nextLine();
            }
        } while (!ok);
        return result;
    }

    /**
     * Get an int value within a specific range.
     * @param prompt The input prompt to display
     * @param low The minimum acceptable value
     * @param high The maximum acceptable value
     * @return An int value between low and high (inclusive)
     */
    public int getRangedInt(String prompt, int low, int high) {
        int result = 0;
        boolean ok = false;
        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {
                result = pipe.nextInt();
                pipe.nextLine();
                ok = (result >= low && result <= high);
                if (!ok) {
                    System.out.println("Input must be between " + low + " and " + high + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                pipe.nextLine();
            }
        } while (!ok);
        return result;
    }

    /**
     * Get a double value from the user.
     * @param prompt The input prompt to display
     * @return A valid double value
     */
    public double getDouble(String prompt) {
        double result = 0.0;
        boolean ok = false;
        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextDouble()) {
                result = pipe.nextDouble();
                pipe.nextLine();
                ok = true;
            } else {
                System.out.println("Invalid input. Please enter a number.");
                pipe.nextLine();
            }
        } while (!ok);
        return result;
    }

    /**
     * Get a double value within a specific range.
     * @param prompt The input prompt to display
     * @param low The minimum acceptable value
     * @param high The maximum acceptable value
     * @return A double value between low and high (inclusive)
     */
    public double getRangedDouble(String prompt, double low, double high) {
        double result = 0.0;
        boolean ok = false;
        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble()) {
                result = pipe.nextDouble();
                pipe.nextLine();
                ok = (result >= low && result <= high);
                if (!ok) {
                    System.out.println("Input must be between " + low + " and " + high + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                pipe.nextLine();
            }
        } while (!ok);
        return result;
    }

    /**
     * Get a String that matches a regular expression pattern.
     * @param prompt The input prompt to display
     * @param regEx The regular expression to validate against
     * @return A String matching the regex
     */
    public String getRegExString(String prompt, String regEx) {
        String result;
        boolean ok = false;
        do {
            System.out.print(prompt + " (must match pattern): ");
            result = pipe.nextLine();
            if (Pattern.matches(regEx, result)) {
                ok = true;
            } else {
                System.out.println("Input does not match the required format.");
            }
        } while (!ok);
        return result;
    }

    /**
     * Get a yes/no confirmation from the user.
     * @param prompt The input prompt to display
     * @return true if user enters Y/y, false if N/n
     */
    public boolean getYNConfirm(String prompt) {
        String response;
        boolean ok = false;
        boolean retVal = false;
        do {
            System.out.print(prompt + " [Y/N]: ");
            response = pipe.nextLine().trim().toUpperCase();
            if (response.equals("Y")) {
                ok = true;
                retVal = true;
            } else if (response.equals("N")) {
                ok = true;
                retVal = false;
            } else {
                System.out.println("Please enter Y or N.");
            }
        } while (!ok);
        return retVal;
    }
}
