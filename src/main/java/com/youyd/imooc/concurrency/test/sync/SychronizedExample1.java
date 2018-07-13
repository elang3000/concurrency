package com.youyd.imooc.concurrency.test.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SychronizedExample1 {
	
	//修饰代码块
	public void test1(int j) {
		
		synchronized (this) {
			for(int i=0;i<10;i++) {
				System.out.println("test1 "+j +"-"+ i);
			}
		}
	}
	
	//修饰一个方法
	
	public synchronized void test2(int j) {
		for(int i=0;i<10;i++) {
			System.out.println("test2 "+j+"-" + i);
		}
	}
	
	public static void main(String[] args) {
		SychronizedExample1 exmaple1=new SychronizedExample1();
		SychronizedExample1 exmaple2=new SychronizedExample1();
		ExecutorService executorService=Executors.newCachedThreadPool();
		executorService.execute(()->{
			exmaple1.test2(1);
		});
		executorService.execute(()->{
			exmaple2.test2(2);
		});
	}
	

}
