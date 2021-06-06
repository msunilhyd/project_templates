package com.dailydose.assignment2;

import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread {

	private BlockingQueue<String> queue;
	
	public Consumer(BlockingQueue<String> queue) {
		this.queue = queue;
	}
	
	public void run() {
		while (true) {
			try {
				String str = queue.peek();
				
				if (str != null && !queue.isEmpty()) {
					str = queue.take();
					System.out.println(str);
				} else
					break;
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
}
