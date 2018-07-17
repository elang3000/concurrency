package com.youyd.imooc.concurrency.test.singleton;

import com.youyd.imooc.concurrency.annotation.Recommend;
import com.youyd.imooc.concurrency.annotation.ThreadSafe;

/**
 * 饿汉模式
 */
@ThreadSafe
@Recommend
public class SingletonExample7 {

    //私有构造函数
    private SingletonExample7(){

    }

    public static SingletonExample7 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton{
        INSTANCE;

        private  SingletonExample7 singleton;

        //jvm保证这个方法只能调用一次
        Singleton(){
            singleton=new SingletonExample7();
        }

        public SingletonExample7 getInstance(){
            return singleton;
        }
    }

}
