package com.information.service.user.userImpl;

import com.information.entity.User;
import com.information.service.user.SelectUser;
import com.information.dao.user_impl.SelectUserImpl;

/*查询功能*/
public class SelUserImpl implements SelectUser {
   SelectUserImpl select=  new SelectUserImpl();
  @Override
    public User selectUser(String username) {
      User user = select.selectUser(username);
      return user;
    }
}
