package com.example.sys.DO;

import com.example.sys.entity.SysUser;

import java.util.Date;

public class SysUserDO extends SysUser {

    private Date beginCreateDate;

    private Date endCreateDate;

    public Date getBeginCreateDate() {
        return beginCreateDate;
    }

    public void setBeginCreateDate(Date beginCreateDate) {
        this.beginCreateDate = beginCreateDate;
    }

    public Date getEndCreateDate() {
        return endCreateDate;
    }

    public void setEndCreateDate(Date endCreateDate) {
        this.endCreateDate = endCreateDate;
    }
}
