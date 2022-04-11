package com.ava.settings.test;

import com.ava.crm.utils.DateTimeUtil;
import com.ava.crm.utils.MD5Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test1 {
    public static void main(String[] args) {

//        失效时间
//        String expireTime = "2022-4-10 10:10:10";
////当前系统时间
//        String currentTime = DateTimeUtil.getSysTime();
//
//        System.out.println(currentTime);
//        int count = expireTime.compareTo(currentTime);
//
//        System.out.println(count);

//        String lockState ="1";
//        if ("0".equals(lockState)) {
//            System.out.println("锁定");
//        }

//        浏览器ip地址
//        String ip = "192.168.200.1";
////允许访问的ip地址群
//        String allowIps = "192.168.1.1，192.168.200.1";
//
//        if (allowIps.contains(ip)) {
//            System.out.println("包含");
//        }

        String pwd = "123";
        String md5pwd = MD5Util.getMD5(pwd);
        System.out.println(md5pwd);

    }
}
