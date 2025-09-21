// Interfaces/ShortLister.java
// Lets the user pick a text file (JFileChooser) and prints the short words.
import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class ShortLister {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            Filter filter = new ShortWordFilter();

            try (Scanner scanner = new Scanner(file)) {
                System.out.println("Short words (length < 5) in " + file.getName() + ":");
                while (scanner.hasNext()) {
                    String word = scanner.next();
                    if (filter.accept(word)) {
                        System.out.println(word);
                    }
                }
            } catch (IOException e) {
                System.err.println("Error reading file: " + e.getMessage());
            }
        } else {
            System.out.println("No file selected.");
        }
    }
}
