package com.information.dao.shop_impl;

import com.information.dao.shop.DeleteShop;
import com.information.utils.DbManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//根据商品名 删除商品
public class DeleteShopImpl implements DeleteShop {
    @Override
    public boolean deleteShop(String name) {
        Connection conn=null;
        PreparedStatement ps = null;
        String sql="delete from details where namese=?";
        int i=0;
        try {
            //获取连接
            conn= DbManager.getInstance().getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            i = ps.executeUpdate();
            if (i>0)
                return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
