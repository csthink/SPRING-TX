package com.csthink.service;

import com.csthink.entity.Employee2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:Spring2.xml")
public class Employee2ServiceTest {

    @Resource(name = "employee2Service")
    private Employee2Service employee2Service;

    @Test
    public void testAdd() {
        Employee2 employee2 = new Employee2();
        employee2.setUsername("张三");
        employee2.setDeptId(2);
        employee2Service.add(employee2);
    }

    @Test
    public void testFindAll() {
        List<Employee2> list = employee2Service.findAll();
        System.out.println(list);
    }
}
