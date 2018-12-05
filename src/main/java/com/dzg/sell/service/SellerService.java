package com.dzg.sell.service;

import com.dzg.sell.domain.SellerInfo;

public interface SellerService {
    /*  
     *       
     * @author dzg  通过openid卖家端信息
     * @date 2018/12/2 22:59
     * @param [openid]   
     * @return com.dzg.sell.domain.SellerInfo  
     */ 
    SellerInfo findSellerInfoByOpenid(String openid);
}
