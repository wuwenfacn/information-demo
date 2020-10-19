package com.information.dao.impl;

import com.information.dao.UserDao;
import com.information.entity.User;
import com.information.utils.DbManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl  {
    private DbManager dbManager = DbManager.getInstance();

    public int insertUser(User user) {
        Connection conn = dbManager.getConn();
        String insert = "insert into user values (?,?,?)";
        PreparedStatement ps = null;
        int i = 0;
        try {
            ps = conn.prepareStatement(insert);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getType());
            i = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            dbManager.close(ps,conn);
        }
        return i;
    }


}
