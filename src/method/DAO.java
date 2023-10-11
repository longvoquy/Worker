package method;

import control.Libary;
import data.History;
import data.Worker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


public class DAO {
    private Scanner scanner = new Scanner(System.in);

    Libary lb = new Libary();

    public boolean increase(Worker w, ArrayList<History> historyList) {

        if (w == null) {
            System.err.println("Worker with the provided code does not exist.");
            return false;
        }

        double raiseAmount = lb.getAmount(scanner);
        if (raiseAmount <= 0) {
            System.err.println("Amount to raise must be greater than 0.");
            return false;
        }

        double currentSalary = w.getSalary();
        double newSalary = currentSalary + raiseAmount;

        // Create and save the history record
        historyList.add(new History(w.getiD(), w.getName(),
                w.getAge(), newSalary, w.getWorkStation(), "UP", getCurrentDate()));

        // Update the worker's salary
        w.setSalary(newSalary);
        return true;
    }


    public boolean decrease(Worker w, ArrayList<History> historyList) {

        if (w == null) {
            System.err.println("Worker with the provided code does not exist.");
            return false;
        }

        double lowerAmount = lb.getAmount(scanner);
        if (lowerAmount <= 0) {
            System.err.println("Amount to lower must be greater than 0.");
            return false;
        }

        double currentSalary = w.getSalary();
        double newSalary = currentSalary - lowerAmount;

        // Create and save the history record
        historyList.add(new History(w.getiD(), w.getName(),
                w.getAge(), newSalary, w.getWorkStation(), "Down", getCurrentDate()));

        // Update the worker's salary
        w.setSalary(newSalary);
        return true;
    }

    public String getCurrentDate() {
        // Create a DateTimeFormatter to specify the desired date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Format the date as a string and return it
        String formattedDate = currentDate.format(formatter);

        return formattedDate;
    }

    public static Worker getWorkerByCode(ArrayList<Worker> workersList, String id) {
        for (Worker worker : workersList) {
            if (id.equalsIgnoreCase(worker.getiD())) {
                return worker;
            }
        }
        return null;
    }

}
