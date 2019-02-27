package com.shsxt.crm.service;

import com.shsxt.crm.dao.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RoleService {
    @Autowired
    private RoleMapper roleMapper;

    public List<Map> queryAllRoles(){
        return roleMapper.queryAllRoles();
    }


    public static void main(String[] args) {

    }
}
