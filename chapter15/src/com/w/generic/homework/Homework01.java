package com.w.generic.homework;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author blue
 * @version 1.0
 */
public class Homework01 {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<Object>();
    }

    @Test
    public void test() {
        DAO<User> userDAO = new DAO<>();
        userDAO.save("001", new User(1, 1, "q"));
        userDAO.save("002", new User(2, 1, "w"));
        userDAO.save("003", new User(3, 1, "e"));
        List<User> list = userDAO.list();
        System.out.println(list);

        userDAO.update("001", new User(2, 2, "r"));
        userDAO.delete("002");

        list = userDAO.list();
        System.out.println(list);

        System.out.println(userDAO.get("001"));
    }
}

class DAO<T> {
    private Map<String, T> map = new HashMap<>();

    public void save(String id, T entity) {
        map.put(id, entity);
    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
//        Set<String> strings = map.keySet();
//        for (String string : strings) {
//            if (string == id) {
//                map.replace(id, entity);
//            }
//        }
        map.put(id, entity);
    }

    public List<T> list() {
        Collection<T> values = map.values();
        List<T> list = new ArrayList<>();
        for (T value : values) {
            list.add(value);
        }
        return list;
    }

    public void delete(String id) {
        map.remove(id);
    }
}

class User {
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
