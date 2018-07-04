package com.sguess.sla;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.deser.DataFormatReaders.Match;

public class ReadComments3 {
    static String str = "05/24/2018";
    public final static String Time_REGX = "\\d{2}/\\d{2}/\\d{4}";
    public final static Pattern pattern = Pattern.compile(Time_REGX);

    public static void main(String[] args) throws Exception {
        Matcher matcher = pattern.matcher(str);
        System.out.println(matcher.find());
        System.out.println(matcher.matches());


    }


}
