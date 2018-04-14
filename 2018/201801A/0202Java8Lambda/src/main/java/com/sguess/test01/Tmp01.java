package com.sguess.test01;

public class Tmp01 {

	public static void main(String[] args) {
		Runnable noArguments = () -> System.out.println("Hello World");
		new Thread(noArguments).start();

	}

}
