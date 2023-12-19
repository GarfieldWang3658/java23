package com.hspedu.homework;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class HomeWork01 {
    public static void main(String[] args) throws Exception {
        Class<?> PTcls = Class.forName("com.hspedu.homework.PrivateTest");
        Object o = PTcls.newInstance();
        Field name = PTcls.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o,"WANGMIDUO");

        Method getName = PTcls.getMethod("getName");
        System.out.println(getName.invoke(o));

    }
}
class PrivateTest{
    private String name = "hellokitty";
    public String getName(){
        return name;
    }
}
