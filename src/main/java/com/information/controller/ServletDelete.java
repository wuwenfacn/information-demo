package com.information.controller;

import com.alibaba.fastjson.JSONObject;
import com.information.service.manager.Impl.DeleteShop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*删除水果信息*/
@WebServlet("/ServletDelete")
public class ServletDelete extends HttpServlet {
    DeleteShop del= new DeleteShop();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        //获取名字
        String name = request.getParameter("name");
        //执行删除
        boolean delete = del.delete(name);
        response.setStatus(200);
        response.setContentType("applicetion/text;charset=utf-8");
        response.getWriter().println("删除成功");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
