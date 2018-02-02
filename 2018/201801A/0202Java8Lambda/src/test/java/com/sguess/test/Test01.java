package com.sguess.test;

import org.junit.Test;

public class Test01 {

	
	@Test
	public void test01() {
		Runnable r = () -> System.out.println("hello world");
		r.run();
	}
}
