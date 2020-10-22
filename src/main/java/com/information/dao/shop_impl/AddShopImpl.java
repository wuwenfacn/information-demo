package com.information.dao.shop_impl;

import com.information.dao.shop.AddShop;
import com.information.entity.Details;
import com.information.utils.DbManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddShopImpl implements AddShop {
    //添加商品
    @Override
    public boolean addShop(Details details) {
        //获取数据库连接
        Connection conn =DbManager.getInstance().getConn();
        //sql语句
        String sql="insert into details(namese,prices,describes,place,types,business,telephone,images) values(?,?,?,?,?,?,?,?) ";
        PreparedStatement ps=null;
        int i=0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,details.getNamese());
            ps.setString(2,details.getPrices());
            ps.setString(3,details.getDescribes());
            ps.setString(4,details.getPlace());
            ps.setString(5,details.getTypes());
            ps.setString(6,details.getBusiness());
            ps.setString(7,details.getTelephone());
            ps.setString(8,details.getImages());
            i = ps.executeUpdate();
        } catch (SQLException throwables) {
            System.out.println("添加错误");
        }
        //给占位符赋值
        return i>0;
    }
}
