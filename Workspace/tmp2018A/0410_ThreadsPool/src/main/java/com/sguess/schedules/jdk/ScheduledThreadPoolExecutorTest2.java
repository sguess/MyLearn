package com.sguess.schedules.jdk;

import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorTest2 {
	static int i=0;
	static int j=0;
	public static void main(String[] args) {
		ScheduledThreadPoolExecutor schedulers = new ScheduledThreadPoolExecutor(20);
//		int i=0;
//		int j=0;
		long initialDelay = 1;
		long period = 1;
		TimeUnit unit = TimeUnit.SECONDS;
		schedulers.scheduleAtFixedRate(() ->{
			System.out.println("1-->"+(i++)+new Date().toString());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, initialDelay, period, unit);
		
		long delay=1;
//		schedulers.scheduleWithFixedDelay(() ->{
//			System.out.println("2-->"+(j++)+new Date().toString());
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}, initialDelay, delay, unit);
	}
/**
 *
1-->0Thu Jun 14 15:08:37 CST 2018
1-->1Thu Jun 14 15:08:38 CST 2018
1-->2Thu Jun 14 15:08:39 CST 2018
1-->3Thu Jun 14 15:08:40 CST 2018
1-->4Thu Jun 14 15:08:41 CST 2018
1-->5Thu Jun 14 15:08:42 CST 2018
1-->6Thu Jun 14 15:08:43 CST 2018
1-->7Thu Jun 14 15:08:44 CST 2018
1-->8Thu Jun 14 15:08:45 CST 2018
1-->9Thu Jun 14 15:08:46 CST 2018
1-->10Thu Jun 14 15:08:47 CST 2018
1-->11Thu Jun 14 15:08:48 CST 2018
1-->12Thu Jun 14 15:08:49 CST 2018
---------------------------------------------
2-->0Thu Jun 14 15:07:13 CST 2018
2-->1Thu Jun 14 15:07:15 CST 2018
2-->2Thu Jun 14 15:07:17 CST 2018
2-->3Thu Jun 14 15:07:19 CST 2018
2-->4Thu Jun 14 15:07:21 CST 2018
2-->5Thu Jun 14 15:07:23 CST 2018
2-->6Thu Jun 14 15:07:25 CST 2018
2-->7Thu Jun 14 15:07:27 CST 2018
2-->8Thu Jun 14 15:07:29 CST 2018
2-->9Thu Jun 14 15:07:31 CST 2018
2-->10Thu Jun 14 15:07:33 CST 2018
2-->11Thu Jun 14 15:07:35 CST 2018
2-->12Thu Jun 14 15:07:37 CST 2018
2-->13Thu Jun 14 15:07:39 CST 2018
 */
}
