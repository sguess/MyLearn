package com.sguess.learn;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sguess.learn.test.MyCustomer;
import com.sguess.learn.test.MyCustomerRepostory;
import com.sguess.learn.test.MyOrder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyCustomerRepostoryTest {
	@Autowired
	private MyCustomerRepostory dao;

	@Test
	public void test() {
		MyCustomer cus = new MyCustomer("Tom");
		List<MyOrder> orderList = new ArrayList<MyOrder>();
		orderList.add(new MyOrder("01"));
		orderList.add(new MyOrder("02"));
		orderList.add(new MyOrder("03"));
		orderList.add(new MyOrder("04"));
		cus.setOrders(orderList);
		dao.save(cus);

	}
}
