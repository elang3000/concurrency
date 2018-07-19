package com.youyd.imooc.concurrency.test.commonunsafe;

import com.youyd.imooc.concurrency.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
@NotThreadSafe
public class HashSetExample {




    //请求总数
    public static int clientTotal=5000;

    //同事并发执行线程数
    public static int threadTotal=200;

    private static Set<Integer> set =new HashSet<>();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService=Executors.newCachedThreadPool();
        final Semaphore semaphore=new Semaphore(threadTotal);
        final CountDownLatch countDownLatch=new CountDownLatch(clientTotal);
        for(int i=0;i<clientTotal;i++) {
            final int count =i;
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    add(count);
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
        log.info("size:{}"+ set.size());
    }

    public static void add(int i) {
        set.add(i);

    }


}