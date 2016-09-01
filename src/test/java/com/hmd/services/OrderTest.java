package com.hmd.services;

/**
 * Created by vashishta on 9/1/16.
 */

import com.halalmeatdepot.domain.Customer;
import com.halalmeatdepot.domain.Order;
import com.halalmeatdepot.domain.OrderItem;
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


    @Test
    @Rollback( value = false)
    public void testOrder() {

        Order order= new Order();
        order.setCreateDate(LocalDateTime.now());

        Customer customer = new Customer();
        customer.setEmail("aditya@indasil.com");

        Session s = sessionFactory.getCurrentSession();
       /* s.setHibernateFlushMode(FlushMode.MANUAL);

        s.save(customer);

         s.flush();*/


        order.setCustomer(customer);




        OrderItem orderItem= new OrderItem();
        orderItem.setGiftWrap(true);
        // Tell the child who the parent is
        orderItem.setOrder(order);
        orderItem.setQuantity(2);


        // Add the child to the collection of children
        order.addItem(orderItem);


        s.save(order);




    }
}
