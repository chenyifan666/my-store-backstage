package com.cyf.mystorebackstage.service;

import com.cyf.mystorebackstage.entities.Goods;
import org.springframework.stereotype.Service;

import java.util.List;

public interface GoodsService {

    public List<Goods> getList();
}
