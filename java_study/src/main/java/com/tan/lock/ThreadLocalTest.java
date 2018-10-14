package com.tan.lock;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadLocalTest {
//	static ThreadLocal<String> tl = new ThreadLocal<String>();
	volatile static String tl = "";
	public static void main(String[] args) {
		new Thread(new Runnable(){
			@Override
			public void run() {
//				tl.set("Jack");
//				System.out.println(tl.get());
				tl = "Jack";
				System.out.println(tl);
			}
		}).start();
		new Thread(new Runnable(){
			@Override
			public void run() {
//				tl.set("Tom");
//				System.out.println(tl.get());
				tl = "Tom";
				System.out.println(tl);
			}
		}).start();
	}
}
