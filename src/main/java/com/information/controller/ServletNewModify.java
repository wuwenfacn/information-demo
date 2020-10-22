package com.information.controller;

import com.alibaba.fastjson.JSONObject;
import com.information.entity.Details;
import com.information.service.manager.Impl.ModifuServiceImpl;
import com.information.service.manager.ModifyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletNewModify")
/*
* 修改用户信息
* */
public class ServletNewModify extends HttpServlet {

    ModifyService modifyService=new ModifuServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        String shop = request.getParameter("shop");
        Details details = JSONObject.parseObject(shop, Details.class);
        modifyService.modify(details);
        response.setStatus(200);
        response.setContentType("application/text;charset");
        response.getWriter().println("修改成功");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
