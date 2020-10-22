package com.information.controller;

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
 * Date: 2020-10-22  21:36
 * Description:
 * 取消收藏
 */
@WebServlet("/cancle")
public class CancleCollectController extends HttpServlet {
    private CollectServiceImpl service = new CollectServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fruitname = req.getParameter("fruitname");//水果id
        String username = req.getParameter("username");//用户名
        ResponseEntity<String> responseEntity = new ResponseEntity<>();
        if (service.canclecollectFruits(username,fruitname)) {
            //收藏成功
            responseEntity.setCode("200");
            responseEntity.setMessage("取消收藏成功");
            resp.getWriter().println(responseEntity);
        }else {
            responseEntity.setCode("404");
            responseEntity.setMessage("取消收藏失败");
            resp.getWriter().println(responseEntity);
        }
    }
}
