package com.shsxt.crm.querypo;

import com.shsxt.crm.base.BaseQuery;


public class querySaleChance extends BaseQuery {

    private String customerName;
    private Integer state;
    private Integer devResult;
    private String createDate;

    public querySaleChance() {
    }

    public querySaleChance(String customerName, Integer state, Integer devResult, String createDate) {
        this.customerName = customerName;
        this.state = state;
        this.devResult = devResult;
        this.createDate = createDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getDevResult() {
        return devResult;
    }

    public void setDevResult(Integer devResult) {
        this.devResult = devResult;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
