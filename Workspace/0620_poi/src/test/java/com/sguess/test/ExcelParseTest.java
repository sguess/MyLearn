package com.sguess.test;

import java.io.File;

import org.junit.Test;

public class ExcelParseTest {

	public static void main(String[] args) {

	}

	@Test
	public void test01() {
		File file = new File("C:\\tmp\\upload.xlsx");
		System.out.println(file.exists());
//		XSSFWorkbook book=new XSSFWorkbook ();
	}

}
