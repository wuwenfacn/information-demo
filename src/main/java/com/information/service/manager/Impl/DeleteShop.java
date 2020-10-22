package com.information.service.manager.Impl;

import com.information.dao.shop_impl.AddShopImpl;
import com.information.dao.shop_impl.DeleteShopImpl;
import com.information.entity.Details;

public class DeleteShop {
    //删除水果信息
    public boolean delete(String name){
        DeleteShopImpl del = new DeleteShopImpl();
        return del.deleteShop(name);
    }
}
