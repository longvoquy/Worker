package data;

public class History extends Worker implements Comparable<History> {

    private String status;
    private String date;


    public History(String iD, String name, int age, Double salary, String workStation, String status, String date) {
        super(iD, name, age, salary, workStation);
        this.status = status;
        this.date = date;
    }


    public String getStatus() {
        return status;
    }


    public String getDate() {
        return date;
    }


    @Override
    public int compareTo(History t) {
        return this.getiD().compareTo(t.getiD());
    }


}