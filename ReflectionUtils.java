package com.hspedu.refection;


import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtils {
    public static void main(String[] args) throws Exception {
        ReflectionUtils reflectionUtils = new ReflectionUtils();
        //reflectionUtils.api_01();
        reflectionUtils.api_02();
    }

    //API
    public void api_01() throws Exception {
        //1.Classオブジェクトを取得
        Class<?> personcls = Class.forName("com.hspedu.refection.Person");
        System.out.println(personcls);
        //2.クラス名を取得
        System.out.println(personcls.getName());
        //3.簡易クラス名を取得
        System.out.println(personcls.getSimpleName());
        //4.全てのpublicプロバテイーを取得
        Field[] fields = personcls.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
        //5.全てのプロバテイーを取得
        Field[] declaredFields = personcls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
        }
        //6.全てのpublicメソッドを取得,指定クラスとその親クラス
        Method[] methods = personcls.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        //7.全てのメソッドを取得
        Method[] declaredMethods = personcls.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
        }
        //8.全てのpublicコンストラクタを取得
        Constructor<?>[] constructors = personcls.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getName());
        }
        //9.全てのコンストラクタを取得
        Constructor<?>[] declaredConstructors = personcls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor.getName());
        }
        //10.Packageでパケージの情報を取得
        Package aPackage = personcls.getPackage();
        System.out.println(aPackage.getName());
        //11.Classで親クラスを取得
        Class<?> superclass = personcls.getSuperclass();
        System.out.println(superclass.getName());
        //12.Class配列でインターフェースを取得
        Class<?>[] interfaces = personcls.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }
        //13.Annotation配列でコメント情報を取得
        Annotation[] annotations = personcls.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotations);
        }


    }

    public void api_02() throws Exception {
        Class<?> personcls = Class.forName("com.hspedu.refection.Person");
        System.out.println(personcls);
//パーケージング
        Field[] declaredFields = personcls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName() + " " + declaredField.getModifiers() +
                    " " + declaredField.getType());
        }
//メソッド
        Method[] declaredMethods = personcls.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName() + " " + declaredMethod.getModifiers() + " "
                    + declaredMethod.getReturnType());
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println(parameterType.getName());
            }
        }
        //コンストラクタ

        Constructor<?>[] constructors = personcls.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("===========================");
           System.out.println(constructor.getName());
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println(parameterType);
            }
        }

    }
}

    class A {
        public String hobby;

        public void hi() {
        }

        public A() {
        }

        public A(String name) {
        }
    }

    interface IA {
    }

    interface IB {
    }

