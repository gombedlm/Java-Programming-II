package main.java;

public class Worker extends Person {
    private double hourlyPayRate;

    public Worker(String firstName, String lastName, String ID, String title, int YOB, double hourlyPayRate) {
        super(firstName, lastName, ID, title, YOB);
        this.hourlyPayRate = hourlyPayRate;
    }

    public double getHourlyPayRate() { return hourlyPayRate; }
    public void setHourlyPayRate(double hourlyPayRate) { this.hourlyPayRate = hourlyPayRate; }

    public double calculateWeeklyPay(double hoursWorked) {
        double regularHours = Math.min(40.0, hoursWorked);
        double overtimeHours = Math.max(0.0, hoursWorked - 40.0);
        double regularPay = regularHours * hourlyPayRate;
        double overtimePay = overtimeHours * hourlyPayRate * 1.5;
        return regularPay + overtimePay;
    }

    public void displayWeeklyPay(double hoursWorked) {
        double regularHours = Math.min(40.0, hoursWorked);
        double overtimeHours = Math.max(0.0, hoursWorked - 40.0);
        double regularPay = regularHours * hourlyPayRate;
        double overtimePay = overtimeHours * hourlyPayRate * 1.5;
        double total = regularPay + overtimePay;

        System.out.printf(
                "%s - Hours: %.1f (regular %.1f hrs -> $%.2f), overtime %.1f hrs -> $%.2f, TOTAL: $%.2f%n",
                this.toString(), hoursWorked, regularHours, regularPay, overtimeHours, overtimePay, total);
    }

    @Override
    public String toCSV() {
        return super.toCSV() + String.format(",%.2f", hourlyPayRate);
    }

    @Override
    public String toXML() {
        return String.format("<Worker>%s<HourlyPayRate>%.2f</HourlyPayRate></Worker>",
                super.toXML(), hourlyPayRate);
    }

    @Override
    public String toJSON() {
        String parentJson = super.toJSON();
        return parentJson.substring(0, parentJson.length()-1) +
                String.format(",\"hourlyPayRate\":%.2f}", hourlyPayRate);
    }
}

