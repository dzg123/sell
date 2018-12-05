package com.dzg.sell.repository;

import com.dzg.sell.domain.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {
    List<ProductInfo> findByProductStatus(Integer productStatus);
    List<ProductInfo> findByCategoryType(Integer categoryType);

}
