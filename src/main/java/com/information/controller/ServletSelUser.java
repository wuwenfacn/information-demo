package com.information.controller;

import com.alibaba.fastjson.JSONObject;
import com.information.entity.User;
import com.information.service.user.userImpl.SelUserImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*查询用户信息*/
@WebServlet("/ServletSelUser")
public class ServletSelUser extends HttpServlet {
    SelUserImpl selectUser=new SelUserImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //获取对象
        String username = request.getParameter("kw");
        //返回实体对象
        User user = selectUser.selectUser(username);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        //响应前端
        response.getWriter().print(JSONObject.toJSONString(user));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
