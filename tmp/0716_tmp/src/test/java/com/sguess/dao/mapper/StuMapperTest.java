package com.sguess.dao.mapper;

import com.sguess.dao.entity.StuEntity;
import com.sguess.dao.repository.StuRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StuMapperTest {

    @Autowired
    private StuMapper stuMapper;

    @Autowired
    private StuRepository repository;

    @Test
    public void test01() {
        StuEntity stu = new StuEntity("Tom", new Date());
        repository.save(stu);
        List<StuEntity> list = stuMapper.selectAllStudent();
        assertEquals(1, list.size());
        assertEquals("Tom", list.get(0).getName());
        for (StuEntity stuEntity : list) {
            System.out.println(stuEntity.toString());
        }
    }

    @Test
    public void showTables() {
        List<String> list = stuMapper.showTables();
        assertTrue(list.size() > 0);
        for (String tableName : list) {
            System.out.println("--->" + tableName);
        }
    }

    @Test
    public void createTable() {
        List<String> list = stuMapper.showTables();
        int rst = stuMapper.createTable();
        List<String> list2 = stuMapper.showTables();
        for (String tableName : list2) {
            System.err.println("--->" + tableName);
        }
        assertEquals(1, list2.size() - list.size());
    }

    @Test
    public void createTableWithParm() {
        List<String> list = stuMapper.showTables();
        int rst = stuMapper.createTableWithParp("tbl001");
        List<String> list2 = stuMapper.showTables();
        for (String tableName : list2) {
            System.err.println("--->" + tableName);
        }
        assertEquals(1, list2.size() - list.size());
//        assertTrue(list2.contains("tbl001"));
    }

    @Test
    public void testInsertData() {
        String tableName = "stu001";
//        stuMapper.createTableWithParp(tableName);
        StuEntity stu = new StuEntity("Tom", new Date());
        stuMapper.insert(tableName, stu);
        List<StuEntity> list = stuMapper.selectAllWithTableName(tableName);
        System.out.println(list.size());
        for (StuEntity stuEntity : list) {
            System.out.println(stuEntity.toString());
        }
    }

    @Test
    public void testBatchInsertData() {
        String tableName = "stu001";
//        stuMapper.createTableWithParp(tableName);
        List<StuEntity> list = new ArrayList<>();
        list.add(new StuEntity("Tom1", new Date()));
        list.add(new StuEntity("Tom2", new Date()));
        list.add(new StuEntity("Tom3", new Date()));
        list.add(new StuEntity("Tom4", new Date()));
        list.add(new StuEntity("Tom5", new Date()));
        int status = stuMapper.insertBatch(tableName, list);
        System.out.println("---------------->" + status);
        List<StuEntity> rstList = repository.selectAllbyTable(tableName);
        for (StuEntity stuEntity : rstList) {
            if (stuEntity == null) {
                System.out.println("Rst is: ---> null");
            } else {
                System.out.println("Rst is: ---> " + stuEntity.toString());
            }

        }
    }

    @Test
    public void testQuery() {
        String tableName = "stu001";
        List<StuEntity> rstList = repository.selectAllbyTable(tableName);
        for (StuEntity stuEntity : rstList) {
            if (stuEntity == null) {
                System.out.println("Rst is: ---> null");
            } else {
                System.out.println("Rst is: ---> " + stuEntity.toString());
            }

        }
    }

    public static void main(String[] args) {
        MessageFormat messageFormat = new MessageFormat("");
    }

    @Test
    public void testSave10000() {
        String tableName = "stu001";
        for (int i = 0; i < 100; i++) {
            List<StuEntity> list = getEntityList();
            int status = stuMapper.insertBatch(tableName, list);
            System.out.println("status:" + status);
        }
    }

    private List<StuEntity> getEntityList() {
        List<StuEntity> list = new ArrayList<>();
        for (int i = 0; i < 3000; i++) {
            list.add(new StuEntity("Closing org.springframework.web.context.support.GenericWebApplicationContext@4722ef0c: startup date [Mon Jul 23 17:56:21 CST 2018]; root of context hierarchy" + i, new Date()));
        }
        return list;
    }
}