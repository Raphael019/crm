package com.shsxt.crm.interceptors;

import com.shsxt.crm.annotations.RequestPermission;
import com.shsxt.crm.service.UserService;
import com.shsxt.crm.utils.AssertUtil;
import com.shsxt.crm.utils.LoginUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 非法登录拦截
 *  当用户没有登录时，禁止用户访问网站某些内容
 *
 *  放开注册，登录请求
 *
 * */
public class Interceptor01 implements HandlerInterceptor {
    @Autowired
    private UserService userService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /***
         * 登陆状态判断
         * 1. 通过Request获取cookie中的id
         * 2. 通过id查询用户是否存在
         * */

        Integer userId = LoginUserUtil.releaseUserIdFromCookie(request);
        AssertUtil.isNotLogin(null==userId||null==userService.queryById(userId),"用户不存在或未登录");
    System.out.println(handler+"9999999999999999999999999999999999999999999");
        if (handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            RequestPermission annotation = method.getAnnotation(RequestPermission.class);
            System.out.println("-------------------------------------------------------------------------------");
            if (annotation != null){
                String s = annotation.aclValue();
                System.out.println(s);
                if (s.equals("10")){
                    System.out.println("1000000000000000000000000000000000000000000000000000000000000000000000000000");
                }
            }else{
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++-----------------------------------------");
            }

        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
