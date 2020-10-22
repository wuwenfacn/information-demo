package com.information.dao.user;

import com.information.entity.User;

/*查询用户*/
public interface SelectUser {
    User selectuser(String username);
}
