package com.hspedu.refection.question;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

public class Refletion01 {
    public static void main(String[] args) throws Exception {
        //Porpertiesクラスで配置ファイルを読み取ります
        Properties properties = new Properties();
        String filePath = "/Users/garfield/Documents/JavaE-Leanning/Chapter23/src/re.properties.properties/";
        properties.load(new FileInputStream(filePath));
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();
        System.out.println(classfullpath);
        System.out.println(methodName);

        //上記の方法はオブジェクトを新規することができません
        //反射の使用が必要になります。
        //クラスをロードします、クラスタイプの「cls」オブジェクトを戻ります。
        Class cls = Class.forName(classfullpath);

        //clsでcom.hspedu.catをロードします、オブジェクトを実例化にします
        Object o = cls.newInstance();
        System.out.println(o.getClass());
        //clsでロードされたcom.hspedu.CatのmethodNameのメソッドオブジェクトを取得しました。
        //反射では　メソッドをオブジェクトとして見ることが可能です、
        Method method1 = cls.getMethod(methodName);
        //method1でメソッドを執行する事、＝＞メソッドのオブジェクトでメソッドを執行する事
        method1.invoke(o);
        //今まで　オブジェクト.メソッド()
        //反射の場合には　メソッド.invoke(オブジェクト)

        //java.lang.reflect.Field ＝＞メンバーの変数を表ます、
        // Fieldオブジェクトはクラスメンバーの変数を表ます
        //getFieldはプライベートのプロバデイーをアクセスすることができません
        Field nameField = cls.getField("age");
        System.out.println(nameField.get(o));

        //java.lang.reflect.Constructor => クラスのコンストラクタを表ます
        Constructor constructor = cls.getConstructor();
        System.out.println(constructor);

        Constructor constructor1 = cls.getConstructor(String.class, int.class);
        System.out.println(constructor1);


    }
}
