package com.cyf.mystorebackstage.controller;

import com.cyf.mystorebackstage.entities.Goods;
import com.cyf.mystorebackstage.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping("/list")
    public String list(Map map){
        List<Goods> goodsList= goodsService.getList();
        map.put("goodList",goodsList);
        return "goods";
    }
}
