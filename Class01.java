package com.hspedu.refection.class_;

import com.hspedu.Cat;

public class Class01 {
    public static void main(String[] args) throws ClassNotFoundException {
        //1.ClassクラスはObjectを継承しています
        //2.Classクラスはnewで新規されたのではなく、システムで新規された者です
        //
        //
        //従来 new オブジェクト
        //Cat cat = new Cat  ();
        //反射方式
        /*
        ClassLoaderクラスでCatクラスのClassオブジェクトをロードします。
            public Class<?> loadClass(String name) throws ClassNotFoundException {
        return loadClass(name, false);
         */
        Class cls1 = Class.forName("com.hspedu.Cat");
        //3.Classオブジェクトはメモリーの中には一つしかありません、
        //その原因はクラスは一回しかロードする事ができません。
        Class cls2 = Class.forName("com.hspedu.Cat");
        System.out.println(cls1.hashCode());
        System.out.println(cls2.hashCode());

    }
}
