package com.hspedu.homework;

import com.hspedu.refection.Person;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class HomeWork2 {
    public static void main(String[] args) throws Exception {
        Class<?> personCls = Class.forName("java.io.File");
        Constructor<?>[] declaredConstructors = personCls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
        Constructor<?> declaredConstructor = personCls.getDeclaredConstructor(String.class);
        String filePath = "Users.garfield.aabbcc.txt";

        Object file = declaredConstructor.newInstance(filePath);
        Method createNewFile = personCls.getMethod("createNewFile");
        createNewFile.invoke(file);

        System.out.println(file.getClass());
        System.out.println("ファイル新規完成"+filePath);

    }
}

