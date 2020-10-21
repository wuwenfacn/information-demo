package com.information.controller;

import com.alibaba.fastjson.JSON;
import com.information.service.impl.ListServiceImpl;
import com.information.utils.ResponseEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @Author qiaoshu
 * @JDK 1.8
 * Date: 2020-10-20  14:16
 * Description:
 *      展示产品的分类和详情信息
 */
@WebServlet("/tropic")
public class TropicController extends HttpServlet {
    private ListServiceImpl service = new ListServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        //数据库获取到的信息
        List list = service.listInformations("tropic");
        ResponseEntity<List> responseEntity = new ResponseEntity<>();
        if (list!=null){
            //把数据返回前端
            responseEntity.setCode("200");
            responseEntity.setMessage("获取热带水果成功!");
            responseEntity.setData(list);
            resp.getWriter().println(JSON.toJSONString(responseEntity));
        }else{
            //网络繁忙
            responseEntity.setCode("404");
            responseEntity.setMessage("网络繁忙,没获取到数据");
            resp.getWriter().println(JSON.toJSONString(responseEntity));
        }
    }
}
