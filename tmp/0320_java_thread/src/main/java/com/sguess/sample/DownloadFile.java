package com.sguess.sample;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DownloadFile {

    public static void main(String[] args) throws MalformedURLException {
        String urlStr = "http://124.205.69.131/files/3193000006C4893D/download.redis.io/releases/redis-4.0.10.tar.gz";
        new DownloadFile().downloadNet(urlStr, "c:/tmp/", "a.tar.gz");
    }

    public void downloadNet(String urlStr, String filePath, String fileName) throws MalformedURLException {
        int byteread = 0;
        URL url = new URL(urlStr);
        try {
            URLConnection conn = url.openConnection();
            InputStream inStream = conn.getInputStream();
            FileOutputStream fs = new FileOutputStream(filePath + fileName);
            byte[] buffer = new byte[12040];
            int length;
            while ((byteread = inStream.read(buffer)) != -1) {
                fs.write(buffer, 0, byteread);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
