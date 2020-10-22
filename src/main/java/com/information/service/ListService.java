package com.information.service;

import com.information.entity.Details;
import com.information.entity.Navbar;

import java.sql.ResultSet;
import java.util.List;

/**
 * @Author qiaoshu
 * @JDK 1.8
 * Date: 2020-10-20  14:25
 * Description:
 */
public interface ListService {

    //根据类型（热带、亚热带、温带）获取水果信息
    List<Details> listInformations(String navbar,int i);

    //获取水果类型（热带、亚热带、温带）
    List<Navbar> listNavbar();
}
