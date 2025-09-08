import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Collects Person records using SafeInputObj,
 * stores them in an ArrayList, and writes to a CSV file.
 */
public class PersonGenerator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SafeInputObj input = new SafeInputObj(in);   // create an instance of SafeInputObj
        ArrayList<Person> people = new ArrayList<>();
        boolean more = true;

        while (more) {
            String first = input.getNonZeroLenString("Enter first name");
            String last = input.getNonZeroLenString("Enter last name");
            String id = input.getNonZeroLenString("Enter ID");
            String title = input.getNonZeroLenString("Enter title");
            int yob = input.getRangedInt("Enter year of birth", 1940, 2010);

            people.add(new Person(first, last, id, title, yob));
            more = input.getYNConfirm("Add another person?");
        }

        String fileName = input.getNonZeroLenString("Enter filename to save (e.g., PersonData.csv)");

        try (PrintWriter out = new PrintWriter(fileName)) {
            for (Person p : people) {
                out.println(p.toCSV());
            }
            System.out.println("Saved " + people.size() + " records to " + fileName);
        } catch (Exception e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}