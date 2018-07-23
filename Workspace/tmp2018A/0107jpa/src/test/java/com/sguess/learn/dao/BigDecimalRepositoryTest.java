package com.sguess.learn.dao;

import com.sguess.learn.bean.BigDecimalBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BigDecimalRepositoryTest {

    @Autowired
    BigDecimalRepository repository;

    @Test
    public void test01() {
        List<BigDecimalBean> list = new ArrayList<>();
        list.add(new BigDecimalBean("Tom", new BigDecimal("1.11")));
        List<BigDecimalBean> rst = repository.save(list);
        System.out.println("--------->" + rst.size());
        List<BigDecimalBean> newRst = repository.findAll();
        System.out.println("--------->" + newRst.size());
    }

    @Test
    public void test02() {
        List<BigDecimalBean> list = new ArrayList<>();
        list.add(new BigDecimalBean("Tom", new BigDecimal("1.11")));
        list.add(new BigDecimalBean("Tom01", new BigDecimal("1.12")));
        repository.save(list);
        List<BigDecimalBean> rst = repository.getAllByNameContaining("Tom");
        assertEquals(2, rst.size());
        assertEquals("Tom", rst.get(0).getName());
    }

    @Test
    public void test03() {
        List<BigDecimalBean> list = new ArrayList<>();
        list.add(new BigDecimalBean("Tom", new BigDecimal("1.11")));
        list.add(new BigDecimalBean("Tom01", new BigDecimal("1.12")));
        repository.save(list);
        BigDecimalBean data = repository.test001("Tom");
        assertEquals(0, data.getPrice().compareTo(new BigDecimal("1.11")));
        assertEquals(data.getPrice(), new BigDecimal("1.11"));
    }

    @Test
    public void test04() {
        List<BigDecimalBean> list = new ArrayList<>();
        list.add(new BigDecimalBean("Tom", new BigDecimal("1.11")));
        list.add(new BigDecimalBean("Tom01", new BigDecimal("1.12")));
        repository.save(list);
        List<BigDecimalBean> listRst = repository.testAll();
        for (BigDecimalBean bigDecimalBean : listRst) {
            System.out.println("----->"+bigDecimalBean.toString());
        }
        assertEquals(3,listRst.size());
        assertEquals(0, listRst.get(0).getPrice().compareTo(new BigDecimal("2.01")));
        assertEquals(listRst.get(0).getPrice(), new BigDecimal("2.01"));
    }

    @Test
    public void testName() {
        List<BigDecimalBean> list = new ArrayList<>();
        list.add(new BigDecimalBean("Tom", new BigDecimal("3.01")));
        for (BigDecimalBean bean : list) {
//            repository.insert(bean.getName(),bean.getPrice());
            repository.test002(bean.getPrice());
        }
        List<BigDecimalBean> listRst = repository.testName2("Tom");
        for (BigDecimalBean bigDecimalBean : listRst) {
            System.out.println("----->"+bigDecimalBean.toString());
        }
        assertTrue(2<listRst.size());

    }

}
