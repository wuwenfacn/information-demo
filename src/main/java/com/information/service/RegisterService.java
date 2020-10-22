package com.information.service;

import com.information.entity.User;

/**
 * @Author qiaoshu
 * @JDK 1.8
 * Date: 2020-10-19  15:37
 * Description:
 */
public interface RegisterService {
    //根据用户名判断用户名是否存在
    boolean checkUsername(String username);
    //添加用户
    boolean insertUser(User user);
}
