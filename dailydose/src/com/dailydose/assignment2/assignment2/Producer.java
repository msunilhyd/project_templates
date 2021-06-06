package com.dailydose.assignment2;

import java.util.concurrent.BlockingQueue;


public class Producer extends Thread{
	
	private BlockingQueue<String> queue;
	
	private int i;
	
	public Producer(BlockingQueue<String> queue, int i) {
		this.queue = queue;
		this.i = i;
	}
	
	public void run() {
		try {
			queue.put("Hello " + i);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}
}
