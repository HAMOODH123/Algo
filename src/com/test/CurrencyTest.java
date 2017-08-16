package com.test;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class CurrencyTest {
	private static final AtomicInteger count = new AtomicInteger(0);
	private static  HashMap<Integer, Integer> map = new HashMap<>(1);

	public static void main(String[] args) {
//		Thread t = new Thread(new Runnable(){
//			public void run() {
//				while(count.get() < 100000) {
//					map.put(count.get(), count.get());
//					count.incrementAndGet();
//				}
//				System.out.println(Thread.currentThread().getName() + "即将结束!");
//			}
//		});
		
		//ExecutorService executor = Executors.newFixedThreadPool(10);
		Test t1 = new Test();
		Test t2 = new Test();
		Test t3 = new Test();
		Test t4 = new Test();
		Test t5 = new Test();
		Test t6 = new Test();
		Test t7 = new Test();
		Test t8 = new Test();
		Test t9 = new Test();
		Test t10 = new Test();
		Test t13 = new Test();
		Test t14 = new Test();
		Test t15 = new Test();
		
		Thread th1 = new Thread(t1);
		Thread th2 = new Thread(t2);
		Thread th3 = new Thread(t3);
		Thread th4 = new Thread(t4);
		Thread th5 = new Thread(t5);
		Thread th6 = new Thread(t6);
		Thread th7 = new Thread(t7);
		Thread th8 = new Thread(t8);
		Thread th9 = new Thread(t9);
		Thread th10 = new Thread(t10);
		Thread th13 = new Thread(t13);
		Thread th14 = new Thread(t14);
		Thread th15 = new Thread(t15);
		
		th1.start();
		th2.start();
		th3.start();
		th4.start();
		th5.start();
		th6.start();
		th7.start();
		th8.start();
		th9.start();
		th10.start();
		th13.start();
		th14.start();
		th15.start();
	}
	
	static class Test implements Runnable {
		public void run() {
			while(count.get() < 3000000) {
				map.put(count.get(), count.get());
				count.incrementAndGet();
			}
			System.out.println(Thread.currentThread().getName() + "即将结束!");
		}
	}
}
