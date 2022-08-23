package com.w.homework;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author blue
 * @version 1.0
 */
public class Homework01 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new New("123456789012345"));
        list.add(new New("1234567890123456"));
//        Collections.reverse(list);
//        System.out.println(list);
        for (int i = list.size() - 1; i >= 0; i--) {
            New NEW = (New) list.get(i);
            System.out.println(detail(NEW.getTitle()));
        }
    }

    public static String detail(String title) {
        if (title == null){
            return "";
        }
        if (title.length() > 15) {
            return title.substring(0, 15) + "..."; //[0, 15)
        }

        return title;
    }
}

class New {
    private String title;
    private String content;

    public New(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

//    public static String detail(String title) {
//        if (title.length() > 15) {
//            return title.substring(0, 15) + "..."; //[0, 15)
//        }
//
//        return title;
//    }

//    @Override
//    public String toString() {
//        return detail(title);
//    }

    @Override
    public String toString() {
        return "New{" +
                "title='" + title + '\'' +
                '}';
    }
}
