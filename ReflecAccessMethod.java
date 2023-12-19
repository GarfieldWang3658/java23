package com.hspedu.refection;

import java.lang.reflect.Method;

public class ReflecAccessMethod {
    public static void main(String[] args) throws Exception {
        Class<?> bossCls = Class.forName("com.hspedu.refection.Boss");
        Object o = bossCls.newInstance();
        //Method hi = bossCls.getMethod("hi"+String.class);

        Method hi1 = bossCls.getDeclaredMethod("hi",String.class);
        hi1.invoke(o,"nihao");


        Method say = bossCls.getDeclaredMethod("say", int.class, String.class, char.class);
        //sayメソッドはプライベートですので、爆破します
        say.setAccessible(true);
        System.out.println(say.invoke(o,100,"wangyang",'男'));

        //sayは静的メソッドですので、オブジェクトはnullを設定する事が可能です。

        System.out.println(say.invoke(null,5,"おうみど",'女'));

        //リフレクションでは、メソッドの戻り値のクラスはObjectになります。
        Object reVal = say.invoke(o, 31,"shenjiayan",'女');
        System.out.println(" "+reVal.getClass());



    }
}
class Boss{
    public int age;
    private static String name;

    public Boss() {//コンストラクタ
    }

    private static String say (int n,String s,char c){//静的メソッド
        return n+" "+s+" "+c;
    }

    public void hi(String s){
        System.out.println("hi\t"+s);
    }
}