package com.dzg.sell.service;

import com.dzg.sell.domain.ProductInfo;
import com.dzg.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface ProductService {
    ProductInfo findOne(String productId);

    /**
     * @param [] 查询所有在架商品列表
     * @return java.util.List<com.dzg.sell.domain.ProductInfo>
     * @author dzg
     * @date 2018/11/22 16:25
     */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //    加库存
    void increaseStock(List<CartDTO> cartDTOList);

    //    减库存
    void decreaseStock(List<CartDTO> cartDTOList);

}
