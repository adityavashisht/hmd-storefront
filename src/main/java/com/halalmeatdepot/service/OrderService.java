package com.halalmeatdepot.service;

import com.halalmeatdepot.domain.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * Created by vashishta on 9/2/16.
 */
@Component
@Transactional
public class OrderService {

    @Autowired
    private SessionFactory sessionFactory;

    public Order create(Order order) {
        Session session = sessionFactory.getCurrentSession();
        order.setCreateDate(LocalDateTime.now());
        session.save(order);

        return order;
    }
}
