package com.cyf.mystorebackstage.controller;

import com.cyf.mystorebackstage.entities.Goods;
import com.cyf.mystorebackstage.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/admin/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping("/list/{page}")
    public String list(@PathVariable(name = "page",required = false)int page,
                       Goods goods,
                       Map map){
        if(page==0){
            page = 1;
        }
        Page<Goods> goodsPage= goodsService.getGoodsPageByGoods(page-1,10,goods);
        map.put("goodList",goodsPage.getContent());
        map.put("pageNo",page);
        map.put("totalPage",goodsPage.getTotalPages());
        map.put("totalSize",goodsPage.getTotalElements());
        map.put("name",goods.getName());
        return "goods";
    }
}
