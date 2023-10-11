package method;

import data.Worker;

import static controller.Library.historyList;
import static controller.Library.workersList;

public class Basic implements Check<Worker> {
    private static DAO dao = new DAO();


    public boolean createWorker(String id, String name, int age, Double salary, String workS) {
//        if (isWorkerIdUnique(id)) {
//            Worker w = new Worker(id, name, age, salary, workS);
//            return add(w);
//        } else {
//            System.err.println("ID is duplicated");
//            return false;
//        }
        boolean check;
        Worker w = new Worker(id, name, age, salary, workS);
        check = add(w);
        return check;
    }

    public boolean isWorkerIdUnique(String id) {
        for (Worker worker : workersList) {
            if (worker.getiD().equals(id)) {
                return false; // ID is not unique
            }
        }
        return true; // ID is unique
    }
//--------------------------------------------------------

    @Override
    public boolean add(Worker w) {
        return workersList.add(w);
    }

    //--------------------------------------------------------
    @Override
    public boolean increase(Worker w) {
        return dao.increase(w, historyList);
    }

    //--------------------------------------------------------
    @Override
    public boolean decrease(Worker w) {
        return dao.decrease(w, historyList);
    }

    //--------------------------------------------------------
    @Override
    public Worker showHistory(Worker worker) {
        return null;
    }
}