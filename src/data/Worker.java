package data;

public class Worker {
    protected String iD;
    protected String name;
    protected int age;
    protected Double salary;
    protected String workStation;

    public Worker(String iD, String name, int age, Double salary, String workStation) {
        this.iD = iD;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.workStation = workStation;
    }

    public String getiD() {
        return iD;
    }


    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }


    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getWorkStation() {
        return workStation;
    }
}



