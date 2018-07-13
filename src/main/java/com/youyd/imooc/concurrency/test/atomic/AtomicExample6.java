package com.youyd.imooc.concurrency.test.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

import com.youyd.imooc.concurrency.annotation.ThreadSafe;

@ThreadSafe
public class AtomicExample6 {
	
	//请求总数
	public static int clientTotal=5000;
	
	//同事并发执行线程数
	public static int threadTotal=200;
	
	private static AtomicBoolean isHappened=new AtomicBoolean(false);
	
	public static void main(String[] args) throws InterruptedException {

		ExecutorService executorService=Executors.newCachedThreadPool();
		final Semaphore semaphore=new Semaphore(threadTotal);
		final CountDownLatch countDownLatch=new CountDownLatch(clientTotal);
		for(int i=0;i<clientTotal;i++) {
			executorService.execute(()->{
				try {
					semaphore.acquire();
					test();
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
		System.out.println("ishappened:{"+isHappened.get()+"}");
	
	}
	
	private static void test() {
		if(isHappened.compareAndSet(false, true)) {
			System.out.println();
		}
	}
}
