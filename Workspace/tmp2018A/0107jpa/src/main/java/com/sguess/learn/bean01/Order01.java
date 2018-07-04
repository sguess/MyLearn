package com.sguess.learn.bean01;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//@Entity
public class Order01 {
    @Column
    private Customer01 customer01;

    @ManyToOne
    @JoinColumn(name = "CUST_ID", nullable = false)
    public Customer01 getCustomer() {
        return customer01;
    }
}
