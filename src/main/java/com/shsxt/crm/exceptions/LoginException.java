package com.shsxt.crm.exceptions;

public class LoginException extends RuntimeException {
    private String msg = "用户未登录,请登录";
    private Integer code = 301;

    public LoginException(String msg, Integer code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }
    public LoginException(String msg) {
        this.msg = msg;
    }

    public LoginException(Integer code) {
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
