import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Object-oriented version of the SafeInput console helper library.
 * Contains an internal Scanner 'pipe' used by all methods.
 */
public class SafeInputObj {
    private Scanner pipe;

    /** Default constructor: uses System.in */
    public SafeInputObj() {
        this.pipe = new Scanner(System.in);
    }

    /** Constructor that accepts a Scanner (not required by lab to use) */
    public SafeInputObj(Scanner scanner) {
        this.pipe = scanner;
    }

    /**
     * Get a non-zero length string from the user.
     * @param prompt message to display
     * @return a non-empty String
     */
    public String getNonZeroLenString(String prompt) {
        String retString = "";
        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.trim().length() == 0);
        return retString;
    }

    /**
     * Get an int value from the user.
     * @param prompt prompt to show
     * @return int value entered
     */
    public int getInt(String prompt) {
        int result = 0;
        boolean ok = false;
        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextInt()) {
                result = pipe.nextInt();
                pipe.nextLine(); // clear newline
                ok = true;
            } else {
                pipe.nextLine(); // clear bad input
            }
        } while (!ok);
        return result;
    }

    /**
     * Get an int within an inclusive range.
     * @param prompt prompt to show
     * @param low low (inclusive)
     * @param high high (inclusive)
     * @return int value in range
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
            } else {
                pipe.nextLine();
            }
        } while (!ok);
        return result;
    }

    /**
     * Get a double from the user.
     * @param prompt prompt to show
     * @return double value
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
                pipe.nextLine();
            }
        } while (!ok);
        return result;
    }

    /**
     * Get a double within an inclusive range.
     * @param prompt prompt to show
     * @param low low (inclusive)
     * @param high high (inclusive)
     * @return double in range
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
            } else {
                pipe.nextLine();
            }
        } while (!ok);
        return result;
    }

    /**
     * Get a string that matches a given regular expression.
     * @param prompt prompt to show
     * @param regEx the regex pattern the input must match
     * @return a string matching the regex
     */
    public String getRegExString(String prompt, String regEx) {
        String result = "";
        boolean ok = false;
        do {
            System.out.print(prompt + " (must match " + regEx + "): ");
            result = pipe.nextLine();
            if (Pattern.matches(regEx, result)) {
                ok = true;
            }
        } while (!ok);
        return result;
    }

    /**
     * Yes/No confirmation.
     * @param prompt prompt to show
     * @return true for yes, false for no
     */
    public boolean getYNConfirm(String prompt) {
        String resp;
        do {
            System.out.print(prompt + " [Y/N]: ");
            resp = pipe.nextLine().trim().toUpperCase();
        } while (!(resp.equals("Y") || resp.equals("N")));
        return resp.equals("Y");
    }
}
