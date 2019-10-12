package jianzhioffer;

/**
 * 二、单例模式
 * 0、单例模式的三个关键点
 * （1）由类保存唯一实例：static
 * （2）构造方法私有化：privet
 * （3）向外提供一个可以获得唯一实例的方法
 * （4）线程安全问题，懒汉式、饿汉式
 */

//1、线程不安全版
class Singleton1{
    private static Singleton1 instance=null;
    private Singleton1(){};
    public static Singleton1 getInstance(){
        if (instance==null){
            instance=new Singleton1();
        }
        return instance;
    }
}

//2、饿汉式：final、类加载特性
class Singleton2{
    private Singleton2(){}
    private static final Singleton2 instance=new Singleton2();
    public static Singleton2 getInstance(){
        return instance;
    }
}

//3、懒汉式
//3.1 同步方法，推荐指数：*
class Singleton3{
    private Singleton3(){}
    private static Singleton3 instance=null;
    public static synchronized Singleton3 getInstance(){
        if (instance==null)
            instance=new Singleton3();
        return instance;
    }
}

//3.2 双重锁定，推荐指数：**
class Singleton4{
    private Singleton4(){}
    private static volatile Singleton4 instance=null;
    public static Singleton4 getInstance(){
        if (instance==null){
            synchronized (Singleton4.class){
                if (instance==null){
                    instance=new Singleton4();
                }
            }
        }
        return instance;
    }
}

//3.3 静态内部类，推荐指数：***
class Singleton5{
    private Singleton5(){}
    private static class LazyHolder{
        private static final Singleton5 instance=new Singleton5();
    }
    public static Singleton5 getInstance(){
        return LazyHolder.instance;
    }
}

//4、枚举
enum Singleton6{
    INSTANCE;
    public Singleton6 getInstance(){
        return INSTANCE;
    }
}

public class Solution2 {
}
