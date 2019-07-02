package com.core.entity;

import java.util.Date;

/**
 * @Author:chengxiaonan
 * @Date:2019/7/2
 */
public class Category {
    private int id;
    private int rownum;
    private String chiName;
    private String status;
    private Date createDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRownum() {
        return rownum;
    }

    public void setRownum(int rownum) {
        this.rownum = rownum;
    }

    public String getChiName() {
        return chiName;
    }

    public void setChiName(String chiName) {
        this.chiName = chiName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
