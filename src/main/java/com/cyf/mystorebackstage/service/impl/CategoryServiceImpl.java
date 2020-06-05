package com.cyf.mystorebackstage.service.impl;

import com.cyf.mystorebackstage.entities.Category;
import com.cyf.mystorebackstage.repositories.CategoryRepository;
import com.cyf.mystorebackstage.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> getList() {
        return categoryRepository.findAll();
    }
}
