package com.shsxt.crm.exceptions;

public class ParamException extends RuntimeException {
    private String msg = "操作失败";
    private Integer code = 300;

    public ParamException(String msg, Integer code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public ParamException( String msg) {
        this.msg = msg;
    }

    public ParamException(Integer code) {
        this.code = code;
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
}
