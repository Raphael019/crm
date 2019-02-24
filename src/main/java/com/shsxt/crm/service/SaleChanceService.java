package com.shsxt.crm.service;

import com.shsxt.crm.base.BaseService;
import com.shsxt.crm.dao.SaleChanceMapper;
import com.shsxt.crm.dao.UserMapper;
import com.shsxt.crm.po.SaleChance;
import com.shsxt.crm.po.User;
import com.shsxt.crm.utils.AssertUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SaleChanceService extends BaseService<SaleChance> {

    @Autowired
    private SaleChanceMapper saleChanceMapper;
    @Autowired
    private UserMapper userMapper;

    public void InsertOrUpdateSaleChance(SaleChance saleChance,Integer userId){

        //前台参数校验
        AssertUtil.isTrue(StringUtils.isBlank(saleChance.getChanceSource()),"消息来源为空");
        AssertUtil.isTrue(StringUtils.isBlank(saleChance.getCustomerName()),"客户名称为空");
        AssertUtil.isTrue(null ==(saleChance.getCgjl()),"成功几率为空");
        AssertUtil.isTrue(StringUtils.isBlank(saleChance.getLinkMan()),"联系人为空");
        AssertUtil.isTrue(StringUtils.isBlank(saleChance.getLinkPhone()),"联系电话为空");
        AssertUtil.isTrue(StringUtils.isBlank(saleChance.getDescription()),"描述信息为空");
        AssertUtil.isTrue(StringUtils.isBlank(saleChance.getAssignMan()),"分配人为空");

        //参数补全
        User user = userMapper.queryById(userId);
        AssertUtil.isTrue(null==user,"当前用户信息存在风险");
        saleChance.setCreateMan(user.getUserName());// 创建人
        saleChance.setState(0);// 0 未分配 1 已分配
        saleChance.setDevResult(0);// 0 未开发
        saleChance.setIsValid(1);// 0 无效 1 有效
        saleChance.setCreateDate(new Date());// 创建时间
        saleChance.setUpdateDate(new Date());// 更新时间

        //数据插入操作
        AssertUtil.isTrue(saleChanceMapper.insert(saleChance)<1,"营销机会添加失败");

    }
}
