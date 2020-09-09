package com.stockchart.service;

import java.util.List;

import com.stockchart.entity.IPO;
import com.stockchart.entity.StockExchange;
import com.stockchart.entity.StockPrice;

public interface StockExchangeService {
	
	StockExchange addStockExchange(StockExchange stockExchange);
	List<StockExchange> findAllStockExchange();
	StockExchange findStockExchangeById(Integer stockExchangeId);
	IPO addIPO(Integer stockExchangeId, IPO ipo);
	StockPrice addStockPrice(Integer stockExchangeId, StockPrice stockPrice);
}
