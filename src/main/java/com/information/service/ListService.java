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

    List<Details> listInformations(String navbar);

    List<Navbar> listNavbar();
}
