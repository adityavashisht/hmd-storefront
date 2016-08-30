package com.halalmeatdepot.domain;

import java.io.Serializable;

/**
 * Created by vashishta on 8/30/16.
 */
public class Order implements Serializable {

    private Long id;
    private Customer customer;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
