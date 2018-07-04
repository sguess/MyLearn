package com.sguess.learn.bean01;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

//@Entity
public class Customer01 {


    private Set<Order01> orders01;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    public Set<Order01> getOrders() {
        return orders01;
    }

}
