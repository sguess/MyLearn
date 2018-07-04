package com.sguess;

import java.io.File;
import java.util.Properties;

public class Tmp {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Properties props = System.getProperties();

        for (Object key : props.keySet()) {
            System.out.println(key.toString() + ":          " + props.get(key));
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        String pathname = new File("").getAbsolutePath() + "\\target\\classes\\abc.json";
        System.out.println(pathname);
        File file = new File(pathname);

        System.out.println(file.exists());
        System.out.println(file.getAbsolutePath());

    }

}
