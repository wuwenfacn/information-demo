package com.information.service.manager.Impl;

import com.information.dao.shop_impl.DeleteShopImpl;
import com.information.dao.shop_impl.SelectShopImpl;
import com.information.entity.Details;

public class SelectShop {
    /*查询水果信息*/
    public Details select(String name){
        Details details=null;
        SelectShopImpl sel = new SelectShopImpl();
        details= sel.selectShop(name);
        return details;
    }
}
