package com.information.service.impl;

import com.information.dao.UserDao;
import com.information.dao.impl.UserDaoImpl;
import com.information.entity.User;
import com.information.service.LoginService;

/**
 * @Author qiaoshu
 * @JDK 1.8
 * Date: 2020-10-19  17:35
 * Description:
 */
public class LoginServiceImpl implements LoginService {
    private UserDaoImpl dao = new UserDaoImpl();
    /**
     * 验证要登录的账号密码是否正确
     * @param user : 从前端获取的对象
     * @return
     */
    @Override
    public boolean checkUser(User user) {
        if (user.getUsername()==null||user.getPassword()==null){
            System.out.println("用户名为空");
            return false;
        }
        if(dao.checkUsername(user.getUsername())==0){//用户名不存在
            return false;
        }
        User checker = dao.getUserByUsername(user.getUsername());
        //返回账号密码匹配与否
        boolean flag = user.getUsername().equals(checker.getUsername())&&user.getPassword().equals(checker.getPassword());
        return flag;
    }
}
