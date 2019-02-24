package com.shsxt.crm.exceptions;

import com.alibaba.fastjson.JSON;
import com.shsxt.crm.model.ResultInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

@Component
public class GlobleExceptionResolve implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        /*基本的异常处理*/
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error");
        mv.addObject("errorMsg",ex.getMessage());
        mv.addObject("ctx",request.getContextPath());
        mv.addObject("uri",request.getRequestURI());

        /*非法登录拦截异常处理*/
        if (ex instanceof LoginException){
            LoginException loginException = (LoginException) ex;
            mv.addObject("errorMsg",loginException.getMsg());
            return mv;
        }

        /*区分是页面跳转异常请求 还是 返回json异常请求 */

        if(handler instanceof HandlerMethod){  //判断目标方法是否属于该框架   handler 一般是整个项目的所有方法
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            ResponseBody responseBody = method.getAnnotation(ResponseBody.class);

            if(responseBody == null){
                /*如果responseBody == null 说明返回的不是json*/
                if(ex instanceof ParamException){
                    ParamException e = (ParamException) ex;
                    mv.addObject("errorMsg", e.getMsg());  /*修改返回错误信息*/  /*重新定义返回的错误信息*/
                }
            }else {
                /*如果 responseBody ！= null 返回的 json */
                ResultInfo resultInfo = new ResultInfo();
                resultInfo.setCode(300);
                resultInfo.setMsg(ex.getMessage());

                /*参数异常*/
                if (ex instanceof ParamException){
                    ParamException p = (ParamException) ex;
                    resultInfo.setMsg(p.getMsg());
                }

                /*设置响应字符编码格式*/
                response.setCharacterEncoding("utf-8");
                response.setContentType("application/json;charset=utf-8");

                PrintWriter pw = null;
                try {
                    pw = response.getWriter();
                    pw.write(JSON.toJSONString(resultInfo));
                    pw.flush();
                    pw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (null != pw) {
                        pw.close();
                    }
                }

            }
        }

        return mv;
    }
}
