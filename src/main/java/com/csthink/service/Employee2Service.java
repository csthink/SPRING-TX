package com.csthink.service;

import com.csthink.entity.Employee2;

import java.util.List;

public interface Employee2Service {
    void add(Employee2 employee);

    List<Employee2> findAll();
}
