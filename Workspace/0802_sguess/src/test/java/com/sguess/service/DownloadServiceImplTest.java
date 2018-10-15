package com.sguess.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DownloadServiceImplTest {

    @Autowired
    IDownloadService service;

    @Test
    public void test01() throws ParseException, IOException {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        for (String name : list) {
            service.downloadInDayPeriod(name, getDate("20180101"), getDate("20180301"));
        }
    }

    @Test
    public void testDownloadByMonth() throws ParseException, IOException {
        service.downloadByMonth("a", new SimpleDateFormat("yyyyMMdd").parse("20180101"));
        service.downloadByMonth("a", new SimpleDateFormat("yyyyMMdd").parse("20180201"));
        service.downloadByMonth("a", new SimpleDateFormat("yyyyMMdd").parse("20180301"));
        service.downloadByMonth("a", new SimpleDateFormat("yyyyMMdd").parse("20180401"));
        service.downloadByMonth("a", new SimpleDateFormat("yyyyMMdd").parse("20180501"));
        service.downloadByMonth("a", new SimpleDateFormat("yyyyMMdd").parse("20180601"));
        service.downloadByMonth("a", new SimpleDateFormat("yyyyMMdd").parse("20180701"));
        service.downloadByMonth("a", new SimpleDateFormat("yyyyMMdd").parse("20180801"));
    }

    private Date getDate(String dateStr) throws ParseException {
        return new SimpleDateFormat("yyyyMMdd").parse(dateStr);
    }
}