package com.information.dao;

import com.information.entity.Details;
import com.information.entity.Navbar;
import com.information.entity.User;

import java.sql.ResultSet;
import java.util.List;

public interface UserDao {
    //添加用户
    int insertUser(User user);

    //update用户
    int updateUser(int id, User user);

    //查询用户
    User getUserByUsername(String username);


    int checkUsername(String username);

    List<Details> getList(String navbar);

    List<Navbar> getNavbar();
}
