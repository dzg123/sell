package com.dzg.sell.repository;

import com.dzg.sell.domain.SellerInfo;
import com.lly835.bestpay.utils.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoRepositoryTest {
    @Autowired
    private SellerInfoRepository sellerInfoRepository;
    @Test
    public void findByOpenid() {
        SellerInfo info = sellerInfoRepository.findByOpenid("abc123");
        System.out.println(JsonUtil.toJson(info));
    }
}