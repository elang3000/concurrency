package com.youyd.imooc.concurrency.test.commonunsafe;

import com.youyd.imooc.concurrency.annotation.ThreadSafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@ThreadSafe
public class StringExample2 {



    //请求总数
    public static int clientTotal=5000;

    //同事并发执行线程数
    public static int threadTotal=200;

    public static StringBuffer stringBuffer=new StringBuffer();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService=Executors.newCachedThreadPool();
        final Semaphore semaphore=new Semaphore(threadTotal);
        final CountDownLatch countDownLatch=new CountDownLatch(clientTotal);
        for(int i=0;i<clientTotal;i++) {
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    update();
//					System.out.println(count);
                    semaphore.release();
                } catch (Exception e) {
                    System.out.println(e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println("stringbuilder:"+stringBuffer.length());
    }

    public static void update() {
        stringBuffer.append("1");
    }
}
