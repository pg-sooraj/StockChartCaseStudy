package com.stockchart.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockchart.entity.StockPrice;

public interface StockPriceDao extends JpaRepository<StockPrice, Integer>{

}
