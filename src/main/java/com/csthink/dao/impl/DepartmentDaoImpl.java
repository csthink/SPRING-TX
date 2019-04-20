package com.csthink.dao.impl;

import com.csthink.dao.DepartmentDao;
import com.csthink.entity.Department;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository("departmentDao")
public class DepartmentDaoImpl implements DepartmentDao {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public Department findById(Integer id) {
        String sql = "select * from department where id = ?";
        return jdbcTemplate.queryForObject(sql, new DepartmentRowMapper(), id);
    }

    private class DepartmentRowMapper implements RowMapper<Department> {

        @Override
        public Department mapRow(ResultSet resultSet, int i) throws SQLException {
            Department department = new Department();
            department.setId(resultSet.getInt("id"));
            department.setDeptName(resultSet.getString("dept_name"));
            department.setAddress(resultSet.getString("address"));
            department.setCreateTime(resultSet.getTimestamp("create_time"));
            department.setUpdateTime(resultSet.getTimestamp("update_time"));
            return department;
        }
    }
}
