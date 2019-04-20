package com.csthink.entity;

import java.util.Date;

public class Employee2 {

    private Integer id;

    private String username;

    private Integer deptId;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Employee2{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", deptId=" + deptId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
