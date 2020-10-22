package com.information.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.information.entity.UserCollections;
import com.information.service.impl.CollectServiceImpl;
import com.information.utils.ResponseEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author qiaoshu
 * @since JDK 1.8
 * Date: 2020-10-22  10:10
 * Description:
 *      添加收藏功能
 */
@WebServlet("/collect")
public class CollectController extends HttpServlet {
    private CollectServiceImpl service = new CollectServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        ResponseEntity responseEntity = new ResponseEntity();
        String name = req.getParameter("name");//水果id
        UserCollections userCollections = JSONObject.parseObject(name, UserCollections.class);
        String username = userCollections.getUsername();
        String namese = userCollections.getNamese();
        if (service.collectFruits(username,namese)) {
            //收藏成功
            responseEntity.setCode("200");
            responseEntity.setMessage("收藏成功");
            responseEntity.setData("你收藏了商品:"+namese);
            resp.getWriter().println(JSON.toJSONString(responseEntity));
        }else {
            responseEntity.setCode("400");
            responseEntity.setMessage("收藏失败");
            resp.getWriter().println(JSON.toJSONString(responseEntity));
        }
    }
}
