package com.csthink.dao.impl;

import com.csthink.dao.EmployeeDao;
import com.csthink.entity.Employee;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * 编程式事务
 */
@Repository(value = "employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

    /**
     * 事务管理器对象
     */
    @Resource(name = "transactionManager")
    private DataSourceTransactionManager dtm;

    /**
     * Jdbc 模板对象
     */
    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

//    @Resource(name = "simpleJdbcInsert")
//    private SimpleJdbcInsert simpleJdbcInsert;

    /**
     * 使用事务管理器实现编程式事务
     *
     * @param employee
     */
    @Override
    public void insert(Employee employee) {
        // 使用事务模板方式实现编程式事务
        // 第一步: 使用事务管理器对象来创建事务模板对象
        TransactionTemplate template = new TransactionTemplate(dtm);
        // 根据需求，设置相关属性
        // 定义事务传播行为
        template.setIsolationLevel(TransactionDefinition.ISOLATION_REPEATABLE_READ);
        // 第二步: 选择事务结果类型 ---> 重写execute方法实现事务管理
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    // 第三步: 执行业务sql
                    // 方式一: 使用 jdbcTemplate 对象
                String sql = "insert employee(`username`, `password`, `name`) values(?,?,?)";
                jdbcTemplate.update(sql, employee.getUsername(), employee.getPassword(), employee.getName());
                    // 方式二: 使用 Spring 简单模板
                    /*simpleJdbcInsert.withTableName("employee").usingColumns("username", "password", "name");
                    Map<String, Object> map = new HashMap<>();
                    map.put("username", employee.getUsername());
                    map.put("password", employee.getPassword());
                    map.put("name", employee.getName());
                    simpleJdbcInsert.execute(map);*/
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                    e.printStackTrace();
                }
            }
        });

        /*
        // 使用事务管理器实现编程式事务
        // 第一步: 获取 JDBC 事务管理器，已通过属性注入 dtm
        // 第二步: 创建事务管理器属性对象 DefaultTransactionDefinition 是 TransactionDefinition 的实现类
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        // 根据需求，设置相关属性
        // 定义事务传播行为
        def.setPropagationBehavior(DefaultTransactionDefinition.PROPAGATION_REQUIRED);
        // 第三步: 获取事务状态对象
        TransactionStatus status = dtm.getTransaction(def);
        // 第四部: 创建数据库操作的 JDBC模板 对象，已通过属性注入 jdbcTemplate
        // 第五步: 执行业务sql
        try {
            String sql = "insert employee(`username`, `password`, `name`) values(?,?,?)";
            jdbcTemplate.update(sql, employee.getUsername(), employee.getPassword(), employee.getName());

            // 第六部: 提交事务
            dtm.commit(status);
        } catch (DataAccessException e) {
            // 事务回滚
            dtm.rollback(status);
            e.printStackTrace();
        }

         */
    }

    @Override
    public void update(Employee employee) {
        // 使用事务模板方式实现编程式事务
        // 第一步: 使用事务管理器对象来创建事务模板对象
        TransactionTemplate template = new TransactionTemplate(dtm);
        // 根据需求，设置相关属性
        // 定义事务传播行为
        template.setIsolationLevel(TransactionDefinition.ISOLATION_REPEATABLE_READ);
        // 第二步: 选择事务结果类型 ---> 重写execute方法实现事务管理
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    // 第三步: 执行业务sql
                    // 方式一: 使用 jdbcTemplate 对象
                    String sql = "UPDATE employee set username = ? WHERE uid = ?";
                    jdbcTemplate.update(sql, employee.getUsername(), employee.getUid());
                } catch (DataAccessException e) {
                    transactionStatus.setRollbackOnly();
                    e.printStackTrace();
                }
            }
        });

        /*
        // 使用事务管理器实现编程式事务
        // 第一步: 获取 JDBC 事务管理器，已通过属性注入 dtm
        // 第二步: 创建事务管理器属性对象 DefaultTransactionDefinition 是 TransactionDefinition 的实现类
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        // 根据需求，设置相关属性
        // 定义事务传播行为
        def.setPropagationBehavior(DefaultTransactionDefinition.PROPAGATION_REQUIRED);
        // 第三步: 获取事务状态对象
        TransactionStatus status = dtm.getTransaction(def);
        // 第四部: 创建数据库操作的 JDBC模板 对象，已通过属性注入 jdbcTemplate
        // 第五步: 执行业务sql
        try {
            String sql = "UPDATE employee set username = ? WHERE uid = ?";
            jdbcTemplate.update(sql, employee.getUsername(), employee.getUid());

            // 第六部: 提交事务
            dtm.commit(status);
        } catch (DataAccessException e) {
            // 事务回滚
            dtm.rollback(status);
            e.printStackTrace();
        }

         */
    }

    @Override
    public void delete(Integer uid) {
        // 第一步: 获取 JDBC 事务管理器，已通过属性注入 dtm
        // 第二步: 创建事务管理器属性对象 DefaultTransactionDefinition 是 TransactionDefinition 的实现类
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        // 根据需求，设置相关属性
        // 定义事务传播行为
        def.setPropagationBehavior(DefaultTransactionDefinition.PROPAGATION_REQUIRED);
        // 第三步: 获取事务状态对象
        TransactionStatus status = dtm.getTransaction(def);
        // 第四部: 创建数据库操作的 JDBC模板 对象，已通过属性注入 jdbcTemplate
        // 第五步: 执行业务sql
        try {
            String sql = "DELETE FROM employee WHERE uid = ?";
            jdbcTemplate.update(sql, uid);

            // 第六部: 提交事务
            dtm.commit(status);
        } catch (DataAccessException e) {
            // 事务回滚
            dtm.rollback(status);
            e.printStackTrace();
        }
    }

    @Override
    public Employee findByUid(Integer uid) {
        // 第一步: 获取 JDBC 事务管理器，已通过属性注入 dtm
        // 第二步: 创建事务管理器属性对象 DefaultTransactionDefinition 是 TransactionDefinition 的实现类
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        // 根据需求，设置相关属性
        // 定义事务传播行为
        def.setPropagationBehavior(DefaultTransactionDefinition.PROPAGATION_REQUIRED);
        // 第三步: 获取事务状态对象
        TransactionStatus status = dtm.getTransaction(def);
        // 第四部: 创建数据库操作的 JDBC模板 对象，已通过属性注入 jdbcTemplate
        // 第五步: 执行业务sql
//        Employee employee = null;
//        try {
//            String sql = "select * from employee where uid = ?";
        // queryForObject 若查询结果为空，会出错，可以用 query 或 queryForList 替代
//            employee = jdbcTemplate.queryForObject(sql, new EmployeeRowMapper(), uid);
//            // 第六部: 提交事务
//            dtm.commit(status);
//        } catch (EmptyResultDataAccessException e) {
//            // 事务回滚
//            dtm.rollback(status);
//            e.printStackTrace();
//        }


        List<Employee> list = null;
        Employee employee = new Employee();
        try {
            String sql = "select * from employee where uid = ?";
            list = jdbcTemplate.query(sql, new EmployeeRowMapper(), uid);

            dtm.commit(status);
        } catch (DataAccessException | TransactionException e) {
            // 事务回滚
            dtm.rollback(status);
            e.printStackTrace();
        }

        if (list.size() > 0) {
            Iterator it = list.iterator();
            if (it.hasNext()) {
                employee = (Employee) it.next();
            }
        }

        return employee;
    }

    @Override
    public List<Employee> findAll() {
        // 使用事务模板方式实现编程式事务
        // 第一步: 使用事务管理器对象来创建事务模板对象
        TransactionTemplate template = new TransactionTemplate(dtm);
        // 根据需求，设置相关属性
        // 定义事务传播行为
        template.setIsolationLevel(TransactionDefinition.ISOLATION_REPEATABLE_READ);
        // 第二步: 选择事务结果类型 ---> 重写execute方法实现事务管理
        List<Employee> employees = new ArrayList<>();

        try {
            @SuppressWarnings("unchecked")
            List<Map<String, Object>> list = (List<Map<String, Object>>) template.execute(new TransactionCallback<Object>() {
                @Override
                public Object doInTransaction(TransactionStatus transactionStatus) {
                    String sql = "select * from employee";
                    return jdbcTemplate.queryForList(sql);
                }
            });

            if (list.size() != 0) {
                for (Map<String, Object> m : list) {
                    Employee employee = new Employee();
                    employee.setUid((Integer) m.get("uid"));
                    employee.setUsername((String) m.get("username"));
                    employee.setPassword((String) m.get("password"));
                    employee.setName((String) m.get("name"));
                    employee.setCreateTime((Date) m.get("create_time"));
                    employees.add(employee);
                }
            }

        } catch (TransactionException e) {
            e.printStackTrace();
        }

        return employees;


       /*
        // 使用事务管理器实现编程式事务
        // 第一步: 获取 JDBC 事务管理器，已通过属性注入 dtm
        // 第二步: 创建事务管理器属性对象 DefaultTransactionDefinition 是 TransactionDefinition 的实现类
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        // 根据需求，设置相关属性
        // 定义事务传播行为
        def.setPropagationBehavior(DefaultTransactionDefinition.PROPAGATION_REQUIRED);
        // 第三步: 获取事务状态对象
        TransactionStatus status = dtm.getTransaction(def);
        // 第四部: 创建数据库操作的 JDBC模板 对象，已通过属性注入 jdbcTemplate
        // 第五步: 执行业务sql
        List<Employee> employees = null;
        try {
            String sql = "select * from employee";
            employees = jdbcTemplate.query(sql, new EmployeeRowMapper());
            // 第六部: 提交事务
            dtm.commit(status);
        } catch (DataAccessException e) {
            // 事务回滚
            dtm.rollback(status);
            e.printStackTrace();
        }

        return employees;
        */
    }

    private class EmployeeRowMapper implements RowMapper<Employee> {

        @Override
        public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
            Employee employee = null;
            if (resultSet.first()) {
                employee = new Employee();
                employee.setUid(resultSet.getInt("uid"));
                employee.setUsername(resultSet.getString("username"));
                employee.setPassword(resultSet.getString("password"));
                employee.setName(resultSet.getString("name"));
                employee.setCreateTime(resultSet.getTimestamp("create_time"));
            }

            return employee;
        }
    }
}
