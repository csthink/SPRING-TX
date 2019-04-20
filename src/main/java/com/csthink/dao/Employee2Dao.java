package com.csthink.dao;

import com.csthink.entity.Employee2;

import java.util.List;

public interface Employee2Dao {

    void insert(Employee2 employee2);

    List<Employee2> findAll();
}
