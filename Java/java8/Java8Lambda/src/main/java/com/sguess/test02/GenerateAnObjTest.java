package com.sguess.test02;

public class GenerateAnObjTest {

	public static void main(String[] args) {
		new Thread(generateARunnableObj()).start();
	}

	public static Runnable generateARunnableObj(){
		return () -> {
			System.out.println("later");
		};
	}
}
