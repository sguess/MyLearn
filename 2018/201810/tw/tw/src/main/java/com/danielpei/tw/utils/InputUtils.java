package com.danielpei.tw.utils;

import java.util.regex.Pattern;

public class InputUtils {
    public static boolean isCorrectFormat(String str) {
        if (str == null || str.isEmpty() || str.trim().isEmpty()) {
            return false;
        }
        str=str.trim();
//        String regEx = "[a-zA-Z ]+ ([1-9]+[0-9]*min$||lightning$)";
        String regEx = "^\\w[ \\w\\(\\)\\.\\-\\:]* ([1-9]+[0-9]*min$||lightning$)";

        return Pattern.compile(regEx).matcher(str).matches();
    }
}
