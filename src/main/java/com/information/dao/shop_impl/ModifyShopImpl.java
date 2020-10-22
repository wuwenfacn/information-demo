package com.information.dao.shop_impl;

import com.information.dao.shop.ModifyShop;
import com.information.entity.Details;
import com.information.utils.DbManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*修改水果信息*/
public class ModifyShopImpl implements ModifyShop {
    @Override
    public void modify(Details details) {
        Connection conn = DbManager.getInstance().getConn();
        String sql="update details SET prices=?,describes=?,place=?,types=?,business=?,telephone=?,images=? where namese=?";
        PreparedStatement ps=null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,details.getPrices());
            ps.setString(2,details.getDescribes());
            ps.setString(3,details.getPlace());
            ps.setString(4,details.getTypes());
            ps.setString(5,details.getBusiness());
            ps.setString(6,details.getTelephone());
            ps.setString(7,details.getImages());
            ps.setString(8,details.getNamese());
            int i = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
