package com.shsxt.crm.dao;

import com.shsxt.crm.base.BaseDao;
import com.shsxt.crm.dto.UserDto;
import com.shsxt.crm.po.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseDao<UserDto> {

    /**
     * 根据用户名查询
     * @param userName
     * @return
     */
    public User queryUserByName(String userName);

    public Integer updateUserPwd(@Param("userPwd") String newUserPwd, @Param("id") Integer id);

}