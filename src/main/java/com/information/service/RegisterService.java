package com.information.service;

import com.information.entity.User;

/**
 * @Author qiaoshu
 * @JDK 1.8
 * Date: 2020-10-19  15:37
 * Description:
 */
public interface RegisterService {

    boolean checkUsername(String username);
    boolean insertUser(User user);
}
