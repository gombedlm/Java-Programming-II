/**
 * Author: Layken Gombeda
 * Date: 2025-09-07
 * Time: 03:12 PM
 */

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Object-oriented version of the SafeInput console helper library.
 * Provides validated input methods for Strings, ints, doubles, and yes/no confirmations.
 */
public class SafeInputObj {
    private Scanner pipe;

    public SafeInputObj() {
        this.pipe = new Scanner(System.in);
    }

    public SafeInputObj(Scanner scanner) {
        this.pipe = scanner;
    }

    public String getNonZeroLenString(String prompt) {
        String retString;
        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.trim().length() == 0);
        return retString;
    }

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
