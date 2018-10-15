package com.sguess.tmp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

public class CommonsBZip2Compress extends Compress {
    @Override
    protected void doCompress(File srcFile, File destFile) throws IOException {
        OutputStream out = null;
        InputStream is = null;
        try {
            int bufferLen = (int) srcFile.length();
            is = new BufferedInputStream(new FileInputStream(srcFile), bufferLen);
            out = new GzipCompressorOutputStream(new BufferedOutputStream(new FileOutputStream(destFile), bufferLen));
            IOUtils.copy(is, out);
        } finally {
            IOUtils.closeQuietly(is);
            IOUtils.closeQuietly(out);
        }
    }

    @Override
    protected void doDecompress(File srcFile, File destDir) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        int bufferLen = (int) srcFile.length();
        try {
            File destFile = new File(destDir, FilenameUtils.getBaseName(srcFile.toString()));
            is = new GzipCompressorInputStream(new BufferedInputStream(new FileInputStream(srcFile), bufferLen));
            os = new BufferedOutputStream(new FileOutputStream(destFile), bufferLen);
            IOUtils.copy(is, os);
        } finally {
            IOUtils.closeQuietly(is);
            IOUtils.closeQuietly(os);
        }
    }

    public static void main(String[] args) throws IOException {
        File srcFile = new File("S:/tmp/download/a/2018/a_20180101.txt");
        File descFile = new File("S:/tmp/download/a.gz");
        new CommonsBZip2Compress().doCompress(srcFile, descFile);
    }

}
