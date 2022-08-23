package homework;

public class Homework01 {

    public static void main(String[] args) {


        //初始化Person 对象数组，有3个person对象
        Person[] persons = new Person[3];
        persons[0] = new Person("q", 18, "q");
        persons[1] = new Person("w", 19, "w");
        persons[2] = new Person("e", 17, "e");

        //输出当前对象数组
        System.out.println("排序前");
        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i]);
        }

        //按年龄冒泡排序，小->大
        Person temp = null; //设置一个临时变量
        for (int i = 0; i < persons.length - 1; i++) {
            for (int j = 0; j < persons.length - 1 - i; j++) {
                if(persons[j].getAge() > persons[j+1].getAge()){
                    temp = persons[j];
                    persons[j] = persons[j+1];
                    persons[j+1] = temp;
                }
            }
        }
        //输出排序结果
        System.out.println("排序后");
        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i]);
        }
    }        
}
class Person{
    private String name;
    private int age;
    private String job;

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }
}
