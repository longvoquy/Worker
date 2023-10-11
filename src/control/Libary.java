package control;

import data.History;
import data.Worker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Predicate;

public class Libary {
    public static ArrayList<Worker> workersList = new ArrayList<>();
    public static ArrayList<History> historyList = new ArrayList<>();


    //-------------------------------------------------------------------------------
    public String getValidWorkerID(Scanner scanner, ArrayList<String> workersList) {
        String id;
        do {
            id = getInput("Enter Worker ID: ", scanner, s -> !s.isEmpty(), "ID cannot be empty");
            if (workersList.contains(id)) {
                System.err.println("ID already exists. Please enter a different ID.");
            } else if (id == null) {
                System.err.println("ID cannot be null.");
            } else {
                System.out.println("ID does not exist in the list.");
            }
        } while (workersList.contains(id) || id == null);
        return id;
    }

    public int getValidAge(Scanner scanner) {
        int age;
        do {
            String ageInput = getInput("Enter Worker Age: ", scanner, s -> s.matches("\\d+"), "Age must be a number");
            age = Integer.parseInt(ageInput);
            if (age < 18 || age > 50) {
                System.err.println("Age must be in the range of 18 to 50.");
            }
        } while (age < 18 || age > 50);
        return age;
    }

    public double getValidSalary(Scanner scanner) {
        double salary;
        do {
            String salaryInput = getInput("Enter Worker Salary: ", scanner, s -> s.matches("\\d+(\\.\\d+)?") && Double.parseDouble(s) > 0, "Invalid salary (must be a positive number)");
            salary = Double.parseDouble(salaryInput);
        } while (salary <= 0);
        return salary;
    }

    public double getAmount(Scanner scanner) {
        double amount;
        do {
            String amountInput = getInput("Enter Amount: ", scanner, s -> s.matches("\\d+(\\.\\d+)?") && Double.parseDouble(s) > 0, "Invalid Amount (must be a positive number)");
            amount = Double.parseDouble(amountInput);
        } while (amount <= 0);
        return amount;

    }

    //--------------------------------------------------------
    public void printChangeHistory(ArrayList<History> historyList) {
        if (historyList.isEmpty()) {
            System.out.println("No change history available.");
        } else {
            System.out.println("--------------------Display Information Salary-----------------------");
            System.out.printf("%-4s  %-10s  %-8s  %-8s  %-8s  %-12s%n", "Code", "Name", "Age", "Salary", "Status", "Date");
            for (History history : historyList) {
                System.out.printf("%-5s%-15s%-5d%-10.2f%-10s%-20s\n", history.getiD(),
                        history.getName(), history.getAge(), history.getSalary(),
                        history.getStatus(), history.getDate());
            }
        }
    }

    public String getInput(String prompt, Scanner scanner, Predicate<String> validator, String errorMessage) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine();
            if (!validator.test(input)) {

                System.err.println(errorMessage);
            }
        } while (!validator.test(input));
        return input;
    }
}
