package com.cyf.mystorebackstage.controller;

import com.cyf.mystorebackstage.entities.Category;
import com.cyf.mystorebackstage.entities.Goods;
import com.cyf.mystorebackstage.service.CategoryService;
import com.cyf.mystorebackstage.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/admin/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private CategoryService categoryService;

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

    @GetMapping("/toAdd")
    public String toAdd(Map map){
        List<Category> categoryList = categoryService.getList();
        map.put("categoryList",categoryList);
        return "edit_goods";
    }

    @PostMapping("/save")
    public String save(Goods goods,@RequestParam("upload") MultipartFile file){
        try {
            if(!file.isEmpty()){
                ClassPathResource classPathResource = new ClassPathResource("static/images");
                String path = classPathResource.getURL().getPath();
                String fileName = file.getOriginalFilename();
                String suffix = fileName.substring(fileName.lastIndexOf("."));
                String newName = UUID.randomUUID().toString()+suffix;
                goods.setImg(newName);
                FileOutputStream out = new FileOutputStream(new File(path,newName));
                out.write(file.getBytes());
                out.close();
            }
            goodsService.saveGoods(goods);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admin/goods/list/1";
    }
}
