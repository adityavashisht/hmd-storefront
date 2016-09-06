package com.hmd.services;

import com.halalmeatdepot.domain.design.DownActivity;
import com.halalmeatdepot.domain.design.UpActivity;
import com.halalmeatdepot.domain.mm.Employee;
import com.halalmeatdepot.domain.mm.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by vashishta on 9/3/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
// Multiple locations can be specified with comma delimited values
@ContextConfiguration(locations = {
        "/storefront.xml"
})

@Transactional
public class ActivityTest {


    @Autowired
    private SessionFactory sessionFactory;


    @Test
    @Rollback(value = false)
    public void testUpActivity() {

        UpActivity upActivity = new UpActivity();
        upActivity.setName("New Up Activity");
        upActivity.setSelectDate(new Date());
        upActivity.setCreateDate(new Date());
        upActivity.setUpdateDate(new Date());

        Session session = sessionFactory.getCurrentSession();
        session.save(upActivity);

    }

    @Test
    @Rollback(value = false)
    public void testDownActivity() {

        DownActivity downActivity = new DownActivity();
        downActivity.setName("New Down Activity");

        downActivity.setCreateDate(new Date());
        downActivity.setSignal(true);


        Session session = sessionFactory.getCurrentSession();
        session.save(downActivity);


    }


}
