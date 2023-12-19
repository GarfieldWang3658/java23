package com.hspedu.refection.class_;

import java.io.Serializable;

public class AllTypeClass {
    public static void main(String[] args) {
        Class<String> cls1 = String.class;//外部クラス
        Class<Serializable> cls2 = Serializable.class;//インターフェース
        Class<Integer[]> cls3 = Integer[].class;//配列
        Class<float[][]> cls4 = float[][].class;//二次元配列
        Class<Deprecated> cls5 = Deprecated.class;//コメント
        Class<Thread.State> cls6 = Thread.State.class;//列挙型
        Class<Long> cls7 = long.class;//基本データー型
        Class<Void> cls8 = void.class;//void型
        Class<Class> cls9 = Class.class;

        System.out.println(cls1);
        System.out.println(cls2);
        System.out.println(cls3);
        System.out.println(cls4);
        System.out.println(cls5);
        System.out.println(cls6);
        System.out.println(cls7);
        System.out.println(cls8);
        System.out.println(cls9);
    }
}
