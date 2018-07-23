package com.sguess.dao.impl;

import com.sguess.dao.IStuDao;
import com.sguess.dao.entity.StuEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StuDaoImplTest {

    @Autowired
    IStuDao dao;

    @Test
    public void test1() {
        StuEntity stuEntity = new StuEntity("Tom", new Date());
        StuEntity rst = dao.save(stuEntity);
        System.out.println(rst.getName().equals("Tom"));
    }

    @Test
    public void testQuery() {
        Long id = 1l;
        StuEntity rst = dao.findById(id);
        assertNull(rst);
        StuEntity stuEntity = new StuEntity("Tom", new Date());
        dao.save(stuEntity);
        rst = dao.findById(id);
        assertEquals("Tom", rst.getName());
    }

    @Test
    public void testQueryThroughDate() throws ParseException {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 2018);
        c.set(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);
        Date time = c.getTime();
        StuEntity stuEntity = new StuEntity("Tom", time);
        dao.save(stuEntity);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date queyrTime = sdf.parse("2018-01-01");
        List<StuEntity> rst = dao.getStuListByTime(queyrTime);
        assertNotNull(rst);
        assertTrue(rst.size() > 0);
        assertEquals("Tom", rst.get(0).getName());
    }

    @Test
    public void testQueryThroughDate2() throws ParseException {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 2018);
        c.set(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);
        Date time = c.getTime();
        StuEntity stuEntity = new StuEntity("Tom", time);
        dao.save(stuEntity);
        dao.save(new StuEntity("Tom9", new SimpleDateFormat("yyyyMMdd").parse("20180109")));
        dao.save(new StuEntity("Tom10", new SimpleDateFormat("yyyyMMdd").parse("20180110")));
        dao.save(new StuEntity("Tom11", new SimpleDateFormat("yyyyMMdd").parse("20180111")));
        dao.save(new StuEntity("Tom11", new SimpleDateFormat("yyyyMMdd HHmmss").parse("20180111 000101")));

        List<StuEntity> rst = dao.selectBySpecifyDate(2018, 0, 10);
        for (StuEntity entity : rst) {
            System.out.println("--->" + entity.toString());
        }
        assertNotNull(rst);
        assertTrue(rst.size() > 0);
        assertEquals("Tom10", rst.get(0).getName());
        assertEquals(2, rst.size());
    }

    public static void main(String[] args) throws ParseException {
        Date date = new SimpleDateFormat("yyyyMMdd").parse("20180110");
        System.out.println(date.toString());
    }

}