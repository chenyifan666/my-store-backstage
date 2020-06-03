package com.cyf.mystorebackstage.repositories;

import com.cyf.mystorebackstage.entities.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository extends JpaRepository<Goods,String>,JpaSpecificationExecutor<Goods> {
}
