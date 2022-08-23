package com.w.set_;

import java.util.HashSet;
import java.util.Objects;
import java.util.TreeSet;

/**
 * @author blue
 * @version 1.0
 */
public class HashSet_ {
    public static void main(String[] args) {
        //HashSet hashSet = new HashSet();
//        hashSet.add("java");
//        hashSet.add("q");
//        hashSet.add("java");
//        for (int i = 0; i < 15; i++) {
//            hashSet.add(new A(i));
//        }
        HashSet treeSet = new HashSet();
        treeSet.add("q");
        treeSet.add("w");
        treeSet.add("w");
        treeSet.remove("q");
    }
}
class A{
    private int n;

    public A(int n) {
        this.n = n;
    }

    @Override
    public int hashCode() {
        return 1001;
    }
}