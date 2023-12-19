package com.hspedu.refection;

@Deprecated
public class Person extends A implements IA, IB {
    public String name;
    protected int age;
    String job;
    private double sal;

    public Person() {
    }

    public Person(String name) {
    }

    private Person(String name, int age) {
    }

    public void m1(String name, int age, double sal) {
    }

    protected void m2() {
    }

    void m3() {
    }

    private void m4() {
    }
}
