package control;

import data.Worker;
import method.Basic;
import method.DAO;
import view.Menu;

import java.util.ArrayList;
import java.util.Scanner;

import static control.Libary.historyList;
import static control.Libary.workersList;

public class Control extends Menu<String> {


    private Scanner scanner = new Scanner(System.in);
    private static Basic bs = new Basic();
    Libary lb = new Libary();
    public ArrayList<String> inputID = new ArrayList<>();


    //--------------------------------------------------------
    static String[] menu = {"Add Worker", "Up Salary", "Down Salary", "Show Salary", "EXIT (0)"};

    public Control() {
        super("\n----------!!Control System!!----------", menu);

    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1 -> addWorker();
            case 2 -> upSalary();
            case 3 -> downSalary();
            case 4 -> printlistHistory();
        }
    }

    //--------------------------------------------------------
    public void printlistHistory() {
        // Gọi phương thức để in ra lịch sử thay đổi
        lb.printChangeHistory(historyList);
    }

    //--------------------------------------------------------
    private void downSalary() {
        boolean check;
        String iD = lb.checkValidWorkerID(scanner, inputID); // Truyền danh sách công nhân (wList) vào phương thức.

        Worker worker = DAO.getWorkerByCode(workersList, iD); // Gọi phương thức getWorkerByCode với danh sách công nhân và mã công nhân.

        if (worker != null) {
            check = bs.decrease(worker); // Gọi phương thức increase với công nhân cụ thể và danh sách công nhân.
            if (check) {
                System.out.println("Salary lower successfully.");
            } else {
                System.err.println("Salary lower failed.");
            }
        }
    }

    //--------------------------------------------------------
    private void upSalary() {
        boolean check;
        String iD = lb.checkValidWorkerID(scanner, inputID); // Truyền danh sách công nhân (wList) vào phương thức.

        Worker worker = DAO.getWorkerByCode(workersList, iD);// Gọi phương thức getWorkerByCode với danh sách công nhân và mã công nhân.

        if (worker != null) {
            check = bs.increase(worker); // Gọi phương thức decrease với công nhân cụ thể và danh sách công nhân.
            if (check) {
                System.out.println("Salary raised successfully.");
            } else {
                System.err.println("Salary raise failed.");
            }
        }

    }

    //--------------------------------------------------------
    private void addWorker() {
        boolean check;
        String iD = lb.getValidWorkerID(scanner, inputID);
        String name = lb.getInput("Enter Name: ", scanner, s -> !s.isEmpty(), "Name cannot be empty");
        int age = lb.getValidAge(scanner);
        double salary = lb.getValidSalary(scanner);
        String workL = lb.getInput("Enter work location: ", scanner, s -> !s.isEmpty(), "location cannot be empty");
        check = bs.createWorker(iD, name, age, salary, workL);

        if (check) {
            System.out.println("Input new successfully");

            // Sau khi bạn đã kiểm tra và thêm công nhân mới, hãy thêm mã ID vào danh sách validSalaryIncreaseIDs
            inputID.add(iD);
        } else {
            System.err.println("Input new failed");
        }
    }
//--------------------------------------------------------

}
