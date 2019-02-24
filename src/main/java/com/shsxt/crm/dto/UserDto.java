package com.shsxt.crm.dto;

import com.shsxt.crm.po.User;

import java.util.ArrayList;
import java.util.List;

public class UserDto extends User {
    private String roleName;

    private String roleIdStr;// 角色id的拼接字符串 15,2,3

    private List<Integer> roleIds = new ArrayList<>();

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleIdStr() {
        return roleIdStr;
    }

    public void setRoleIdStr(String roleIdStr) {
        this.roleIdStr = roleIdStr;
    }

    public List<Integer> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Integer> roleIds) {
        this.roleIds = roleIds;
    }



    //递归
    public static int test(int i){
        if(i == 0){
            return 1;

        }
        return i * test(i-1); //递归条件变化在参数上
    }

    public static void main(String[] args) {
        System.out.println(UserDto.test(4));
    }
}
