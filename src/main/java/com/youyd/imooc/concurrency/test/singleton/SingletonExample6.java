package com.youyd.imooc.concurrency.test.singleton;

import com.youyd.imooc.concurrency.annotation.ThreadSafe;

/**
 * 饿汉模式
 */
@ThreadSafe
public class SingletonExample6 {

    //单例对象
    private static SingletonExample6 instance=null;

    static{
        instance=new SingletonExample6();
    }

    //私有构造函数
    private SingletonExample6(){

    }

    //静态的工厂的方法
    public static SingletonExample6 getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(instance.hashCode());
        System.out.println(instance.hashCode());

    }

}
