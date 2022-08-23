package com.w.jdbc.dao_.domain;

import java.util.Date;

/**
 * @author blue
 * @version 1.0
 */
public class Test {

    private Integer id;
    private Date date;

    public Test() {
    }

    public Test(Integer id, Date date) {
        this.id = id;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", date=" + date +
                '}';
    }
}
