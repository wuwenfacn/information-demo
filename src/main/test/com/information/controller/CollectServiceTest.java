package com.information.controller;

import com.information.entity.UserCollections;
import com.information.service.impl.CollectServiceImpl;
import org.junit.Test;

import java.util.List;

/**
 * @Author qiaoshu
 * @since JDK 1.8
 * Date: 2020-10-22  17:24
 * Description:
 */
public class CollectServiceTest {
    private CollectServiceImpl service = new CollectServiceImpl();
    @Test
    public void showCollectionsTest(){
        List<UserCollections> admin = service.showCollections("admin");
        for (UserCollections userCollections : admin) {
            System.out.println(userCollections.toString());
        }
    }
}
