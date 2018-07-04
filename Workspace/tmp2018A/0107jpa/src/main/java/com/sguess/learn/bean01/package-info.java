/**
 * Example 1: One-to-Many association using generics
 * <p>
 * // In Customer class:
 *
 * @OneToMany(cascade=ALL, mappedBy="customer")
 * public Set<Order> getOrders() { return orders; }
 * <p>
 * In Order class:
 * @ManyToOne
 * @JoinColumn(name="CUST_ID", nullable=false)
 * public Customer getCustomer() { return customer; }
 * @author Admin
 */
/**
 * @author Admin
 *
 */
package com.sguess.learn.bean01;


