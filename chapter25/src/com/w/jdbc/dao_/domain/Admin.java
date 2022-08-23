package com.w.jdbc.dao_.domain;

/**
 * @author blue
 * @version 1.0
 */
public class Admin {

    private String name;
    private String password;

    public Admin(){

    }

    public Admin(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "\nAdmin{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
