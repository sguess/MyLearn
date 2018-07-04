package com.sguess.learn.dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TableMapperTest {
    @Autowired
    TableMapper mapper;

    @Test
    public void test() {
        String tableName = "Tmp00";
        mapper.createTmpTable(tableName);
        assertTrue(isContaint(mapper.showTables(), tableName));
        mapper.dropTable(tableName);
        assertFalse(isContaint(mapper.showTables(), tableName));
    }

    public boolean isContaint(List<String> lists, String str) {
        for (String tmp : lists) {
            if (tmp.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

}
