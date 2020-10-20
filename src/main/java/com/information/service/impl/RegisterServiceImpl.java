package com.information.service.impl;

import com.information.dao.impl.UserDaoImpl;
import com.information.entity.User;
import com.information.service.RegisterService;

/**
 * @Author qiaoshu
 * @JDK 1.8
 * Date: 2020-10-19  17:38
 * Description:
 *      检查用户是否注册成功
 */
public class RegisterServiceImpl implements RegisterService {
    private UserDaoImpl dao = new UserDaoImpl();
    @Override
    public boolean checkUsername(String username) {
        if (dao.checkUsername(username)==0){
            //如果用户名不存在,可以注册
            return true;
        }
        return false;
    }
    @Override
    public boolean insertUser(User user) {
        return dao.insertUser(user)==0?false:true;
    }
}
