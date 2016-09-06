package com.hmd.services;



import com.halalmeatdepot.domain.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 * Created by vashishta on 9/3/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
// Multiple locations can be specified with comma delimited values
@ContextConfiguration(locations = {
        "/storefront.xml"
})

@Transactional
public class CriteriaTest {

    @Autowired
    private SessionFactory sessionFactory;



    @Test
    public void testGetOrderByCustomerName() {

        Session session = sessionFactory.getCurrentSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        // UPDATED: Create CriteriaQuery
        CriteriaQuery<Order> criteria = builder.createQuery(Order.class);

        // UPDATED: Specify criteria root
        criteria.from(Order.class);

        



    }
}
