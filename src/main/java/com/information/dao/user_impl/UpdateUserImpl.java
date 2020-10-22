package com.information.dao.user_impl;

import com.information.dao.user.UpdateUser;
import com.information.entity.User;
import com.information.utils.DbManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*修改用户信息*/
public class UpdateUserImpl implements UpdateUser {
    @Override
    public void updatUser(User user) {
        Connection conn=null;
        PreparedStatement ps = null;
        int i;
        String sql="UPDATE user SET  passwords=?,type=? where username = ?";
        try {
            conn = DbManager.getInstance().getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1,user.getPassword());
            ps.setString(2,user.getType());
            ps.setString(3,user.getUsername());
            //执行更新
            ps.executeUpdate();
        } catch (SQLException throwables) {
            System.out.println("更新失败");
            throwables.printStackTrace();
        }
    }
}
