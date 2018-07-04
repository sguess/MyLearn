package com.sguess;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.*;

public class Test02 {
    public static void main(String[] args) throws IOException {
//        downloadFile();
        getWebContent();
    }

    private static void getWebContent() throws IOException {
        StringBuffer sb = new StringBuffer();

        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet("http://www.baidu.com");
        HttpResponse response = httpclient.execute(httpget);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            InputStream instream = entity.getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(instream));

            String lineStr = "";
            while ((lineStr = reader.readLine()) != null) {
                sb.append(lineStr);
            }
            instream.close();
            httpclient.getConnectionManager().shutdown();
        }
        System.out.println("------------------------------------");
        System.out.println(sb.toString());
    }

    private static void downloadFile() throws IOException {
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet("https://github.com/spring-guides/gs-rest-service/archive/master.zip");
        HttpResponse response = httpclient.execute(httpget);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            InputStream instream = entity.getContent();

            String file = "a.zip";
            FileOutputStream op = new FileOutputStream(file);
            byte[] bs = new byte[1024];
            int length = 0;
            while ((length = instream.read(bs)) > 1) {
                op.write(bs, 0, length);
            }
            instream.close();
            op.close();
            httpclient.getConnectionManager().shutdown();
        }
    }
}
