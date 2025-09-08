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

public class PersonReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        ArrayList<Person> people = new ArrayList<>();

        try {
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                Scanner scanner = new Scanner(file);

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] fields = line.split(",");

                    if (fields.length == 5) {
                        String first = fields[0];
                        String last = fields[1];
                        String id = fields[2];
                        String title = fields[3];
                        int yob = Integer.parseInt(fields[4]);

                        people.add(new Person(first, last, id, title, yob));
                    }
                }
                scanner.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        // Print formatted table
        System.out.printf("%-10s %-15s %-15s %-10s %-5s%n", "ID", "First Name", "Last Name", "Title", "YOB");
        System.out.println("-------------------------------------------------------------------");
        for (Person p : people) {
            System.out.printf("%-10s %-15s %-15s %-10s %-5d%n",
                    p.getID(), p.getFirstName(), p.getLastName(), p.getTitle(), p.getYOB());
        }
    }
}
