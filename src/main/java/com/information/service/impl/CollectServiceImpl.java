package com.information.service.impl;

import com.information.dao.UserDao;
import com.information.dao.impl.UserDaoImpl;
import com.information.entity.Details;
import com.information.entity.UserCollections;
import com.information.service.CollectService;

import java.util.Collection;
import java.util.List;

/**
 * @Author qiaoshu
 * @since JDK 1.8
 * Date: 2020-10-22  10:13
 * Description:
 */
public class CollectServiceImpl implements CollectService {
    private UserDao dao = new UserDaoImpl();
    @Override
    public boolean collectFruits(String username, String fruitName) {
        //判断用户是否曾经收藏过这个水果
        if (dao.checkcollection(username,fruitName)==1) {
            return true;
        }
        if (dao.updateCollect(username, fruitName)==1){
            return true;
        }
        return false;
    }

    /**
     * 根据用户名查询水果详情
     * @param usrname
     * @return
     */
    @Override
    public List<UserCollections> showCollections(String usrname) {
        List<UserCollections> collection = dao.getCollectionByUsername(usrname);
        return collection;
    }

    /**
     * 取消收藏
     * @param username
     * @param fruitname
     * @return
     */
    @Override
    public boolean canclecollectFruits(String username, String fruitname) {
        if(dao.cancleCollect(username,fruitname)==1){
            return true;
        }
        return false;
    }

}
