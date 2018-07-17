package com.youyd.imooc.concurrency.test.singleton;

import com.youyd.imooc.concurrency.annotation.ThreadSafe;

/**
 * 懒汉模式
 */
@ThreadSafe
public class SingletonExample5 {

    //私有构造函数
    private SingletonExample5(){

    }
    //1,memory=allocate()
    //2,ctorInstance()
    //3,instance=memory 设置instance指向刚分配的内存

    //jvm和cpu优化，发生了指令重排序

    //1,memory=allocate()
    //3,instance=memory 设置instance指向刚分配的内存
    //2,ctorInstance()


    //单例对象 双重检测机制 -》禁止指令重排
    private static volatile SingletonExample5 instance=null;

    //静态的工厂的方法
    public static SingletonExample5 getInstance(){
        if(instance==null){ //双重检测机制
            synchronized (SingletonExample5.class){//同步锁
                if(instance==null) {
                    instance = new SingletonExample5();
                }
            }

        }
        return instance;
    }

}
