package com.sguess.sla;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadComments2 {
	public final static String CUSTOMERNAME_SOLUTIONID_SLAIMPACT_REGX="(.*?)#(\\d*)(#(.*))?";
	public final static String CUSTOMERNAME_SOLUTIONID_SLAIMPACT_REGX_01="(.*?)#(\\d*)(#(.*))?[0-9]$";
	public final static Pattern pattern = Pattern.compile(CUSTOMERNAME_SOLUTIONID_SLAIMPACT_REGX);
	public final static Pattern pattern1 = Pattern.compile(CUSTOMERNAME_SOLUTIONID_SLAIMPACT_REGX_01);

	public static void main(String[] args) throws Exception {
		 String regEx = "a\\d+(e)";  
         String s = "a000eedfsdffaaaa1";  
         Pattern pat = Pattern.compile(regEx);  
         Matcher mat = pat.matcher(s);  
         if(mat.find()){
        	 System.out.println(mat.group(0));
        	 System.out.println(mat.group(1));
        	 System.out.println(mat.group(2));
         }

	}


}
