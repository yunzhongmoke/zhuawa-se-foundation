package homework;

import java.util.Objects;

public class Teacher {
    private String name;
    private int age;
    private String post;
    private double salary;

    public void introduce(){
        System.out.println("name:" + name + " age:" + age + " post" + post + " salary" + salary);
    }

    public Teacher(String name, int age, String post, double salary) {
        this.name = name;
        this.age = age;
        this.post = post;
        this.salary = salary;
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

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public double getSalary(){
        return salary;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Teacher teacher = (Teacher) o;
        return age == teacher.age && Double.compare(teacher.salary, salary) == 0 && Objects.equals(name, teacher.name) && Objects.equals(post, teacher.post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, post, salary);
    }
}
