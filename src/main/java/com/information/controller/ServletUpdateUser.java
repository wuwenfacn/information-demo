package com.information.controller;

import com.alibaba.fastjson.JSONObject;
import com.information.entity.Details;
import com.information.entity.User;
import com.information.service.user.userImpl.UpUserImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*修改用户信息*/
@WebServlet( "/ServletUpdateUser")
public class ServletUpdateUser extends HttpServlet {
    UpUserImpl update=new UpUserImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        //获取字符串
        String user = request.getParameter("user");
        /*映射*/
        User newUser = JSONObject.parseObject(user, User.class);
        /*执行更新*/
        update.updateUser(newUser);
        response.setStatus(200);
        response.getWriter().print("更新成功");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
