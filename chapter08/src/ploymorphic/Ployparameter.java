package ploymorphic;

public class Ployparameter {
    public static void main(String[] args) {

        Worker q = new Worker("q", 10000);
        Manager w = new Manager("w", 20000, 100000);
        Ployparameter ployparameter = new Ployparameter();
        ployparameter.showEmpAnnual(q);
        ployparameter.showEmpAnnual(w);
        ployparameter.testWork(q);
        ployparameter.testWork(w);


    }

    public void showEmpAnnual(Employee e){
        System.out.println(e.getAnnual());
    }

    public void testWork(Employee e){
        if(e instanceof Worker){
            ((Worker) e).work();
        }else if(e instanceof Manager){
            ((Manager) e).manager();
        }else{

        }
    }
}
