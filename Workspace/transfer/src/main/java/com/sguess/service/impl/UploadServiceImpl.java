package com.sguess.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sguess.service.IUploadService;

@Service
public class UploadServiceImpl implements IUploadService {
    private static final Logger LOG = LoggerFactory.getLogger(UploadServiceImpl.class);

    @Override
    public String uploadFile(MultipartFile uploadFile) {
        String file = "a.txt";
        try {
            InputStream inputStream = uploadFile.getInputStream();
            getFile(inputStream, file);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "successful";
    }

    private void getFile(InputStream is, String fileName) throws IOException {
        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        in = new BufferedInputStream(is);
        out = new BufferedOutputStream(new FileOutputStream(fileName));
        int len = -1;
        byte[] b = new byte[1024];
        while ((len = in.read(b)) != -1) {
            out.write(b, 0, len);
        }
        in.close();
        out.close();
    }

    @Override
    public String downloadFile(File file) {
        return null;
    }

}
