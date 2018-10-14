package com.tan.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
	private static Lock lock = new ReentrantLock();
	public static void main(String[] args)  {
		
		new Thread(() -> run1()).start();
		new Thread(() -> run1()).start();
	}
	
	private static void run() {
		lock.lock();
		try {
			System.out.println(Thread.currentThread()+":lock");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	
	private static void run1() {
		boolean flag = false;
		try {
			flag = lock.tryLock(2, TimeUnit.SECONDS);
			if (flag) {
				System.out.println(Thread.currentThread()+":lock");
				Thread.sleep(2000);
			}
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			if (flag) {
				lock.unlock();
			}
		}		
	}
}
