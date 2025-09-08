import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Reads Person records from a CSV file chosen with JFileChooser
 * and prints them in a formatted table.
 */
public class PersonReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        ArrayList<Person> people = new ArrayList<>();

        try {
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                try (Scanner inFile = new Scanner(file)) {
                    while (inFile.hasNextLine()) {
                        String line = inFile.nextLine();
                        String[] parts = line.split(",");
                        if (parts.length == 5) {
                            String first = parts[0];
                            String last = parts[1];
                            String id = parts[2];
                            String title = parts[3];
                            int yob = Integer.parseInt(parts[4]);
                            people.add(new Person(first, last, id, title, yob));
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Print table header
        System.out.printf("%-10s %-10s %-8s %-6s %-4s%n",
                "First", "Last", "ID", "Title", "YOB");
        System.out.println("-------------------------------------------------");

        // Print each Person
        for (Person p : people) {
            System.out.printf("%-10s %-10s %-8s %-6s %-4d%n",
                    p.getFirstName(), p.getLastName(), p.getID(),
                    p.getTitle(), p.getYOB());
        }
    }
}
