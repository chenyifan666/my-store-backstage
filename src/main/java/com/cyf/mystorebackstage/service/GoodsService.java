package com.cyf.mystorebackstage.service;

import com.cyf.mystorebackstage.entities.Goods;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

public interface GoodsService {

    List<Goods> getList();

    Page<Goods> getGoodsPage(int page,int size);

    Page<Goods> getGoodsPageByGoods(int page,int size,Goods goods);
}
