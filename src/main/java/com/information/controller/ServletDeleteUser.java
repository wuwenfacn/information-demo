package com.information.controller;

import com.information.service.user.userImpl.DelUserImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*删除用户*/
@WebServlet("/ServletDeleteUser")
public class ServletDeleteUser extends HttpServlet {
    DelUserImpl delUser=new DelUserImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        String name = request.getParameter("name");
        delUser.DelUser(name);
        response.setStatus(200);
        response.getWriter().print("删除成功");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
