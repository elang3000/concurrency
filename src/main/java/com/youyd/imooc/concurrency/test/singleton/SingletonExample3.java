package com.youyd.imooc.concurrency.test.singleton;

import com.youyd.imooc.concurrency.annotation.NotRecommend;
import com.youyd.imooc.concurrency.annotation.NotThreadSafe;

/**
 * 懒汉模式
 */
@NotThreadSafe
@NotRecommend
public class SingletonExample3 {

    //私有构造函数
    private SingletonExample3(){

    }

    //单例对象
    private static SingletonExample3 instance=null;

    //静态的工厂的方法
    public static synchronized SingletonExample3 getInstance(){
        if(instance==null){
            instance=new SingletonExample3();
        }
        return instance;
    }

}
