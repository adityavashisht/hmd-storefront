package com.halalmeatdepot.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;


/**
 * Created by vashishta on 8/30/16.
 */
public class Order implements Serializable {

    private Long id;
    private Customer customer = new Customer();
    private LocalDateTime createDate;


    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    private List<OrderItem> orderItemSet= new ArrayList<>();

    public List<OrderItem> getOrderItemSet() {
        return orderItemSet;
    }

    public void setOrderItemSet(List<OrderItem> orderItemSet) {
        this.orderItemSet = orderItemSet;
    }

    public void addItem(OrderItem orderItem) {
        orderItemSet.add(orderItem);
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        return getId() != null ? getId().equals(order.getId()) : order.getId() == null;

    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", createDate=" + createDate +
                ", orderItemSet=" + orderItemSet +
                '}';
    }
}
