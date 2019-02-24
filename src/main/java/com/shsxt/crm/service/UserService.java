package com.shsxt.crm.service;


import com.shsxt.crm.base.BaseService;
import com.shsxt.crm.dao.UserMapper;
import com.shsxt.crm.dto.UserDto;
import com.shsxt.crm.model.UserInfo;
import com.shsxt.crm.po.User;
import com.shsxt.crm.querypo.queryUser;
import com.shsxt.crm.utils.AssertUtil;
import com.shsxt.crm.utils.Md5Util;
import com.shsxt.crm.utils.UserIDBase64;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService extends BaseService<UserDto> {
    @Autowired
    private UserMapper userMapper;


    /*
        参数非空校验 同时校验两次密码是否一致
        旧密码是否正确校验  ==>加密校验
        修改密码

     */
    public void updateUserPwd(String oldPassword, String newPassword, String confirmPassword, Integer userId) {
        /*参数校验*/
        checkparam(oldPassword,newPassword,confirmPassword);

        User user = userMapper.queryById(userId);
        System.out.println(userId+"================================================");
        AssertUtil.isTrue(null == user,"用户不存在或已注销");

        String encodeOldPwd = Md5Util.encode(oldPassword);
        AssertUtil.isTrue(!encodeOldPwd.equals(user.getUserPwd()),"旧密码不正确");

        String encodeNewPwd = Md5Util.encode(newPassword);
        userMapper.updateUserPwd(encodeNewPwd,userId);


    }

    private void checkparam(String oldPassword, String newPassword, String confirmPassword) {
        AssertUtil.isTrue(StringUtils.isBlank(oldPassword),"旧密码为空");
        AssertUtil.isTrue(StringUtils.isBlank(newPassword),"新密码为空");
        AssertUtil.isTrue(!newPassword.equals(confirmPassword),"两次密码不一致"); //注意 !null 会报空指针异常



    }


    /**
     * 用户登录操作
     * @param userName
     * @param userPwd
     * @return
     */
    public UserInfo queryUserByName(String userName, String userPwd){

        AssertUtil.isTrue(StringUtils.isBlank(userName),"用户名为空");
        AssertUtil.isTrue(StringUtils.isBlank(userPwd),"密码为空");

        User user = userMapper.queryUserByName(userName);
        AssertUtil.isTrue(null==user,"用户不存在或已注销");

        AssertUtil.isTrue(!Md5Util.encode(userPwd).equals(user.getUserPwd()),"用户名或密码不正确");

        UserInfo userInfo = new UserInfo();
        userInfo.setRealName(user.getTrueName());
        userInfo.setUserIdStr(UserIDBase64.encoderUserID(user.getId()));
        userInfo.setUserName(user.getUserName());

        return userInfo;
    }



}
