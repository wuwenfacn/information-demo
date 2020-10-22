package com.information.service.user.userImpl;

import com.information.dao.user_impl.UpdateUserImpl;
import com.information.entity.User;
import com.information.service.user.UpUser;
/*更新功能*/
public class UpUserImpl implements UpUser {
    UpdateUserImpl updateUser=new UpdateUserImpl();

    @Override
    public void updateUser(User user) {
        updateUser.updatUser(user);
    }
}
