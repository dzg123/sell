package com.dzg.sell.repository;

import com.dzg.sell.domain.ProductCategory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    @Transactional
    public void findOneTest() {
        ProductCategory productCategory = repository.getOne(1);
        System.out.println(productCategory);
    }

    @Test
    @Transactional
    public void saveTest() {
        ProductCategory category = ProductCategory.builder().
                categoryName("女生最爱").categoryType(3).createTime(new Date()).build();
        repository.save(category);
    }
    @Test
    @Transactional
    public void findByCategoryTypeInTest(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        List<ProductCategory> categoryList = repository.findByCategoryTypeIn(list);
        for (ProductCategory category : categoryList) {
            System.out.println(category);
        }
    }
}