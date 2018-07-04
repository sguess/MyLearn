package com.sguess.learn.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sguess.learn.bean.City;
import com.sguess.learn.bean.Mayor;
import com.sguess.learn.bean.Street;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityRepositoryTest {
    @Autowired
    public CityRepository dao;
    //	@Autowired
    public StreetRepository streetDao;

    @Before
    public void setup() {
        dao.deleteAll();
    }

    @Test
    public void test1() {
        City city = new City("name001", "state001");
        dao.save(city);
        dao.save(city);
        List<City> cityList = dao.findAll();
        assertEquals(1, cityList.size());
    }

    @Test
    public void test2() {
        dao.save(new City("name001", "state001"));
        dao.save(new City("name001", "state001"));
        List cityList = dao.findAll();
        assertEquals(2, cityList.size());
    }

    @Test
    public void test3() {
        dao.save(new City("name001", "state001"));
        dao.save(new City("name001", "state001"));
        List cityList = dao.queryAllCity();
        assertEquals(2, cityList.size());
    }

    @Test
    public void testAddStreet() {
        City city = new City("name001", "state001");
        List streetList = new ArrayList();
        streetList.add(new Street("streetname1", 710077));
        streetList.add(new Street("streetname2", 710070));
        city.setStreets(streetList);
        city.setMayor(new Mayor("Tom"));
        dao.save(city);
        List cityList = dao.queryAllCity();
        assertEquals(1, cityList.size());
    }

}
