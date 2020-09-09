package com.stockchart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockchart.entity.StockExchange;

@Repository
public interface StockExchangeDao extends JpaRepository<StockExchange, Integer>{

}
