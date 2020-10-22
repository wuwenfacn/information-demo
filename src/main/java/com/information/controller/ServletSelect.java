package com.information.controller;

import com.alibaba.fastjson.JSONObject;
import com.information.entity.Details;
import com.information.service.manager.Impl.SelectShop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.io.IOException;
import java.io.PrintWriter;

/*查询水果信息*/
@WebServlet("/ServletSelect")
public class ServletSelect extends HttpServlet {
    SelectShop se=new SelectShop();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
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
}
