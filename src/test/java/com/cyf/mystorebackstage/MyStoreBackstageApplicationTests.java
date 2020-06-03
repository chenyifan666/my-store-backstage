package com.cyf.mystorebackstage;

import com.cyf.mystorebackstage.entities.Category;
import com.cyf.mystorebackstage.repositories.CategoryRepository;
import com.cyf.mystorebackstage.repositories.GoodsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MyStoreBackstageApplicationTests {

    @Autowired
    private GoodsRepository goodsRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void contextLoads() {
        List<Category> categoryList = categoryRepository.findAll();
        System.out.println(categoryList);
    }

}
