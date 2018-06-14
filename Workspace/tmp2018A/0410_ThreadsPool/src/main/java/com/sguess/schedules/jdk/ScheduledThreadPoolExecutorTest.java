package com.sguess.schedules.jdk;

import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorTest {

	public static void main(String[] args) {
		new ScheduledThreadPoolExecutorTest().test();
	}

	private void test() {
		test_corePoolSize_is_10_and_AtFixedRate();
//		 test_corePoolSize_is_1_and_AtFixedRate();
//		 test_corePoolSize_is_10_and_WithFixedDelay();
//		 test_corePoolSize_is_1_and_WithFixedDelay

	}

	/**
	 * Thread-->Thu Jun 14 15:22:23 CST 2018 
	 * Thread-->Thu Jun 14 15:22:24 CST 2018
	 * Thread-->Thu Jun 14 15:22:25 CST 2018
	 * Thread-->Thu Jun 14 15:22:26 CST 2018
	 * Thread-->Thu Jun 14 15:22:27 CST 2018
	 * Thread-->Thu Jun 14 15:22:28 CST 2018
	 * Thread-->Thu Jun 14 15:22:29 CST 2018 
	 * Thread-->Thu Jun 14 15:22:30 CST 2018
	 * 时间是连续的
	 */
	public void test_corePoolSize_is_10_and_AtFixedRate() {
		int corePoolSize = 10;
		ScheduledThreadPoolExecutor schedulers = new ScheduledThreadPoolExecutor(corePoolSize);
		long initialDelay = 1;
		long period = 1;
		TimeUnit unit = TimeUnit.SECONDS;
		schedulers.scheduleAtFixedRate(() -> {
			System.out.println("Thread-->" + new Date().toString()+this.hashCode());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, initialDelay, period, unit);
	}
/**
 * 
Thread-->Thu Jun 14 15:23:37 CST 2018
Thread-->Thu Jun 14 15:23:38 CST 2018
Thread-->Thu Jun 14 15:23:39 CST 2018
Thread-->Thu Jun 14 15:23:40 CST 2018
Thread-->Thu Jun 14 15:23:41 CST 2018
Thread-->Thu Jun 14 15:23:42 CST 2018
Thread-->Thu Jun 14 15:23:43 CST 2018
Thread-->Thu Jun 14 15:23:44 CST 2018
时间依然是连续的. 
 */
	public void test_corePoolSize_is_1_and_AtFixedRate() {
		int corePoolSize = 1;
		ScheduledThreadPoolExecutor schedulers = new ScheduledThreadPoolExecutor(corePoolSize);
		Runnable command = () -> {
			System.out.println("Thread-->" + new Date().toString());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		long initialDelay = 1;
		long period = 1;
		TimeUnit unit = TimeUnit.SECONDS;
		schedulers.scheduleAtFixedRate(command, initialDelay, period, unit);
		long delay = 1;
		// schedulers.scheduleWithFixedDelay(command, initialDelay, delay, unit);
	}
/**
 *
Thread-->Thu Jun 14 15:24:43 CST 2018
Thread-->Thu Jun 14 15:24:45 CST 2018
Thread-->Thu Jun 14 15:24:47 CST 2018
Thread-->Thu Jun 14 15:24:49 CST 2018
Thread-->Thu Jun 14 15:24:51 CST 2018
Thread-->Thu Jun 14 15:24:53 CST 2018
时间相隔2秒, 才会进行下一个
 */
	public void test_corePoolSize_is_10_and_WithFixedDelay() {
		int corePoolSize = 10;
		ScheduledThreadPoolExecutor schedulers = new ScheduledThreadPoolExecutor(corePoolSize);
		Runnable command = () -> {
			System.out.println("Thread-->" + new Date().toString());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		long initialDelay = 1;
		long period = 1;
		TimeUnit unit = TimeUnit.SECONDS;
		// schedulers.scheduleAtFixedRate(command, initialDelay, period, unit);
		long delay = 1;
		schedulers.scheduleWithFixedDelay(command, initialDelay, delay, unit);
	}
	public void test_corePoolSize_is_1_and_WithFixedDelay() {
		int corePoolSize = 1;
		ScheduledThreadPoolExecutor schedulers = new ScheduledThreadPoolExecutor(corePoolSize);
		Runnable command = () -> {
			System.out.println("Thread-->" + new Date().toString());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		long initialDelay = 1;
		long period = 1;
		TimeUnit unit = TimeUnit.SECONDS;
		// schedulers.scheduleAtFixedRate(command, initialDelay, period, unit);
		long delay = 1;
		schedulers.scheduleWithFixedDelay(command, initialDelay, delay, unit);
	}
}
