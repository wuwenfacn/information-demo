package com.information.dao.user_impl;

import com.information.dao.user.DeleteUser;
import com.information.utils.DbManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteUserImpl implements DeleteUser {
//根据用户名删除用户
    @Override
    public boolean deleteUser(String username) {
        //获取数据库连接
        Connection conn =DbManager.getInstance().getConn();
        //sql语句
        String sql="delete from user where username= ?";
        PreparedStatement ps=null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
return true;
    }
}
