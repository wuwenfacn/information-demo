package com.information.service;

import com.information.entity.User;
import com.information.service.impl.LoginServiceImpl;
import org.junit.Test;

/**
 * @Author qiaoshu
 * @JDK 1.8
 * Date: 2020-10-20  9:10
 * Description:
 */
public class LoginServiceImplTest {
    LoginServiceImpl service = new LoginServiceImpl();
    /**
     * 测试登录功能
     */
    @Test
    public void checkUserTest(){
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        user.setType("customer");
        System.out.println(service.checkUser(user));
    }
}
