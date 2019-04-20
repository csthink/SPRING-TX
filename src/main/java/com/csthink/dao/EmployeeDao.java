package com.csthink.dao;

import com.csthink.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    void insert(Employee employee);

    void update(Employee employee);

    void delete(Integer uid);

    Employee findByUid(Integer uid);

    List<Employee> findAll();
}
