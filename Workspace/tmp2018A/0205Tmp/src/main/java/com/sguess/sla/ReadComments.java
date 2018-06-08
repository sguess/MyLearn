package com.sguess.sla;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadComments {
	public final static String CUSTOMERNAME_SOLUTIONID_SLAIMPACT_REGX="(.*?)#(\\d*)(#(.*))?";
	public final static String CUSTOMERNAME_SOLUTIONID_SLAIMPACT_REGX_01="(.*?)#(\\d*)(#(.*))?[0-9]$";
	public final static Pattern pattern = Pattern.compile(CUSTOMERNAME_SOLUTIONID_SLAIMPACT_REGX);
	public final static Pattern pattern1 = Pattern.compile(CUSTOMERNAME_SOLUTIONID_SLAIMPACT_REGX_01);

	public static void main(String[] args) throws Exception {
//		testFile();
		testStr("abc#123#aa#bc#123a#a");
		testStr("a#abc#123#1");

	}

	private static void testFile() throws IOException {
		String content=readFile("2.txt");
		System.out.println(content);
		
		String[] strs=content.split(";;");
		for(String str:strs) {
			testStr(str);
		}
	}

	private static void testStr(String str) {
		boolean match = pattern.matcher(str).find();
		boolean match1 = pattern1.matcher(str).find();
		
		boolean matchA = pattern.matcher(str).matches();
		boolean matchA1 = pattern1.matcher(str).matches();
		System.out.println(match+",\t"+match1+"\t:\t"+matchA+",\t"+matchA1+"\t"+str);
		if(matchA!=matchA1) {
			System.err.println("--------------->"+str);
		}
	}

	private static String readFile(String filePath) throws IOException {
		File file =new File(filePath);
		System.out.println(file.exists());
		BufferedReader reader=new BufferedReader(new FileReader(file));
		StringBuffer rstBf=new StringBuffer();
		String tmpStr="";
		while((tmpStr=reader.readLine())!=null) {
			rstBf.append(tmpStr);
		}
		return rstBf.toString();
	}

}
