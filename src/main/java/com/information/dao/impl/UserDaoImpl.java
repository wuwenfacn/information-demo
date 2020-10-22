package com.information.dao.impl;

import com.information.dao.UserDao;
import com.information.entity.Details;
import com.information.entity.Navbar;
import com.information.entity.User;
import com.information.entity.UserCollections;
import com.information.utils.DbManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private DbManager dbManager = DbManager.getInstance();

    /**
     * 插入用户
     * 返回1代表成功,返回0代表失败
     * @param user
     * @return
     */
    @Override
    public int insertUser(User user) {
        Connection conn = dbManager.getConn();
        String insert = "insert into user(username,passwords,types) values (?,?,?)";
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

    /**
     * 修改密码
     * 返回1代表修改成功返回0代表修改失败
     * @param id
     * @param user
     * @return
     */
    @Override
    public int updateUser(int id, User user) {
        Connection conn = dbManager.getConn();
        String update = "update user set passwords=?,types=? where userId=? and isDelete=1";
        PreparedStatement ps = null;
        int i = 0;
        try {
            ps = conn.prepareStatement(update);
            ps.setString(1,user.getPassword());
            ps.setString(2,user.getType());
            ps.setInt(3,id);
            i = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            dbManager.close(ps,conn);
        }
        return i;
    }

    /**
     * 返回一个User对象
     * @param username
     * @return
     */
    @Override
    public User getUserByUsername(String username) {
        Connection conn = dbManager.getConn();
        String select = "select userId,username,passwords,types,isDelete from user where username=? and isDelete=?";
        PreparedStatement ps = null;
        ResultSet re = null;
        User user = new User();
        String type = null;
        String password = null;
        int id = 0;
        int is_delete = 1;
        try {
            ps = conn.prepareStatement(select);
            ps.setString(1,username);
            ps.setInt(2,is_delete);
            re = ps.executeQuery();
            while (re.next()){
                password = re.getString("passwords");
                type = re.getString("types");
                id = re.getInt("userId");
                user.setUsername(username);
                user.setPassword(password);
                user.setId(id);
                user.setType(type);
                user.setIs_delete(is_delete);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            dbManager.close(re,ps,conn);
        }
        return user;
    }

    /**
     * 检查用户名是否存在
     * 返回1代表用户名存在,返回0代表用户名不存在
     * @param username
     * @return
     */
    @Override
    public int checkUsername(String username) {
        //检查用户名是否存在
        Connection conn = dbManager.getConn();
        String select = "select count(*) from user where username=? and isDelete=?";
        PreparedStatement ps = null;
        int i = 0;
        int is_delete = 1;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(select);
            ps.setString(1,username);
            ps.setInt(2,is_delete);
            rs = ps.executeQuery();
            while (rs.next()){
                i = rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            dbManager.close(rs,ps,conn);
        }
        return i;
    }

    /**
     * 获取所有水果详情
     * @param navbar
     * @return
     */
    @Override
    public List getList(String navbar,int i) {
        List list = new ArrayList();
        ResultSet rS = null;
        Connection conn = dbManager.getConn();
        //查询全部字段数据
        String select = "select id,namese,prices,describes,place,types,business,telephone,images from details where types = ? limit ?,16";
        PreparedStatement ps = null;
        Integer id;
        String name;
        String price;
        String describe;
        String place;
        String type;
        String business;
        String telephone;
        String image;
        try {
            ps = conn.prepareStatement(select);
            ps.setString(1,navbar);
            ps.setInt(2,i);
            rS= ps.executeQuery();
            while (rS.next()){
                id = rS.getInt(1);
                name = rS.getString(2);
                price = rS.getString(3);
                describe = rS.getString(4);
                place = rS.getString(5);
                type = rS.getString(6);
                business = rS.getString(7);
                telephone = rS.getString(8);
                image = rS.getString(9);
                list.add(new Details(id,name,price,describe,place,type,business,telephone,image));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            dbManager.close(rS,ps,conn);
        }
        return list;
    }

    @Override
    public List getNavbar() {
        List list = new ArrayList();
        ResultSet rS = null;
        Connection conn = dbManager.getConn();
        //查询全部字段数据
        String select = "select n_id,n_name,n_sort from navbar";
        PreparedStatement ps = null;
        Integer id;
        String name;
        Integer sort;
        try {
            ps = conn.prepareStatement(select);
            rS= ps.executeQuery();
            while (rS.next()){
                id = rS.getInt("n_id");
                name = rS.getString("n_name");
                sort = rS.getInt("n_sort");
                list.add(new Navbar(id,name,sort));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            dbManager.close(rS,ps,conn);
        }
        return list;
    }

    /**
     * update用户的收藏夹
     * @param username,fruitname
     * @return int
     */
    @Override
    public int updateCollect(String username, String fruitName) {
        Connection conn = dbManager.getConn();
        //查询全部字段数据
        String insert = "insert into collection(username,namese) values (?,?)";
        PreparedStatement ps = null;
        int i = 0;
        try {
            ps = conn.prepareStatement(insert);
            ps.setString(1,username);
            ps.setString(2,fruitName);
            i = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            dbManager.close(ps,conn);
        }
        return i;
    }

    /**
     * 根据水果名查询水果详情
     * @param
     * @return
     */
    @Override
    public List<Details> getDetailsByname(String fruitname) {
        List<Details> list = new ArrayList();
        ResultSet rS = null;
        Connection conn = dbManager.getConn();
        //查询全部字段数据
        String select = "select id,namese,prices,describes,place,types,business,telephone,images from details where namese=?";
        PreparedStatement ps = null;
        Integer id;
        String name;
        String price;
        String describe;
        String place;
        String type;
        String business;
        String telephone;
        String image;
        try {
            ps = conn.prepareStatement(select);
            ps.setString(1,fruitname);
            rS= ps.executeQuery();
            while (rS.next()){
                id = rS.getInt("id");
                name = rS.getString("namese");
                price = rS.getString("prices");
                describe = rS.getString("describes");
                place = rS.getString("place");
                type = rS.getString("types");
                business = rS.getString("business");
                telephone = rS.getString("telephone");
                image = rS.getString("images");
                list.add(new Details(id,name,price,describe,place,type,business,telephone,image));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            dbManager.close(rS,ps,conn);
        }
        return list;
    }

    /**
     * 根据用户名查询其收藏夹
     * @param username
     * @return
     */
    @Override
    public List<UserCollections> getCollectionByUsername(String username) {
        List<UserCollections> list = new ArrayList();
        ResultSet rS = null;
        Connection conn = dbManager.getConn();
        //查询全部字段数据
        String select = "select * from collection c INNER JOIN details d on c.namese=d.namese where c.username=? and c.ciscancle=0";
        PreparedStatement ps = null;
        String namese;
        long ciscancle;
        java.sql.Timestamp ctime;
        long id;
        String prices;
        String describes;
        String place;
        String types;
        String business;
        String telephone;
        String images;
        try {
            ps = conn.prepareStatement(select);
            ps.setString(1,username);
            rS= ps.executeQuery();
            while (rS.next()){
                namese = rS.getString("namese");
                ciscancle = rS.getInt("ciscancle");
                ctime = rS.getTimestamp("ctime");
                id = rS.getInt("id");
                prices = rS.getString("prices");
                describes = rS.getString("describes");
                place = rS.getString("place");
                types = rS.getString("types");
                business = rS.getString("business");
                telephone = rS.getString("telephone");
                images = rS.getString("images");
                list.add(new UserCollections(username,namese,ciscancle,ctime,id,prices,describes,place,types,business,telephone,images));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            dbManager.close(rS,ps,conn);
        }
        return list;
    }

    /**
     * 查询用户此条收藏
     * @param username
     * @param fruitname
     * @return
     */
    @Override
    public int checkcollection(String username, String fruitname) {

        return 0;
    }

    /**
     * 取消收藏,把ciscancle变成0
     * @param username 用户名
     * @param fruitname 水果名
     * @return 返回1表示成功,返回0表示失败
     */
    @Override
    public int cancleCollect(String username, String fruitname) {
        Connection conn = dbManager.getConn();
        //查询全部字段数据
        String update = "update collection set ciscancle=1 where username=? and namese=?";
        PreparedStatement ps = null;
        int i = 0;
        try {
            ps = conn.prepareStatement(update);
            ps.setString(1,username);
            ps.setString(2,fruitname);
            i = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            dbManager.close(ps,conn);
        }
        return i;
    }
}