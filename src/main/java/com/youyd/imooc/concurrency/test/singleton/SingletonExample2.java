package com.youyd.imooc.concurrency.test.singleton;

import com.youyd.imooc.concurrency.annotation.ThreadSafe;

/**
 * 饿汉模式
 */
@ThreadSafe
public class SingletonExample2 {

    //私有构造函数
    private SingletonExample2(){

    }

    //单例对象
    private static SingletonExample2 instance=new SingletonExample2();

    //静态的工厂的方法
    public static SingletonExample2 getInstance(){
        return instance;
    }

}
