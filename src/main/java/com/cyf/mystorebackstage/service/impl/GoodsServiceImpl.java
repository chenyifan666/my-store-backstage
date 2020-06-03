package com.cyf.mystorebackstage.service.impl;

import com.cyf.mystorebackstage.entities.Goods;
import com.cyf.mystorebackstage.repositories.GoodsRepository;
import com.cyf.mystorebackstage.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsRepository goodsRepository;

    @Override
    public List<Goods> getList() {
        Sort sort = Sort.by(Sort.Order.desc("createDate"));
        Pageable pageable = PageRequest.of(0,10,sort);
        Page<Goods> goodsListPage = goodsRepository.findAll(pageable);
        return goodsListPage.getContent();
    }
}
