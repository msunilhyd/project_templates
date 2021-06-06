package com.dailydose.assignment2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// ArrayBlockingQueue in a producer consumer application

public class ProdConsMain {

	public static void main(String[] args) throws InterruptedException {
		
		BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
		
//		10 producers
		for (int i = 0; i < 10; i++) {
			Producer lister = new Producer(queue, i);
			if ((i % 3) == 0) {
				Thread.sleep(1000);	// Delaying producers for multiple of 3
			}
		    lister.start();
//			System.out.println("i is = " + i);
		}
		
//		1 consumer
		Consumer parser = new Consumer(queue);
		parser.start();
	}
	
}

