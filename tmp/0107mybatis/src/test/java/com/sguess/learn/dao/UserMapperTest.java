package com.sguess.learn.dao;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sguess.learn.bean.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
	@Autowired
	public UserMapper mapper;

	@Before
	public void setUp() {
		mapper.deleteAll();
	}

	@Test
	public void testInsert() {
		mapper.insertUser(new User("Jerry", 1));
		mapper.insertUser(new User("Tom", 2));
	}

	@Test
	public void testSelectOne() {
		mapper.insertUser(new User("Jerry", 3));
		mapper.insertUser(new User("Tom", 4));
		assertEquals("Jerry", mapper.selectOneUserByAge(3).getName());
		assertEquals("Tom", mapper.selectOneUserByAge(4).getName());
	}

	@Test
	public void testSelectList() {
		mapper.insertUser(new User("Jerry", 5));
		mapper.insertUser(new User("Tom01", 6));
		mapper.insertUser(new User("Tom02", 7));
		List<User> userList = mapper.selectUserListLikeName("Tom%");
		assertEquals(2, userList.size());
		assertEquals("Tom01", userList.get(0).getName());
		assertEquals("Tom02", userList.get(1).getName());
	}
	
//	@Test
	public void testSelectMap() {
		mapper.insertUser(new User("Jerry", 5));
		mapper.insertUser(new User("Tom01", 6));
		mapper.insertUser(new User("Tom02", 7));
		Map<String,Integer> map = mapper.selectUserMap();
		assertEquals(3, map.size());
		assertEquals(new Integer(6), map.get("Tom01"));
	}
	
	@Test
	public void updateAge() {
		mapper.insertUser(new User("Jerry", 5));
		mapper.insertUser(new User("Tom", 6));
		assertEquals(6,mapper.selectUserListLikeName("Tom").get(0).getAge());
		mapper.updateAgeByName("Tom", 7);
		assertEquals(7,mapper.selectUserListLikeName("Tom").get(0).getAge());
	}
	
	
	
}
