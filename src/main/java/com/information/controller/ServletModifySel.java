package com.information.controller;

import com.alibaba.fastjson.JSONObject;
import com.information.entity.Details;
import com.information.service.manager.Impl.SelectShop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*查询水果信息*/
@WebServlet("/ServletModifySel")
public class ServletModifySel extends HttpServlet {
    SelectShop se=new SelectShop();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        //获取结果
        String kw = request.getParameter("kw");
        Details details = se.select(kw);
        response.setStatus(200);
        response.getWriter().print(JSONObject.toJSONString(details));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
