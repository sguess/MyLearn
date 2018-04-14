package com.sguess.learn.test;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "mycustomer")
public class MyCustomer {
	@Id
	private int id;

	@Column(name = "name")
	private String name;

	@OneToMany(cascade = CascadeType.ALL)
	@Column(name = "ordersId")
//	@JoinColumn(name = "myorderid")
	private List<MyOrder> orders;
	
	public MyCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyCustomer(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MyOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<MyOrder> orders) {
		this.orders = orders;
	}

}
