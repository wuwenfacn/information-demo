package com.information.controller;

import com.alibaba.fastjson.JSONObject;
import com.information.dao.shop_impl.AddShopImpl;
import com.information.entity.Details;
import com.information.entity.User;
import com.information.service.manager.Impl.AddShop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*添加水果信息*/
@WebServlet("/ServletAdd")
public class ServletAdd extends HttpServlet {
    AddShop addShop = new AddShop();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        String shop = request.getParameter("shop");
        Details details = JSONObject.parseObject(shop, Details.class);
        boolean flag = addShop.add(details);
        if (flag){
            response.setStatus(200);
            response.setContentType("application/text;charset");
            response.getWriter().println("添加成功");
        }else{
            response.setStatus(400);
            response.getWriter().println("添加失败");
        }
    }
}
