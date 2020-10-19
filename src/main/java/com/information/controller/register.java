package com.information.controller;

import com.alibaba.fastjson.JSONObject;
import com.information.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@WebServlet("/register")
public class register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=UTF-8");
        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        User user = new User();
        //Json字符串变成Json对象
        JSONObject jsonObject = JSONObject.parseObject(String.valueOf(sb));
        System.out.println(jsonObject);//json对象
        //Json对象变成java对象
        user = (User)JSONObject.toJavaObject(jsonObject,User.class);
    }
}
