package com.dailydose.AnuDeep.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockWithSem {

	final static Lock lock1 = new ReentrantLock();
	final static Lock lock2 = new ReentrantLock();

	public static void main(String[] args) {
		Thread th1 = new Thread(new Runnable3());
		th1.setName("First Thread");
		th1.start();

		Thread th2 = new Thread(new Runnable4());
		th2.setName("Second Thread");
		th2.start();
	}

	static class Runnable3 implements Runnable {
		public void run() {
			DeadlockWithSem.lock1.lock();
			try {
				System.out.println(Thread.currentThread().getName() + ": acquired lock1. Trying to acquire lock2...");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				DeadlockWithSem.lock2.lock();
				try {
					System.out.println(Thread.currentThread().getName() + ": acquired lock2.");
				} finally {
					DeadlockWithSem.lock2.unlock();
				}
			} finally {
				DeadlockWithSem.lock1.lock();
			}
		}
	}

	static class Runnable4 implements Runnable {
		public void run() {
			DeadlockWithSem.lock2.lock();
			try {
				System.out.println(Thread.currentThread().getName() + ": acquired lock2. Trying to acquire lock1...");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				DeadlockWithSem.lock1.lock();
				try {
					System.out.println(Thread.currentThread().getName() + ": acquired lock1.");
				} finally {
					DeadlockWithSem.lock1.unlock();
				}
			} finally {
				DeadlockWithSem.lock2.unlock();
			}
		}
	}
}