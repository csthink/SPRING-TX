package com.csthink.service.impl;

import com.csthink.dao.DepartmentDao;
import com.csthink.entity.Department;
import com.csthink.service.DepartmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("departmentService")
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Resource(name = "departmentDao")
    private DepartmentDao departmentDao;

    @Override
    public Department findById(Integer id) {
        return departmentDao.findById(id);
    }
}
