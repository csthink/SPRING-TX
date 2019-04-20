package com.csthink.dao.impl;

import com.csthink.dao.Employee2Dao;
import com.csthink.entity.Employee2;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository(value = "employee2Dao")
public class Employee2DaoImpl implements Employee2Dao {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insert(Employee2 employee2) {
        String sql = "insert employee2(`username`, `dept_id`, `create_time`, `update_time`) values(?,?,?,?)";
        jdbcTemplate.update(sql, employee2.getUsername(), employee2.getDeptId(), employee2.getCreateTime(), employee2.getUpdateTime());
    }

    @Override
    public List<Employee2> findAll() {
//        String sql = "select * from employee2";
//        return jdbcTemplate.query(sql, new Employee2RowMapper());


        List<Employee2> list = new ArrayList<>();
        String sql = "select * from employee2";
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql);

        if (mapList.size() != 0) {
            for (Map<String, Object> m : mapList) {
                System.out.println(m);
                Employee2 employee2 = new Employee2();
                employee2.setId((Integer) m.get("id"));
                employee2.setUsername((String) m.get("username"));
                // 这里为什么 m.get("dept_id") 得到的是 long
                employee2.setDeptId((Integer) m.get("dept_id"));
//                employee2.setDeptId(new Integer(String.valueOf(m.get("dept_id"))));
                employee2.setCreateTime((Date) m.get("create_time"));
                employee2.setUpdateTime((Date) m.get("update_time"));
                list.add(employee2);
            }
        }

        return list;

    }

    private class Employee2RowMapper implements RowMapper<Employee2> {

        @Override
        public Employee2 mapRow(ResultSet resultSet, int i) throws SQLException {
            List<Employee2> list = new ArrayList<>();
            Employee2 employee2 = new Employee2();
            employee2.setId(resultSet.getInt("id"));
            employee2.setUsername(resultSet.getString("username"));
            employee2.setDeptId(resultSet.getInt("dept_id"));
            employee2.setCreateTime(resultSet.getTimestamp("create_time"));
            employee2.setUpdateTime(resultSet.getTimestamp("update_time"));

            return employee2;
        }
    }
}


