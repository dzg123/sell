package com.dzg.sell.service.impl;

import com.dzg.sell.domain.SellerInfo;
import com.dzg.sell.repository.SellerInfoRepository;
import com.dzg.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    private SellerInfoRepository sellerInfoRepository;
    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return sellerInfoRepository.findByOpenid(openid);
    }
}
