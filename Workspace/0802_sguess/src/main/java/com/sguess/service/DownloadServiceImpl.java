package com.sguess.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class DownloadServiceImpl implements IDownloadService {
    Logger log = LoggerFactory.getLogger(DownloadServiceImpl.class);
    @Value("${download.file.path}")
    String downloadRootFilePath;

    @Override
    public boolean downloadInDayPeriod(String name, Date startDay, Date endDay) throws IOException {
        Calendar day = Calendar.getInstance();
        day.setTime(startDay);

        List<File> files = new ArrayList<>();
        while (day.getTime().before(endDay)) {
            files.add(downloadInDay(name, day.getTime()));
            day.add(Calendar.DAY_OF_MONTH, 1);
        }

        String compressedFilename = new SimpleDateFormat("yyyyMM").format(startDay) + ".7z";
        compress(getFilePath(name, startDay), compressedFilename, files);
        return true;
    }

    private void compress(String filePath, String compressedFilename, List<File> files) {

    }

    private File downloadInDay(String name, Date day) throws IOException {
        File file = getFile(name, day);
        if (file.exists()) {
            return file;
        }
        file.createNewFile();
        return file;
    }

    private File getFile(String name, Date day) {
        String filePath = getFilePath(name, day);
        if (!new File(filePath).exists()) {
            new File(filePath).mkdirs();
        }
        String fileName = getFileName(name, day);
        return new File(filePath + fileName);
    }


    private String getFileName(String name, Date day) {
        return name + "_" + new SimpleDateFormat("yyyyMMdd").format(day) + ".txt";
    }

    private String getFilePath(String name, Date day) {
        return downloadRootFilePath + name + File.separator + new SimpleDateFormat("yyyy").format(day) + File.separator;
    }


    @Override
    public boolean downloadByMonth(String name, Date monthDay) throws IOException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(monthDay);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date startDay = calendar.getTime();
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date endDay = calendar.getTime();
        if (new Date().after(endDay)) {
            endDay = new Date();
        }
        log.info("------------->" + monthDay + ":\t\t" + formatDate(startDay) + "," + formatDate(endDay));
        downloadInDayPeriod(name, startDay, endDay);

        return false;
    }

    private String formatDate(Date day) {
        return new SimpleDateFormat("yyyy-MM-dd").format(day);
    }

}
