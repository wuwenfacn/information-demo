package com.information.service.manager.Impl;

import com.information.dao.shop_impl.AddShopImpl;
import com.information.entity.Details;

public class AddShop {
    //添加水果信息
    public boolean add(Details details){
        AddShopImpl add = new AddShopImpl();
        return add.addShop(details);
    }
}
