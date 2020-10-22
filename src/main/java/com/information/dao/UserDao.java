package com.information.dao;

import com.information.entity.Details;
import com.information.entity.Navbar;
import com.information.entity.User;
import com.information.entity.UserCollections;

import java.sql.ResultSet;
import java.util.List;

public interface UserDao {
    //添加用户
    int insertUser(User user);

    //update用户
    int updateUser(int id, User user);

    //查询用户
    User getUserByUsername(String username);

    //检查用户名是否存在
    int checkUsername(String username);

    //获取所有水果详情
    List<Details> getList(String navbar,int i);

    //查询所有水果标题
    List<Navbar> getNavbar();

    //update水果收藏信息
    int updateCollect(String username, String fruitName);

    //根据水果名查询水果详情
    List<Details> getDetailsByname(String fruitName);

    //根据用户名查询用户收藏夹
    List<UserCollections> getCollectionByUsername(String username);

    //添加收藏
    int checkcollection(String username, String fruitName);

    //取消收藏
    int cancleCollect(String username, String fruitname);
}
