package com.shsxt.crm.controller;

import com.shsxt.crm.annotations.RequestPermission;
import com.shsxt.crm.base.BaseController;

import com.shsxt.crm.model.ResultInfo;
import com.shsxt.crm.po.SaleChance;
import com.shsxt.crm.querypo.querySaleChance;
import com.shsxt.crm.service.SaleChanceService;;
import com.shsxt.crm.utils.LoginUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("saleChance")
public class SaleChanceController extends BaseController {

    @Autowired
    private SaleChanceService saleChanceService;

    @RequestMapping("index")
    public String index(){
        return "sale_chance";
    }


    @RequestPermission(aclValue = "10")
    @RequestMapping("querySaleChancesByParams")
    @ResponseBody
    public Map<String, Object> querySaleChanceByParams(@RequestParam(defaultValue = "1") Integer page,
                                                       @RequestParam(defaultValue = "10") Integer rows ,
                                                       querySaleChance saleChance){
        saleChance.setPageNum(page);
        saleChance.setPageSize(rows);
        System.out.println("*****************************************************************");
        return saleChanceService.queryForPage(saleChance);
    }


    @RequestMapping("InsertOrUpdateSaleChance")
    @ResponseBody
    public ResultInfo InsertOrUpdateSaleChance(SaleChance saleChance, HttpServletRequest request){
        ResultInfo resultInfo = new ResultInfo();
        Integer userId = LoginUserUtil.releaseUserIdFromCookie(request);
        saleChanceService.InsertOrUpdateSaleChance(saleChance,userId);
        return success(200,"营销机会添加成功");
    }


}
