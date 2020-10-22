package com.information.service.user.userImpl;


import com.information.dao.user_impl.DeleteUserImpl;
import com.information.service.user.DelUser;
/*删除功能*/
public class DelUserImpl implements DelUser {
    DeleteUserImpl delete=new DeleteUserImpl();
    @Override
    public void DelUser(String username) {
        delete.deleteUser(username);
    }
}
