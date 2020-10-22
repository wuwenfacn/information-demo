package com.information.service.impl;

import com.information.dao.impl.UserDaoImpl;
import com.information.entity.Details;
import com.information.entity.Navbar;
import com.information.service.ListService;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author qiaoshu
 * @JDK 1.8
 * Date: 2020-10-20  14:25
 * Description:
 */
public class ListServiceImpl implements ListService {
    private UserDaoImpl dao = new UserDaoImpl();

    /**
     * 根据水果种类获取相应的全部水果的详情
     * @param navbar 传入标题
     * @return  返回存 Deatils 的 List
     */
    @Override
    public List listInformations(String navbar,int i) {
        //从数据库取出水果标题和详情
        /*List list = dao.getList(navbar, i);*/
        List<Details> list = dao.getList(navbar,i);
        return list;
    }

    /**
     * 获得所有水果类型的标题
     * @return 返回 List
     */
    @Override
    public List<Navbar> listNavbar() {
        //取出标题
        List navbar = dao.getNavbar();
        return navbar;
    }
}
