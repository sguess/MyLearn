package com.sguess.tmp;

import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.compressors.CompressorException;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.compressors.CompressorStreamFactory;
import org.junit.Test;

import java.io.*;

public class CompressUtilsTest {
    /**
     * To create a compressor writing to a given output by using the algorithm name:
     */
    String filePathStr = "S:/tmp/download/a";
    String fileStr = "S:/tmp/download/a/2018/a_20180101.txt";


    @Test
    public void testCreate01() throws FileNotFoundException, CompressorException {
        OutputStream myOutputStream = new FileOutputStream(filePathStr + "/a.gz");
        CompressorOutputStream gzippedOut = new CompressorStreamFactory()
                .createCompressorOutputStream(CompressorStreamFactory.GZIP, myOutputStream);

    }

    /**
     * Make the factory guess the input format for a given archiver stream:
     */
    @Test
    public void testCreate02() throws FileNotFoundException, ArchiveException {
        String file = "S:/tmp/download/a/2018/a_20180101.txt";
        InputStream originalInput = new FileInputStream(file);
        ArchiveInputStream input = new ArchiveStreamFactory()
                .createArchiveInputStream(originalInput);
    }

    /**
     * Make the factory guess the input format for a given compressor stream:
     */
    @Test
    public void testCreate03() throws FileNotFoundException, CompressorException {
        String file = "";
        InputStream originalInput = new FileInputStream(file);
        CompressorInputStream input = new CompressorStreamFactory()
                .createCompressorInputStream(originalInput);
    }

    /**
     * File targetDir = ...
     * try (ArchiveInputStream i = ... create the stream for your format, use buffering...) {
     * ArchiveEntry entry = null;
     * while ((entry = i.getNextEntry()) != null) {
     * if (!i.canReadEntryData(entry)) {
     * // log something?
     * continue;
     * }
     * String name = fileName(targetDir, entry);
     * File f = new File(name);
     * if (entry.isDirectory()) {
     * if (!f.isDirectory() && !f.mkdirs()) {
     * throw new IOException("failed to create directory " + f);
     * }
     * } else {
     * File parent = f.getParentFile();
     * if (!parent.isDirectory() && !parent.mkdirs()) {
     * throw new IOException("failed to create directory " + parent);
     * }
     * try (OutputStream o = Files.newOutputStream(f.toPath())) {
     * IOUtils.copy(i, o);
     * }
     * }
     * }
     * }
     */
    @Test
    public void testArichive() {
//        File targetDir = ...
//        try (ArchiveInputStream i = ... create the stream for your format, use buffering...) {
//            ArchiveEntry entry = null;
//            while ((entry = i.getNextEntry()) != null) {
//                if (!i.canReadEntryData(entry)) {
//                    // log something?
//                    continue;
//                }
//                String name = fileName(targetDir, entry);
//                File f = new File(name);
//                if (entry.isDirectory()) {
//                    if (!f.isDirectory() && !f.mkdirs()) {
//                        throw new IOException("failed to create directory " + f);
//                    }
//                } else {
//                    File parent = f.getParentFile();
//                    if (!parent.isDirectory() && !parent.mkdirs()) {
//                        throw new IOException("failed to create directory " + parent);
//                    }
//                    try (OutputStream o = Files.newOutputStream(f.toPath())) {
//                        IOUtils.copy(i, o);
//                    }
//                }
//            }
//        }
    }
}
