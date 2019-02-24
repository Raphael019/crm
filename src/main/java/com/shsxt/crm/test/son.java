package com.shsxt.crm.test;

public class son extends father {
    public Integer age = 20;
    public son() {
        super();

    }

    {
        System.out.println("构造块");
    }
    public void test(){

        int i = 0;
        super.driver();
        {
           System.out.println("普通代码块");
        }
    }

    static{
        System.out.println("静态代码块");
    }


    public static void main(String[] args) {

        father f  = new son();
        ((son) f).test();
        ((son) f).age = 20;
    }
}
