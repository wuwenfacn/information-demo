package com.information.service;

import com.information.entity.User;

/**
 * @Author qiaoshu
 * @JDK 1.8
 * Date: 2020-10-19  15:38
 * Description:
 */
public interface LoginService {
    //判断用户名、密码和用户类型是否匹配
    boolean checkUser(User user);
}
