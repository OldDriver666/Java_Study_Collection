package com.tan.lock;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TicketTest {
	private static Queue<String> tickets = new ConcurrentLinkedQueue<String>();
	static {
		for (int i = 0; i < 10; i++) {
			tickets.add("ticket" + i);
		}
	}

	public static void main(String[] args) {
		new Thread(() -> {
			while (true) {
				String s = tickets.poll();
				if (s != null) {
					System.out.println(Thread.currentThread() + "卖出:" + s);
				} else {
					break;
				}
			}
		}).start();
		new Thread(() -> {
			while (true) {
				String s = tickets.poll();
				if (s != null) {
					System.out.println(Thread.currentThread() + "卖出:" + s);
				} else {
					break;
				}
			}
		}).start();
	}
}
