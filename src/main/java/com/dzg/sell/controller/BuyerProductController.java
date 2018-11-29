package com.dzg.sell.controller;

import com.dzg.sell.VO.ProductInfoVO;
import com.dzg.sell.VO.ProductVO;
import com.dzg.sell.VO.ResultVO;
import com.dzg.sell.domain.ProductCategory;
import com.dzg.sell.domain.ProductInfo;
import com.dzg.sell.service.CategoryService;
import com.dzg.sell.service.ProductService;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list() {
//        1、查询所有的上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

//        2.查询类目（一次性查询）
//        jdk8,lambda
        List<Integer> categoryTypeList = productInfoList.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
//        数据拼装
        List<ProductVO> productVOList = Lists.newArrayList();
        for (ProductCategory productCategory : categoryList) {
            List<ProductInfoVO> productInfoVOList = Lists.newArrayList();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            ProductVO productVO = ProductVO.builder().categoryName(productCategory.getCategoryName())
                    .categoryType(productCategory.getCategoryType()).productInfoVOList(productInfoVOList).build();
            productVOList.add(productVO);

        }
        ResultVO<Object> resultVO = ResultVO.builder().msg("成功").code(0).data(productVOList).build();
        return resultVO;
    }
}
