package ploymorphic;

public class Worker extends Employee {
    public Worker(String name, double salary) {
        super(name, salary);
    }

    public void work(){
        System.out.println("working....");
    }

    public double getAnnual(){
        return super.getAnnual();
    }
}
