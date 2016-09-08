package com.halalmeatdepot.service;

import com.halalmeatdepot.domain.ProductType;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by vashishta on 9/8/16.
 */
@Component
@Transactional(readOnly = true)
public class ReferenceDataService {

    @Autowired
    private SessionFactory sessionFactory;


    @Cacheable(value="productType", cacheManager = "cacheManager")
    public List<ProductType> getAllProductTypes() {
        return  sessionFactory.openSession().createQuery("from ProductType").list();
    }

    @PostConstruct
    public void init() {
        getAllProductTypes();
    }
}
