package com.tan.lock;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProductorConsumerTest {
	private List<String> container = new LinkedList<String>();
	private Integer MAX = 10;
	private Lock lock = new ReentrantLock();
	private Condition productor = lock.newCondition();
	private Condition customer = lock.newCondition();

	private void put(String x) {

		try {
			lock.lock();
			System.out.println("p");
			while (container.size() == MAX) {
				productor.await();
			}
			container.add(x);
			customer.signalAll();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	private String get() {
		String x = null;
		try {
			lock.lock();
			System.out.println("c");
			while (container.size() == 0) {
				customer.await();
			}
			x = container.get(0);
			container.remove(x);
			productor.signalAll();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return x;
	}

	public static void main(String[] args) {
		ProductorConsumerTest pc = new ProductorConsumerTest();
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				public void run() {
					pc.put(new String("abc"));
				}
			}).start();
		}

		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				public void run() {
					pc.get();
				}
			}).start();
		}

		// pc.put(new String("abc"));
		// pc.put(new String("ab"));
		// System.out.println(pc.get());
		// System.out.println(pc.get());

	}
}
