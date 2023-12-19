package com.hspedu.refection.class_;

import com.hspedu.Car;

import java.lang.reflect.Field;

public class Class02 {
    public static void main(String[] args) throws Exception {
        String classfilePath ="com.hspedu.Car";

        //carクラスに相応なClassのオブジェクトを取得します

        Class<?> cls = Class.forName(classfilePath);
        System.out.println(cls);

        //Classのオブジェクトの実行クラスタイプを表現します

        System.out.println(cls.getClass());

        //パッケージの名前を取得します

        System.out.println(cls.getPackage().getName());

        //クラスの名前を取得します

        System.out.println(cls.getName());

        //反射で実例を取得します

        Car car =(Car)cls.newInstance();
        System.out.println(car);

        //反射でプロパティbrandを取得します

        Field brand = cls.getField("brand");
        System.out.println(brand.get(car));

        //反射でプロパティを設定します

        brand.set(car,"MAZDA2");
        System.out.println(brand.get(car));

        //全てのプロパティを走査します

        Field[] fields = cls.getFields();
        for (Field f :fields){
            System.out.println(f.getName());
        }

    }
}
