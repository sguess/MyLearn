package com.sguess.learn.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sguess.learn.bean.City;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityRepositoryTest {
	@Autowired
	public CityRepository dao;
	
	@Test
	public void test1() {
		City city=new City("name001","state001");
		dao.save(city);
		
	}

}
