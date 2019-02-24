package com.shsxt.crm.controller;


import com.shsxt.crm.base.BaseController;
import com.shsxt.crm.model.ResultInfo;
import com.shsxt.crm.model.UserInfo;
import com.shsxt.crm.querypo.queryUser;
import com.shsxt.crm.service.UserService;
import com.shsxt.crm.utils.LoginUserUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController extends BaseController {
    @Resource
    private UserService userService;

    @RequestMapping("login")
    @ResponseBody
    public ResultInfo Login(String userName, String userPwd){

        UserInfo userInfo = userService.queryUserByName(userName, userPwd);
        return success(200,"登录成功",userInfo);

    }

    @RequestMapping("updateUserPwd")
    @ResponseBody
    public ResultInfo updateUserPwd(String oldPassword, String newPassword, String confirmPassword, HttpServletRequest request){

        Integer id = LoginUserUtil.releaseUserIdFromCookie(request);
        userService.updateUserPwd(oldPassword,newPassword,confirmPassword,id);
        return success(200,"密码修改成功");

    }
    @RequestMapping("index")
    public String index(){
        return "user";
    }

    @RequestMapping("queryUsersByParams")
    @ResponseBody
    public Map<String,Object> queryUsersByParams(@RequestParam(defaultValue = "1") Integer page,
                                                 @RequestParam(defaultValue = "10")Integer rows,
                                                 queryUser queryUser){
        queryUser.setPageNum(page);
        queryUser.setPageSize(rows);
        return userService.queryForPage(queryUser);

    }

}
