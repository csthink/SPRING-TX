package com.csthink.service.impl;

import com.csthink.dao.Employee2Dao;
import com.csthink.entity.Employee2;
import com.csthink.service.Employee2Service;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service(value = "employee2Service")
public class Employee2ServiceImpl implements Employee2Service {

    @Resource(name="employee2Dao")
    private Employee2Dao employee2Dao;

    @Override
    public void add(Employee2 employee2) {
        employee2.setCreateTime(new Date());
        employee2.setUpdateTime(new Date());
        employee2Dao.insert(employee2);
    }

    @Override
    public List<Employee2> findAll() {
        return employee2Dao.findAll();
    }
}
