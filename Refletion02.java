package com.hspedu.refection.question;

import com.hspedu.Cat;

import java.lang.reflect.Method;

public class Refletion02 {
    public static void main(String[] args) throws Exception {
        m1();
        m2();
        m3();

    }
    //ノーマル
    public static void m1(){
        Cat cat = new Cat();
        long start = System.currentTimeMillis();

        for (int i = 0; i < 90000000; i++) {
            cat.hi();

        }
        long end= System.currentTimeMillis();
        System.out.println("m1 時間＝"+(end-start));
    }
    //反射
    public static void m2() throws Exception {
        Class aClass = Class.forName("com.hspedu.Cat");
        Object o = aClass.newInstance();
        Method hi = aClass.getMethod("hi");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 90000000; i++) {
            hi.invoke(o);//反射でメソッドを引き出します
        }
        long end= System.currentTimeMillis();
        System.out.println("m2 時間＝"+(end-start));
    }
    public static void m3() throws Exception {
        Class aClass = Class.forName("com.hspedu.Cat");
        Object o = aClass.newInstance();
        Method hi = aClass.getMethod("hi");
        hi.setAccessible(true);
        //反射でメソッドを引き出す時にアクセス検証をキャンセルする事で効率化（限定的な効果）を実現します。
        long start = System.currentTimeMillis();
        for (int i = 0; i < 90000000; i++) {
            hi.invoke(o);//反射でメソッドを引き出します
        }
        long end= System.currentTimeMillis();
        System.out.println("m3 時間＝"+(end-start));
    }
}


