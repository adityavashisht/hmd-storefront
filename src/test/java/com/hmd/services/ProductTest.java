package com.hmd.services;

import com.halalmeatdepot.domain.ProductType;
import com.halalmeatdepot.domain.design.tpsc.DownActivity;
import com.halalmeatdepot.domain.design.tpsc.UpActivity;
import com.halalmeatdepot.service.ReferenceDataService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.lang.ref.Reference;
import java.util.Date;
import java.util.List;

/**
 * Created by vashishta on 9/3/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
// Multiple locations can be specified with comma delimited values
@ContextConfiguration(locations = {
        "/storefront.xml"
})

@Transactional
public class ProductTest {


    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ReferenceDataService referenceDataService;


    @Test
    public void getAllProducts() {
        Session session = sessionFactory.getCurrentSession();

        List<ProductType> productTypeList = session.createQuery("from ProductType").list();

        for (ProductType productType : productTypeList) {
            System.out.println(productType.getName());
        }


    }

    @Test
    @Rollback(false)
    public void getAllViaService() {
        referenceDataService.getAllProductTypes();

        referenceDataService.getAllProductTypes();


    }


}
