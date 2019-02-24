package com.shsxt.crm.base;


import com.shsxt.crm.model.ResultInfo;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
    @ModelAttribute
    public void PreMethod(HttpServletRequest request){
        request.setAttribute("ctx",request.getContextPath());
    }

    public ResultInfo success(Integer code, String msg,Object result){
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setResult(result);
        resultInfo.setMsg(msg);
        resultInfo.setCode(code);
        return resultInfo;
    }
    public ResultInfo success(Integer code,String msg){
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setMsg(msg);
        resultInfo.setCode(code);
        return resultInfo;
    }
    public ResultInfo success(String msg, Object result){
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setResult(result);
        resultInfo.setMsg(msg);
        return resultInfo;
    }

    public ResultInfo success(Integer code, Object result){
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setResult(result);
        resultInfo.setCode(code);
        return resultInfo;
    }

}
