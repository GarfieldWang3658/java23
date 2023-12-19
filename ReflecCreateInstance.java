package com.hspedu.refection;

import java.lang.reflect.Constructor;

public class ReflecCreateInstance {
    public static void main(String[] args) throws Exception {
        //1.UserクラスのClassオブジェクトを取得します。
        Class<?> usercls = Class.forName("com.hspedu.refection.User");

        //2.public の引数なしコンストラクタで実例を新規します
        Object o = usercls.newInstance();
        System.out.println(o);

        //3.publicの引数ありコンスタトラクタで実例を新規します
        /*
        constructorはオブジェクト
            public User(String name) {//引数ありコンストラクタ
        this.name = name;
    }
         */
        //先にコンストラクタを取得してから、実例を新規します、同時に引数を送信します。
        Constructor<?> constructor = usercls.getConstructor(String.class);
        Object WY = constructor.newInstance("WY");
        System.out.println(WY);

        //4.非publicの引数ありコンストラクタで実例を新規します
        //先にコンストラクタを取得してから、実例を新規します、同時に引数を送信します。
        Constructor<?> constructor1 = usercls.getDeclaredConstructor(int.class , String.class);
        //爆破→強制解析
        constructor1.setAccessible(true);//爆破→反射でプライベートのコンストラクタをアクセスすることができます。
        Object wang_miduo = constructor1.newInstance(5, "wang miduo");
        System.out.println(wang_miduo);

    }
}
class User {
    private int age = 4 ;
    private String name = "wangyang";
    public User(){}//引数なしコンストラクタ

    public User(String name) {
        this.name = name;
    }

    private User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
