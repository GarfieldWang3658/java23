package com.hspedu.refection.class_;

import com.hspedu.Car;

public class GetClass {
    public static void main(String[] args) throws Exception {
        //1.Class.forName
        String classAllPath = "com.hspedu.Car";
        Class<?> cls1 = Class.forName(classAllPath);
        System.out.println(cls1);
        //2.クラス名.class  =>　変数の伝達に使用する
        Class cls2 = Car.class;
        System.out.println(cls2);
        //3.クラス名.getclass(),=＞オブジェクトの実例がすでに存在しています
        Car car = new Car();
        Class cls3 = car.getClass();
        System.out.println(cls3);
        //4.クラスをロード「４種類のロード方式」する事でクラスのClassのオブジェクトを取得します。
        //1.クラスロード
        ClassLoader classLoader = car.getClass().getClassLoader();
        //2.クラスロードでClassブジェクトを取得します。
        Class cls4 = classLoader.loadClass(classAllPath);
        System.out.println(cls4);

        //3.cls1 cls2 cls3 cls4 は同じオブジェクト
        System.out.println(cls1.hashCode());
        System.out.println(cls2.hashCode());
        System.out.println(cls3.hashCode());
        System.out.println(cls4.hashCode());

        //基本データ型は下記でClassオブジェクトを取得します。
        Class<Integer> integerClass = int.class;
        System.out.println(integerClass);

        //基本データ型のパーケージングクラスは「.TYPE」でClassオブジェクトを取得します。
        Class<Integer> type = Integer.TYPE;
        Class<Character> type1 = Character.TYPE;
        System.out.println(type);
        System.out.println(type1);


        //5.
        //6.
        //7.

    }
}
