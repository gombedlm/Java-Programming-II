package main.java;

public class Person {
    private String firstName;
    private String lastName;
    private final String ID;
    private String title;
    private int YOB;

    public Person(String firstName, String lastName, String ID, String title, int YOB){
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.title = title;
        this.YOB = YOB;
    }

    //Getters and setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getID() { return ID; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getYOB() { return YOB; }
    public void setYOB(int YOB) { this.YOB = YOB; }

    // Export methods
    public String toCSV() {
        return String.format("%s,%s,%s,%s,%d", firstName, lastName, ID, title, YOB);
    }

    public String toXML() {
        return String.format(
                "<Person><FirstName>%s</FirstName><LastName>%s</LastName><ID>%s</ID><Title>%s</Title><YOB>%d</YOB></Person>",
                firstName, lastName, ID, title, YOB);
    }

    public String toJSON() {
        return String.format(
                "{\"firstName\":\"%s\",\"lastName\":\"%s\",\"ID\":\"%s\",\"title\":\"%s\",\"YOB\":%d}",
                firstName, lastName, ID, title, YOB);
    }

    @Override
    public String toString() {
        return String.format("%s %s (%s)", title == null ? "" : title, firstName + " " + lastName, ID);
    }
}
