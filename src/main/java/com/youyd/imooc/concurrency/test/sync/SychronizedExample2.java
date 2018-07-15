package com.youyd.imooc.concurrency.test.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SychronizedExample2 {
	
	//修饰代码块
	public static void test1(int j) {
		
		synchronized (SychronizedExample2.class) {
			for(int i=0;i<10;i++) {
				System.out.println("test1 "+j +"-"+ i);
			}
		}
	}
	
	//修饰一个方法
	
	public static synchronized void test2(int j) {
		for(int i=0;i<10;i++) {
			System.out.println("test2 "+j+"-" + i);
		}
	}
	
	public static void main(String[] args) {
		SychronizedExample2 exmaple1=new SychronizedExample2();
		SychronizedExample2 exmaple2=new SychronizedExample2();
		ExecutorService executorService=Executors.newCachedThreadPool();
		executorService.execute(()->{
			exmaple1.test1(1);
		});
		executorService.execute(()->{
			exmaple2.test1(2);
		});
	}
	

}
