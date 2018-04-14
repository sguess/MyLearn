package com.sguess;

import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadsSampleExecutor2 {

	ThreadPoolExecutor threadPool;
	private int corePoolSize = 2;
	private int maximumPoolSize = 10;

	public void init() {
		threadPool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, 1, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>());
		System.out.print(threadPool.allowsCoreThreadTimeOut());
		threadPool.allowCoreThreadTimeOut(true);
	}

	public void execute() throws InterruptedException {
		for (int i = 0; i < 1000; i++) {
			// waitForNextStep();
			Runnable sample = new ThreadsSample2(i);
			Future<ThreadsSample2> thread = (Future<ThreadsSample2>) threadPool.submit(sample);
			System.out.println("Add " + i + " Finsihed!");
		}
	}

	public int getQueueSize() {
		int size = threadPool.getQueue().size();
		return size;
	}

	private void waitForNextStep() throws InterruptedException {
		while (true) {
			Thread.sleep(1 * 100);
			if (getQueueSize() < maximumPoolSize) {
				break;
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ThreadsSampleExecutor2 executor = new ThreadsSampleExecutor2();
		executor.init();
		executor.execute();
	}
}

class ThreadsSample2 implements Runnable {
	int countNum = 0;

	public ThreadsSample2(int countNum) {
		super();
		this.countNum = countNum;
	}

	@Override
	public void run() {
		System.out.println("Start " + countNum + ": " + Thread.currentThread().getName());
		try {
			Thread.sleep(1 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.err.println("Stop " + countNum + ": " + Thread.currentThread().getName());
	}

}
