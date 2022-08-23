package com.w.generic;

import java.util.*;

/**
 * @author blue
 * @version 1.0
 */
public class GenericExercise01 {
    public static void main(String[] args) {
        HashSet<Student> students = new HashSet<>();
        students.add(new Student("q"));
        students.add(new Student("w"));
        students.add(new Student("e"));
        for (Student student : students) {
            System.out.println(student.getName());
        }
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student next = iterator.next();
            System.out.println(next.getName());
        }
        System.out.println("HashMap");
        HashMap<String, Student> students2 = new HashMap<>();
        students2.put("q", new Student("q"));
        students2.put("w", new Student("w"));
        students2.put("e", new Student("e"));
        for (Student value : students2.values()) {
            System.out.println(value.getName());
        }
        System.out.println("2");
        Set<Map.Entry<String, Student>> entries = students2.entrySet();
        Iterator<Map.Entry<String, Student>> iterator1 = entries.iterator();
        while (iterator1.hasNext()) {
            Map.Entry<String, Student> next = iterator1.next();
            Student student = next.getValue();
            System.out.println(student.getName());
        }
//        HashMap hashMap = new HashMap();
//        hashMap.put("q", new Student("q"));
//        hashMap.put("w", new Student("w"));
//        hashMap.put("e", new Student("e"));
//        Set set = hashMap.entrySet();
    }
}

class Student {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(String name) {
        this.name = name;
    }
}
