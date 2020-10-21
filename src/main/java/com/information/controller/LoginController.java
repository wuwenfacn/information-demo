package com.information.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.information.entity.User;
import com.information.service.LoginService;
import com.information.service.impl.LoginServiceImpl;
import com.information.utils.ResponseEntity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author qiaoshu
 * @JDK 1.8
 * Date: 2020-10-19  15:38
 * Description:
 *          处理登录请求
 *          验证码,账号,密码,登录类型
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
    private LoginService service = new LoginServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        BufferedReader br = null;
        StringBuilder sb = null;
        try {
            br = new BufferedReader(new InputStreamReader(req.getInputStream()));
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
        User user;
        //Json字符串变成Json对象
        JSONObject jsonObject = JSONObject.parseObject(String.valueOf(sb));
        //Json对象变成java对象
        user = JSONObject.toJavaObject(jsonObject,User.class);
        ResponseEntity responseEntity = new ResponseEntity();
        if(service.checkUser(user)){
            //登录成功
            responseEntity.setCode("200");
            responseEntity.setMessage("登录成功!");
            resp.getWriter().println(JSON.toJSONString(responseEntity));
        }else{
            //登录失败
            responseEntity.setCode("404");
            responseEntity.setMessage("账号或密码失败!请再试");
            resp.getWriter().println(JSON.toJSONString(responseEntity));
        }
    }
}