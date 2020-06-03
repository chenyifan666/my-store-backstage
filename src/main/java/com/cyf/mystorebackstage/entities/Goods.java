package com.cyf.mystorebackstage.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "goods")
@Data
public class Goods {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "category_id")
    private String categoryId;

    @Column(name = "img")
    private String img;

    @Column(name = "describe")
    private String describe;

    @Column(name = "create_date")
    private Date createDate;

}
