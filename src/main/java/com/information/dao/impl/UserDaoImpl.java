package com.information.dao.impl;

import com.information.dao.UserDao;
import com.information.entity.Details;
import com.information.entity.Navbar;
import com.information.entity.User;
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
        String insert = "insert into user(username,password,type) values (?,?,?)";
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
        String update = "update user set password=?,type=? where u_id=? and is_delete=1";
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
        String select = "select u_id,username,password,type,is_delete from user where username=? and is_delete=?";
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
                password = re.getString("password");
                type = re.getString("type");
                id = re.getInt("u_id");
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
        String select = "select count(*) from user where username=? and is_delete=?";
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

    @Override
    public List getList(String navbar) {
        List list = new ArrayList();
        ResultSet rS = null;
        Connection conn = dbManager.getConn();
        //查询全部字段数据
        String select = "select d_id,d_name,d_price,d_describe,d_place,d_type,d_business,d_telephone,d_image from details where d_type = ?";
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
            rS= ps.executeQuery();
            while (rS.next()){
                id = rS.getInt("d_id");
                name = rS.getString("d_name");
                price = rS.getString("d_price");
                describe = rS.getString("d_describe");
                place = rS.getString("d_place");
                type = rS.getString("d_type");
                business = rS.getString("d_business");
                telephone = rS.getString("d_telephone");
                image = rS.getString("d_image");
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
}










