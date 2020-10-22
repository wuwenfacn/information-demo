package com.information.service;

import com.information.entity.Details;
import com.information.entity.UserCollections;

import java.util.List;

/**
 * @Author qiaoshu
 * @since JDK 1.8
 * Date: 2020-10-22  10:12
 * Description:
 */
public interface CollectService {
    //收藏水果信息，成功返回true，失败返回false
    boolean collectFruits(String username, String fruitname);

    //根据用户名获取所有收藏的信息
    List<UserCollections> showCollections(String usrname);

    //取消收藏水果信息，成功返回true，失败返回false
    boolean canclecollectFruits(String username, String fruitname);
}
