package com.information.service.impl;

import com.information.dao.impl.UserDaoImpl;
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
    @Override
    public List listInformations(String navbar) {
        //从数据库取出水果标题和详情
        List list = dao.getList(navbar);
        return list;
    }

    @Override
    public List<Navbar> listNavbar() {
        //取出标题
        List navbar = dao.getNavbar();
        return navbar;
    }
}
