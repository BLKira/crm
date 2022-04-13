package com.ava.crm.workbench.web.controller;

import com.ava.crm.settings.domain.User;
import com.ava.crm.settings.service.UserService;
import com.ava.crm.settings.service.impl.UserServiceImpl;
import com.ava.crm.utils.DateTimeUtil;
import com.ava.crm.utils.PrintJson;
import com.ava.crm.utils.ServiceFactory;
import com.ava.crm.utils.UUIDUtil;
import com.ava.crm.workbench.domain.Activity;
import com.ava.crm.workbench.service.ActivityService;
import com.ava.crm.workbench.service.impl.ActivityServiceImpl;

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
        } else if ("/workbench/activity/save.do".equals(path)) {
            save(request, response);
        }

    }

    private void save(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("执行市场活动添加操作");
        String id = UUIDUtil.getUUID();
        String owner = request.getParameter("owner");
        String name = request.getParameter("name");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String cost = request.getParameter("cost");
        String description = request.getParameter("description");
//        创建时间，当前系统时间
        String createTime = DateTimeUtil.getSysTime();
//        创建人，当前登录用户
        String createBy = ((User) request.getSession().getAttribute("user")).getName();

        Activity activity = new Activity();
        activity.setId(id);
        activity.setOwner(owner);
        activity.setName(name);
        activity.setStartDate(startDate);
        activity.setEndDate(endDate);
        activity.setCost(cost);
        activity.setDescription(description);
        activity.setCreateTime(createTime);
        activity.setCreateBy(createBy);


        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());

        boolean flag = as.save(activity);
        PrintJson.printJsonFlag(response, flag);
    }

    private void getUserList(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("取得用户信息列表");

        UserService userService = (UserService) ServiceFactory.getService(new UserServiceImpl());

        List<User> uList = userService.getUserList();
        PrintJson.printJsonObj(response, uList);


    }

}
