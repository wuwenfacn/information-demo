package com.information.dao.shop_impl;

import com.information.dao.shop.SelectShop;
import com.information.entity.Details;
import com.information.utils.DbManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*查询水果信息*/
public class SelectShopImpl implements SelectShop {
    private  Details details=new Details();
    //根据商品名 查询商品
    @Override
    public Details selectShop(String name) {
        Connection conn=null;
        PreparedStatement ps=null;
        String sql="select namese,prices,describes,place,types,business,telephone,images " +
                   "from details where namese=?";
        try {
            conn = DbManager.getInstance().getConn();
            ps=conn.prepareStatement(sql);
            ps.setString(1,name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                details.setNamese(rs.getString(1));
                details.setPrices(rs.getString(2));
                details.setDescribes(rs.getString(3));
                details.setPlace(rs.getString(4));
                details.setTypes(rs.getString(5));
                details.setBusiness(rs.getString(6));
                details.setTelephone(rs.getString(7));
                details.setImages(rs.getString(8));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return details;
    }
}
