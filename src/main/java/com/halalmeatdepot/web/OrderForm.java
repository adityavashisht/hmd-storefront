package com.halalmeatdepot.web;

import com.halalmeatdepot.domain.Order;
import com.halalmeatdepot.domain.OrderItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vashishta on 9/2/16.
 */
public class OrderForm {

    private Order order;

    private List<OrderItem> items = new ArrayList<OrderItem>();

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setUpForSave() {
        for (OrderItem orderItem : getItems()) {
            if (orderItem.getItemName() != null) {
                order.addItem(orderItem);
            }
        }
    }
}
