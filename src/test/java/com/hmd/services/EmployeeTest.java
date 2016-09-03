package com.hmd.services;

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

/**
 * Created by vashishta on 9/3/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
// Multiple locations can be specified with comma delimited values
@ContextConfiguration(locations = {
        "/storefront.xml"
})

@Transactional
public class EmployeeTest {


    @Autowired
    private SessionFactory sessionFactory;


    @Test
    @Rollback (value=false)
    public void testManyManyEP() {

        Employee employee = new Employee();
        employee.setName("Aditya");

        Project project = new Project();
        project.setName("Billmywork");


        Project another = new Project();
        another.setName("HalalMeatDepot");

        employee.getProjects().add(project);
        employee.getProjects().add(another);

        Session session = sessionFactory.getCurrentSession();
        session.save(employee);

    }
}
