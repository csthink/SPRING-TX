package com.csthink.service;

import com.csthink.entity.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:Spring3.xml")
public class DepartmentServiceTest {

    @Resource(name="departmentService")
    private DepartmentService departmentService;

    @Test
    public void testFindById() {
        Department department = departmentService.findById(1);
        System.out.println(department);
    }
}
