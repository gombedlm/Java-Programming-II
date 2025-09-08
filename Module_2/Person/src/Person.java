/**
 * Author: Layken Gombeda
 * Date: 2025-09-08
 * Time: 12:43 AM
 */

import java.util.Calendar;

public class Person {
    private String firstName;
    private String lastName;
    private final String ID;
    private String title;
    private int YOB;

    public Person(String firstName, String lastName, String ID, String title, int YOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.title = title;
        setYOB(YOB);
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getID() { return ID; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getYOB() { return YOB; }
    public void setYOB(int YOB) {
        if (YOB >= 1940 && YOB <= 2010) {
            this.YOB = YOB;
        } else {
            throw new IllegalArgumentException("Year of Birth must be between 1940 and 2010");
        }
    }

    public String fullName() {
        return firstName + " " + lastName;
    }

    public String formalName() {
        return title + " " + fullName();
    }

    public String getAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return String.valueOf(currentYear - this.YOB);
    }

    public String getAge(int year) {
        return String.valueOf(year - this.YOB);
    }

    // ✅ Fixed: now uses commas
    public String toCSV() {
        return firstName + "," + lastName + "," + ID + "," + title + "," + YOB;
    }

    public String toJSON() {
        return String.format(
                "{\"firstName\":\"%s\",\"lastName\":\"%s\",\"ID\":\"%s\",\"title\":\"%s\",\"YOB\":%d}",
                firstName, lastName, ID, title, YOB
        );
    }

    public String toXML() {
        return String.format(
                "<Person><FirstName>%s</FirstName><LastName>%s</LastName><ID>%s</ID><Title>%s</Title><YOB>%d</YOB></Person>",
                firstName, lastName, ID, title, YOB
        );
    }
}
