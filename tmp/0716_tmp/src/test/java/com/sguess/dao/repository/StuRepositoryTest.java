package com.sguess.dao.repository;

import com.sguess.dao.entity.StuEntity;
import org.junit.After;
import org.junit.Before;
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
public class StuRepositoryTest {

    @Autowired
    StuRepository repository;

    @Before
    public void setUp() throws Exception {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 2018);
        c.set(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);
        Date time = c.getTime();
        StuEntity stuEntity = new StuEntity("Tom", time);
        repository.save(stuEntity);
        stuEntity.setName("Tom1");
        repository.save(stuEntity);
        stuEntity.setName("Tom2");
        repository.save(stuEntity);
        stuEntity.setName("Tom3");
        repository.save(stuEntity);
    }

    @After
    public void tearDown() throws Exception {
//        repository.deleteAll();
    }

    @Test
    public void test() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date queyrTime=sdf.parse("2018-01-01");
        List<StuEntity> rst = repository.selectStuListByDay("20180101");
        assertEquals(1, rst.size());
        assertEquals("Tom3", rst.get(0).getName());
    }
    @Test
    public void testTmp() {
        repository.save(new StuEntity("Tom",new Date()));
        repository.save(new StuEntity("Tom1",new Date()));
        repository.save(new StuEntity("Tom2",new Date()));
        repository.save(new StuEntity("Tom3",new Date()));
        List<StuEntity> list = repository.findAll();
        for (StuEntity stuEntity : list) {
            System.out.println(stuEntity.toString()+",\t"+stuEntity.getTime().toString());
        }
    }
    @Test
    public void testCreateTable() {
        repository.createTable();
        List<String> tables=repository.showTables();
        System.out.println(tables.toArray());
    }

    @Test
    public void testQuery() {
        String tableName = "stu001";
        List<StuEntity> rstList = repository.selectAllbyTable(tableName);
        for (StuEntity stuEntity : rstList) {
            if(stuEntity==null){
                System.out.println("Rst is: ---> null");
            }else{
                System.out.println("Rst is: ---> " + stuEntity.toString());
            }

        }
    }


}