package com.stockchart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockchart.entity.StockPrice;

@Repository
public interface StockPriceDao extends JpaRepository<StockPrice, Integer>{

}
