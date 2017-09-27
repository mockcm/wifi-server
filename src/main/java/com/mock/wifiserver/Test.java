package com.mock.wifiserver;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Test {
	
	private static BlockingQueue<A> blockingQueue = new LinkedBlockingQueue<>();
	public static void main(String[] args) {
		
		Executors.newSingleThreadExecutor().execute(new Runnable() {
			
			@Override
			public void run() {
				try {
					A a = blockingQueue.poll(2, TimeUnit.SECONDS);
					System.out.println("获取到a:" + a);
				} catch (InterruptedException e) {e.printStackTrace();}
			}
		});
		
//		try {
//			TimeUnit.SECONDS.sleep(1);
//		} catch (InterruptedException e) {}
//		
		blockingQueue.offer(new A());
	}
}

class A {
	
}
