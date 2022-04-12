package com.ava.crm.settings.web.controller;

import com.ava.crm.settings.domain.User;
import com.ava.crm.settings.service.UserService;
import com.ava.crm.settings.service.impl.UserServiceImpl;
import com.ava.crm.utils.MD5Util;
import com.ava.crm.utils.PrintJson;
import com.ava.crm.utils.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入到用户控制器");

        String path = request.getServletPath();

        if ("/settings/user/login.do".equals(path)) {
            login(request, response);
        } else if ("/settings/user/xxx.do".equals(path)) {

        }

    }

    private void login(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("进入到登录");

        String loginAct = request.getParameter("loginAct");
        String loginPwd = request.getParameter("loginPwd");
//        将密码的明文形式转化为MD5的密文形式
        loginPwd = MD5Util.getMD5(loginPwd);
//        接受浏览器端ip地址
        String ip = request.getRemoteAddr();

        UserService userService = (UserService) ServiceFactory.getService(new UserServiceImpl());

        try {
            User user = userService.login(loginAct, loginPwd, ip);
            request.getSession().setAttribute("user", user);
//        如果程序运行到此处，说明业务层没有为controller抛出任何异常
//            表示登陆成功
            PrintJson.printJsonFlag(response,true);
        } catch (Exception e) {
            e.printStackTrace();
//            一旦程序执行了catch块的信息，说明业务层为我们验证登录失败
            String msg = e.getMessage();
//            作为controller，需要为ajax提供多项目信息
//            两种手段
//                  将多项信息打包成map，将map解析成json串
//                  创建一个Vo
//            如果对于展现的信息将来还会大量的使用，创建一个Vo类，使用方便
//            如果对于展现的信息只有在这个需求中能够使用，创建map即可
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("success",false);
            map.put("msg",msg);
            PrintJson.printJsonObj(response,map);

        }
    }
}
