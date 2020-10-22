package com.information.dao;

import com.information.dao.impl.UserDaoImpl;
import com.information.entity.Details;
import com.information.entity.User;
import com.information.entity.UserCollections;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author qiaoshu
 * @JDK 1.8
 * Date: 2020-10-19  15:59
 * Description:
 */
public class UserDaoImplTest {
    UserDaoImpl dao = new UserDaoImpl();
    User user = new User();

    @Test
    public void insertTest(){
        user.setUsername("007");
        user.setPassword("000");
        user.setType("000");
        int i = dao.insertUser(user);
        System.out.println(i);
    }
    @Test
    public void updateTest(){
        user.setUsername("000");
        user.setPassword("00000");
        user.setType("002");
        int i = dao.updateUser(1,user);
        System.out.println(i);
    }
    @Test
    public void getUserByUsernameTest(){
    }
    @Test
    public void getListTest(){
        ArrayList<Details> list = (ArrayList) dao.getList("热带水果",0);
        for (Details item : list) {
            System.out.println(item.toString());
        }
    }
    @Test
    public void getNavbarTest(){

    }

    @Test
    public void getDetailsBynameTest(){
        List<Details> collection = dao.getDetailsByname("红心火龙果");
        for (Details details : collection) {
            System.out.println(details);
        }

    }
    @Test
    public void updateCollectTest(){
        System.out.println(dao.updateCollect("admin", "红心火龙果"));
        System.out.println(dao.updateCollect("admin", "百香果"));
        System.out.println(dao.updateCollect("admin", "李子"));
    }

    @Test
    public void getCollectionByUsername(){
        List<UserCollections> collection = dao.getCollectionByUsername("admin");
        for (UserCollections details : collection) {
            System.out.println(details);
        }
    }
}
