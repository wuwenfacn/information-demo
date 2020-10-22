package com.information.service.user;

import com.information.entity.User;

public interface SelectUser {
    //查询用户信息
    User selectUser(String username);
}
