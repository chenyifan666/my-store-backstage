package com.cyf.mystorebackstage.service.impl;

import com.cyf.mystorebackstage.entities.Goods;
import com.cyf.mystorebackstage.repositories.GoodsRepository;
import com.cyf.mystorebackstage.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.GenerationType;
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

    @Override
    public Page<Goods> getGoodsPage(int page, int size) {
        Sort sort = Sort.by(Sort.Order.desc("createDate"));
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<Goods> goodsListPage = goodsRepository.findAll(pageable);
        return goodsListPage;
    }

    @Override
    public Page<Goods> getGoodsPageByGoods(int page, int size, Goods goods) {
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("name",ExampleMatcher.GenericPropertyMatchers.contains());
        Example<Goods> example = Example.of(goods,exampleMatcher);
        Sort sort = Sort.by(Sort.Order.desc("createDate"));
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<Goods> goodsListPage = goodsRepository.findAll(example,pageable);
        return goodsListPage;
    }
}
