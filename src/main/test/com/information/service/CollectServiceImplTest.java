package com.information.service;

import com.information.entity.UserCollections;
import com.information.service.impl.CollectServiceImpl;
import org.junit.Test;

import java.util.List;

/**
 * @Author qiaoshu
 * @since JDK 1.8
 * Date: 2020-10-22  12:01
 * Description:
 */
public class CollectServiceImplTest {
    private CollectServiceImpl ser = new CollectServiceImpl();
    @Test
    public void CollectServiceImplCollectServiceImplTest(){
        System.out.println(ser.collectFruits("007", "山竹"));
    }
    @Test
    public void CollectionCarServiceTest(){
        List<UserCollections> list = ser.showCollections("admin");
        System.out.println(list);
    }

}
