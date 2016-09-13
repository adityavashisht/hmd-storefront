package com.halalmeatdepot.service;

import com.halalmeatdepot.domain.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vashishta on 9/13/16.
 */
@Component
@Transactional
public class OrderService {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     *
     * @param id
     * @return
     */
    public Order getById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (Order) session.load(Order.class,id);
    }
}
