package com.sguess;

import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadsSampleExecutor {

	ThreadPoolExecutor threadPool;
	private int corePoolSize = 2;
	private int maximumPoolSize = 100;

	public void init() {
		threadPool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, 1, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>());
		System.out.print(threadPool.allowsCoreThreadTimeOut());
		threadPool.allowCoreThreadTimeOut(true);
	}

	public void execute() throws InterruptedException {
		for (int i = 0; i < 1000; i++) {
//			 waitForNextStep();
			Runnable sample = new ThreadsSample(i);
			Future<ThreadsSample> thread = (Future<ThreadsSample>) threadPool.submit(sample);
			System.out.println("Add " + i + "Finsihed");
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
		ThreadsSampleExecutor executor = new ThreadsSampleExecutor();
		executor.init();
		executor.execute();
	}
}

class ThreadsSample implements Runnable {
	int countNum = 0;

	public ThreadsSample(int countNum) {
		super();
		this.countNum = countNum;
	}

	@Override
	public void run() {
		System.out.println("Start " + countNum + ": " + Thread.currentThread().getName());
		try {
			Thread.sleep(3 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.err.println("Stop " + countNum + ": " + Thread.currentThread().getName());
	}

}
