package com.w.homework;

/**
 * @author blue
 * @version 1.0
 */
public class Homework04 {
    public static void main(String[] args) {
        A a = new A();
        a.f1();
        C c = new C();
        c.say();
        E e = new E();
        e.l();

    }
}

class A {

    private String NAME = "la";

    public void f1() {
        class B {
            private final String NAME = "啦啦啦";

            public void show() {
                System.out.println("NAME=" + NAME);
                System.out.println("A NAME=" + A.this.NAME);
            }
        }
        B b = new B();
        b.show();
    }

}

class C {

    public class D {
        private final String name = "123";

        public void hi() {
            System.out.println("name=" + name);
        }
    }

    public void say() {
        D d = new D();
        d.hi();
    }
}

class E {

    private static String name = "333";

    public static class F {
        private String name = "222";
        public void la(){
            System.out.println("F name=" + name + " E name=" + E.name);
        }
    }

    public void l(){
        F f = new F();
        f.la();

    }
}
