package com.hspedu.refection;

import java.lang.reflect.Field;

public class ReflecAccessProperty {
    public static void main(String[] args) throws Exception {
        Class<?> studentcls = Class.forName("com.hspedu.refection.Student");
        System.out.println(studentcls);
        Object o = studentcls.newInstance();//oの執行クラスはStudent
        System.out.println(o.getClass());

        Field age = studentcls.getDeclaredField("age");
        age.set(o,88);
        System.out.println(o);
        System.out.println(age.get(o));

        Field name = studentcls.getDeclaredField("name");
        name.setAccessible(true);
        //name.set(o,"WANGMIDUO");
        name.set(null,"WANGMIDUO");

        System.out.println(name.get(o));//プロバテイーの値を取得
        System.out.println(name.get(null));//プロバテイーの値を取得,nameは静的（static）であること
        System.out.println(o);


    }
}
class Student{
    public int age;
    private static String name;

    public Student() {}

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +"name="+name+
                '}';
    }
}

