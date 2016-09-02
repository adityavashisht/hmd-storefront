package com.hmd.services;

/**
 * Created by vashishta on 9/1/16.
 */

import com.halalmeatdepot.domain.*;
import com.halalmeatdepot.service.OrderService;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * Created by vashishta on 8/30/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
// Multiple locations can be specified with comma delimited values
@ContextConfiguration(locations = {
        "/storefront.xml"
})

@Transactional
public class OrderTest {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private OrderService orderService;


    @Test
    @Rollback(value = false)
    public void testOrder() {

        Order order = createNew();
        Session s = sessionFactory.getCurrentSession();

        s.save(order);


    }

    private Order createNew() {
        Order order = new Order();
        order.setCreateDate(LocalDateTime.now());

        Customer customer = new Customer();
        customer.setEmail("aditya@indasil.com");

        Address shipping = new Address();
        shipping.setAddressType(AddressType.SHIPPING);
        shipping.setCity("Chantilly");
        shipping.setStreet("Test Street");
        customer.getAddressSet().add(shipping);

        Address billing = new Address();
        billing.setAddressType(AddressType.BILLING);
        billing.setCity("Billing City");
        billing.setStreet("Test Street Billing");
        customer.getAddressSet().add(billing);


        order.setCustomer(customer);


        OrderItem orderItem = new OrderItem();
        orderItem.setGiftWrap(true);
        // Tell the child who the parent is
        orderItem.setOrder(order);
        orderItem.setItemName("Shoes");
        orderItem.setQuantity(2);


        // Add the child to the collection of children
        order.addItem(orderItem);

        OrderItem orderItemTwo = new OrderItem();
        orderItemTwo.setGiftWrap(true);
        orderItemTwo.setItemName("Clothes");
        // Tell the child who the parent is
        orderItemTwo.setOrder(order);
        orderItemTwo.setQuantity(2);


        // Add the child to the collection of children
        order.addItem(orderItemTwo);

        return order;
    }


    @Test
    @Rollback(value = false)
    public void testCreateNewFromService() {
        Order order = createNew();
        orderService.create(order);
    }


}
