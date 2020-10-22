package com.information.dao.user_impl;

import com.information.entity.User;
import com.information.service.user.SelectUser;
import com.information.utils.DbManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*查询用户信息*/
public class SelectUserImpl implements SelectUser {
    private User user=new User();
    @Override
    public User selectUser(String username) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="select username,passwords,types from user where username=?";
        try {
            conn = DbManager.getInstance().getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            rs = ps.executeQuery();
            if (rs.next()){
                user.setUsername(rs.getString(1));
                System.out.println(rs.getString(1));
                user.setPassword(rs.getString(2));
                System.out.println(rs.getString(2));
                user.setType(rs.getString(3));
                System.out.println(rs.getString(3));
            }
        } catch (SQLException throwables) {
            System.out.println("查询有误");
            throwables.printStackTrace();
        }
        return user;
    }
}
