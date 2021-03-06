package com.information.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.information.entity.User;
import com.information.service.RegisterService;
import com.information.service.impl.RegisterServiceImpl;
import com.information.utils.ResponseEntity;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author qiaoshu
 * @JDK 1.8
 * Date: 2020-10-19  15:26
 * Description:
 *      处理注册请求
 *      账号,密码,验证码,注册类型
 */

@WebServlet("/register")
public class RegisterController extends HttpServlet{
    private RegisterServiceImpl service = new RegisterServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        BufferedReader br = null;
        StringBuilder sb = null;
        try {
            br = new BufferedReader(new InputStreamReader((ServletInputStream) req.getInputStream()));
            String line = null;
            sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        }catch (Exception e){
            System.out.println("输入流异常");
        }finally {
            br.close();
        }
        User user = new User();
        //Json字符串变成Json对象
        JSONObject jsonObject = JSONObject.parseObject(String.valueOf(sb));
        //Json对象变成java对象
        user = JSONObject.toJavaObject(jsonObject,User.class);
        ResponseEntity responseEntity = new ResponseEntity();
        if(service.checkUsername(user.getUsername())){
            //登录成功
            responseEntity.setCode("200");
            responseEntity.setMessage("注册成功!");
            resp.getWriter().println(JSON.toJSONString(responseEntity));
            service.insertUser(user);
        }else{//登录失败
            responseEntity.setCode("404");
            responseEntity.setMessage("用户名已存在,请换一个再试");
            resp.getWriter().println(JSON.toJSONString(responseEntity));
        }

    }
}
