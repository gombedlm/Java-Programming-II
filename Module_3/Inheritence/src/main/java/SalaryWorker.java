package main.java;

public class SalaryWorker extends Worker {
    private double annualSalary;

    public SalaryWorker(String firstName, String lastName, String ID, String title, int YOB, double annualSalary) {
        super(firstName, lastName, ID, title, YOB, 0.0);
        this.annualSalary = annualSalary;
    }

    public double getAnnualSalary() { return annualSalary; }
    public void setAnnualSalary(double annualSalary) { this.annualSalary = annualSalary; }

    @Override
    public double calculateWeeklyPay(double hoursWorked) {
        return annualSalary / 52.0;
    }

    @Override
    public void displayWeeklyPay(double hoursWorked) {
        double weekly = calculateWeeklyPay(hoursWorked);
        System.out.printf("%s - SALARY: Annual $%.2f -> Weekly $%.2f%n",
                this.toString(), annualSalary, weekly);
    }

    @Override
    public String toCSV() {
        return super.toCSV() + String.format(",%.2f", annualSalary);
    }

    @Override
    public String toXML() {
        return String.format("<SalaryWorker>%s<AnnualSalary>%.2f</AnnualSalary></SalaryWorker>",
                super.toXML(), annualSalary);
    }

    @Override
    public String toJSON() {
        String parentJson = super.toJSON();
        return parentJson.substring(0, parentJson.length()-1) +
                String.format(",\"annualSalary\":%.2f}", annualSalary);
    }
}

