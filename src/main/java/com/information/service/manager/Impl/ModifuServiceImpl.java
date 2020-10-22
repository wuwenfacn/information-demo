package com.information.service.manager.Impl;

import com.information.dao.shop.ModifyShop;
import com.information.dao.shop_impl.ModifyShopImpl;
import com.information.entity.Details;
import com.information.service.manager.ModifyService;

public class ModifuServiceImpl implements ModifyService {
    ModifyShop modifyShop=new ModifyShopImpl();
    @Override
    //修改水果信息
    public void modify(Details details) {
        modifyShop.modify(details);
    }
}
