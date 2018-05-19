package com.sguess.test02;

public class ISumTest {
	public static void main(String[] args) {
		ISum sumObj = (int a, int b) -> {
			return (a + b);
		};
		int rst = sumObj.sum(1, 2);
		System.out.println(rst);
	}
}

interface ISum {
	public int sum(int num1, int num2);
}
