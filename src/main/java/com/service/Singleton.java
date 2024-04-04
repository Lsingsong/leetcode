package com.service;


public class Singleton {
    public static Singleton singleton = null;

    public static Singleton singleton1 = new Singleton() ;

    public static volatile Singleton singleton2;

    //懒汉式（线程不安全）
    public static Singleton getSingleton() {
        if (null == singleton) {
            singleton = new Singleton();
        }
        return singleton;
    }

    //懒汉式（线程安全）
    public synchronized static Singleton getSingleton1() {
        if (null == singleton) {
            singleton = new Singleton();
        }
        return singleton;
    }

    public Singleton() { }


    //饿汉式
    public static Singleton getInstance() {
        return singleton1;
    }


    //双检锁
    public static Singleton getInstance2() {
        if (null == singleton2) {
            synchronized (Singleton.class) {
                if (null == singleton2) {
                    singleton2 = new Singleton();
                }
            }
        }
        return singleton2;
    }

    //静态内部类
    private static class SingletonHolder {
        private static final Singleton instance = new Singleton();
    }

    public static Singleton getInstance3() {
        return SingletonHolder.instance;
    }


}
