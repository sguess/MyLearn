package com.sguess.learn.test;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyCustomerRepostory extends JpaRepository<MyCustomer, Integer> {

}
