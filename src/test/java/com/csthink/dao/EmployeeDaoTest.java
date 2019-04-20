package com.csthink.dao;

import com.csthink.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:Spring.xml")
public class EmployeeDaoTest {

    @Resource(name="employeeDao")
    private EmployeeDao employeeDao;

    @Test
    public void testInsert() {
        Employee employee = new Employee();
        employee.setUsername("小王31");
        employee.setPassword("111111");
        employee.setName("王小二");

        employeeDao.insert(employee);
    }

    @Test
    public void testUpdate() {
        Employee employee = employeeDao.findByUid(32);
        if (employee != null) {
            employee.setUsername("小王11");
            employeeDao.update(employee);
        }
    }

    @Test
    public void testDelete() {
        employeeDao.delete(33);
    }

    @Test
    public void testFindByUid() {
        Employee employee = employeeDao.findByUid(32);
        System.out.println(employee);
    }

    @Test
    public void testFindAll() {
        List<Employee> employees = employeeDao.findAll();
        System.out.println(employees);
    }

}
