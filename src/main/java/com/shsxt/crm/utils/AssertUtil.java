package com.shsxt.crm.utils;


import com.shsxt.crm.exceptions.LoginException;
import com.shsxt.crm.exceptions.ParamException;


/**
 * Created by lp on 2018/1/3.
 */
public class AssertUtil {

    public  static void isTrue(Boolean flag,String msg){
        if(flag){
            throw new ParamException(msg);
        }
    }

    public static  void isTrue(Boolean flag,String msg,Integer code){
        if(flag){
            throw new ParamException(msg,code);
        }
    }

    public  static void isNotLogin(Boolean flag,String msg){
        if(flag){
            throw new LoginException(msg);
        }
    }

    public static  void isNotLogin(Boolean flag,String msg,Integer code){
        if(flag){
            throw new LoginException(msg,code);
        }
    }

}
