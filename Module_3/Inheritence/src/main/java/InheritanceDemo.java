package main.java;

import java.util.ArrayList;

public class InheritanceDemo {
    public static void main(String[] args) {
        ArrayList<Worker> workers = new ArrayList<>();

        // Three hourly workers
        workers.add(new Worker("John", "Doe", "W001", "Mr.", 1990, 18.50));
        workers.add(new Worker("Ana", "Lopez", "W002", "Ms.", 1988, 22.00));
        workers.add(new Worker("Ben", "Park", "W003", "Mr.", 1992, 16.75));

        // Three salary workers
        workers.add(new SalaryWorker("Sally", "Brown", "S001", "Dr.", 1980, 52000.0));
        workers.add(new SalaryWorker("Robert", "King", "S002", "Mr.", 1975, 78000.0));
        workers.add(new SalaryWorker("Maya", "Singh", "S003", "Ms.", 1991, 45000.0));

        double[] weeks = {40.0, 50.0, 40.0};

        for (int i = 0; i < weeks.length; i++) { // formatting to make this look better
            double hours = weeks[i];
            System.out.println("\n=== Week " + (i+1) + " (" + (int)hours + " hours) ===");
            System.out.printf("%-25s %-6s %-7s %-12s%n", "Name (ID)", "Type", "Hours", "Weekly Pay");
            System.out.println("---------------------------------------------------------");
            for (Worker w : workers) {
                String type = (w instanceof SalaryWorker) ? "Salary" : "Hourly";
                double pay = w.calculateWeeklyPay(hours);
                System.out.printf("%-25s %-6s %-7.1f $%-11.2f%n",
                        (w.getFirstName() + " " + w.getLastName() + " (" + w.getID() + ")"),
                        type, hours, pay);
            }
        }

        System.out.println("\nDetailed displayWeeklyPay() output:");
        for (Worker w : workers) {
            w.displayWeeklyPay(40.0);
        }
    }
}

