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
import java.util.List;

/**
 * @Author qiaoshu
 * @since JDK 1.8
 * Date: 2020-10-22  16:14
 * Description:
 *      展示用户所有的收藏
 */
@WebServlet("/collections")
public class CollectionCarController extends HttpServlet {
    private CollectServiceImpl service = new CollectServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        ResponseEntity responseEntity = new ResponseEntity();
        String name = req.getParameter("name");
        UserCollections userCollections = JSONObject.parseObject(name, UserCollections.class);
        String username = userCollections.getUsername();
        List<UserCollections> list = service.showCollections(username);
        //数据库获取到的信息
        if (list!=null){
            //把数据返回前端
            responseEntity.setCode("200");
            responseEntity.setMessage("获取收藏夹成功!");
            responseEntity.setData(list);
            resp.getWriter().println(JSON.toJSONString(responseEntity));

        }else{
            //网络繁忙
            responseEntity.setCode("404");
            responseEntity.setMessage("网络繁忙,获取收藏失败");
            resp.getWriter().println(JSON.toJSONString(responseEntity));
        }
    }
}
