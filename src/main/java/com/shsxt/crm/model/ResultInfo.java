package com.shsxt.crm.model;

public class ResultInfo {
    private String msg="操作成功";
    private Integer code=200;
    private Object result;

    public ResultInfo() {
    }

    public ResultInfo(String msg, Integer code, Object result) {
        this.msg = msg;
        this.code = code;
        this.result = result;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
