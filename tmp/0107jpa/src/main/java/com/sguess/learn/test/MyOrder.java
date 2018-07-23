package com.sguess.learn.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "myorder")
public class MyOrder {
	@Id
	private int id;

	@Column
	private String orderName;

	public MyOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyOrder(String orderName) {
		super();
		this.orderName = orderName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	
}
