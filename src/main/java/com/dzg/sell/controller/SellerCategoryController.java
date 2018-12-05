package com.dzg.sell.controller;

import com.dzg.sell.domain.ProductCategory;
import com.dzg.sell.domain.ProductInfo;
import com.dzg.sell.exception.SellException;
import com.dzg.sell.form.CategoryForm;
import com.dzg.sell.service.CategoryService;
import com.dzg.sell.service.ProductService;
import com.lly835.bestpay.utils.JsonUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/seller/category")
public class SellerCategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    private Integer beforeCategoryType;

    /**
     * 类目列表
     *
     * @param map
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(Map<String, Object> map) {
        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("categoryList", categoryList);
        return new ModelAndView("category/list", map);
    }

    /**
     * 展示
     *
     * @param categoryId
     * @param map
     * @return
     */
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "categoryId", required = false) Integer categoryId,
                              Map<String, Object> map) {
        if (categoryId != null) {
            ProductCategory productCategory = categoryService.findOne(categoryId);
            map.put("category", productCategory);
        }

        return new ModelAndView("category/index", map);
    }

    /**
     * 保存/更新
     *
     * @param form
     * @param bindingResult
     * @param map
     * @return
     */
    @PostMapping("/save")
    public ModelAndView save(@Valid CategoryForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/category/index");
            return new ModelAndView("common/error", map);
        }

        ProductCategory productCategory = new ProductCategory();

        try {
            if (form.getCategoryId() != null) {
                productCategory = categoryService.findOne(form.getCategoryId());
                beforeCategoryType = productCategory.getCategoryType();
            }
            BeanUtils.copyProperties(form, productCategory);
            categoryService.save(productCategory);
            List<ProductInfo> productInfoList = productService.findByCategoryType(beforeCategoryType);
            if (productInfoList != null && productInfoList.size() > 0) {
                for (ProductInfo productInfo : productInfoList) {
                    productInfo.setCategoryType(form.getCategoryType());
                    productService.save(productInfo);
//                    System.out.println(JsonUtil.toJson(productInfo));
                }
            }
//            productInfoList.stream().map((ProductInfo e)-> {
//                e.setCategoryType(form.getCategoryType());
//                productService.save(e);
//                System.out.println(JsonUtil.toJson(e));
//                return "";
//            });


        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/category/index");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/sell/seller/category/list");
        return new ModelAndView("common/success", map);
    }
}
