package com.ava.crm.workbench.web.controller;

import com.ava.crm.settings.domain.User;
import com.ava.crm.settings.service.UserService;
import com.ava.crm.settings.service.impl.UserServiceImpl;
import com.ava.crm.utils.PrintJson;
import com.ava.crm.utils.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ActivityController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入到市场活动控制器");

        String path = request.getServletPath();

        if ("/workbench/activity/getUserList.do".equals(path)) {
            getUserList(request, response);
        } else if ("/workbench/activity/xxx.do".equals(path)) {

        }

    }

    private void getUserList(HttpServletRequest request, HttpServletResponse response) {
//        System.out.println("取得用户信息列表");
//
//        UserService userService = (UserService) ServiceFactory.getService(new UserServiceImpl());
//
//        List<User> uList =  userService.getUserList();
//        PrintJson.printJsonObj(response,uList);


    }

}
