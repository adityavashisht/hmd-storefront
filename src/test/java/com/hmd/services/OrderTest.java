package com.hmd.services;

/**
 * Created by vashishta on 9/1/16.
 */

import com.halalmeatdepot.domain.*;
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
    @Rollback(value = false)
    public void testOrder() {

        Order order = new Order();
        order.setCreateDate(LocalDateTime.now());

        Phone phone = new Phone();
        phone.setHome("1121212121");
        phone.setMobile("2324232423432");
        phone.setWork("13234343");

        CustomerProfile customerProfile = new CustomerProfile();
        customerProfile.setPhone(phone);


        Customer customer = new Customer();
        customer.setEmail("aditya@indasil.com");
        customer.setCustomerProfile(customerProfile);
        customerProfile.setCustomer(customer);

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


        Session s = sessionFactory.getCurrentSession();
       /* s.setHibernateFlushMode(FlushMode.MANUAL);

        s.save(customer);

         s.flush();*/


        order.setCustomer(customer);


        OrderItem orderItem = new OrderItem();
        orderItem.setGiftWrap(true);
        // Tell the child who the parent is
        orderItem.setOrder(order);
        orderItem.setQuantity(2);


        // Add the child to the collection of children
        order.addItem(orderItem);

        OrderItem orderItemTwo = new OrderItem();
        orderItemTwo.setGiftWrap(true);
        // Tell the child who the parent is
        orderItemTwo.setOrder(order);
        orderItemTwo.setQuantity(2);


        // Add the child to the collection of children
        order.addItem(orderItemTwo);


        s.save(order);

        customerProfile.setId(customer.getId());
        s.save(customerProfile);


    }

    @Test
    public void testGetCustomer() {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.load(Customer.class, 1L);

        CustomerProfile customerProfile = customer.getCustomerProfile();
        System.out.println(customerProfile);


    }


}
