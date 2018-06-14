package com.sguess.bakup;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecotorTest {

	public static void main(String[] args) {
		int corePoolSize = 2;
		int maximumPoolSize = 2;
		long keepAliveTime = 30L;
		TimeUnit unit = TimeUnit.SECONDS;
		BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue();
		// TODO Auto-generated method stub
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime,
				unit, workQueue);
		Runnable task = () -> System.out.println("Hello");
		threadPoolExecutor.submit(task);
		Future<Runnable> future;
		
	}

}
