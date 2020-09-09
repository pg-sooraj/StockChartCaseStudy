package com.stockchart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.stockchart.dao.IPODao;
import com.stockchart.dao.StockExchangeDao;
import com.stockchart.dao.StockPriceDao;
import com.stockchart.entity.IPO;
import com.stockchart.entity.StockExchange;
import com.stockchart.entity.StockPrice;
import com.stockchart.exception.NotFoundException;

@Service
public class SockExchangeServiceImpl implements StockExchangeService {
	
	private StockExchangeDao stockExchangeDao;
	private IPODao ipoDao;
	private StockPriceDao stockPriceDao;
	private final String  message = "stock exchnage not found with id: ";
	
	public SockExchangeServiceImpl(StockExchangeDao stockExchangeDao, IPODao ipoDao, StockPriceDao stockPriceDao) {
		super();
		this.stockExchangeDao = stockExchangeDao;
		this.ipoDao = ipoDao;
		this.stockPriceDao = stockPriceDao;
	}

	@Override
	public StockExchange addStockExchange(StockExchange stockExchange) {
		return stockExchangeDao.save(stockExchange);
	}

	@Override
	public List<StockExchange> findAllStockExchange() {
		return stockExchangeDao.findAll();
	}

	@Override
	public StockExchange findStockExchangeById(Integer stockExchangeId){
		Optional<StockExchange> stockExchangeOpt = stockExchangeDao.findById(stockExchangeId);
		if(stockExchangeOpt.isPresent()) {
			return stockExchangeOpt.get();
		} else {
			throw new NotFoundException(message + stockExchangeId);
		}
	}

	@Override
	public IPO addIPO(Integer stockExchangeId, IPO ipo) {
		Optional<StockExchange> stockExchangeOpt = stockExchangeDao.findById(stockExchangeId);
		return stockExchangeOpt.map(stockExchange -> {ipo.setStockExchange(stockExchange);
														return ipoDao.save(ipo);})
		.orElseThrow(() -> new NotFoundException(message + stockExchangeId));
	}

	@Override
	public StockPrice addStockPrice(Integer stockExchangeId, StockPrice stockPrice) {
		Optional<StockExchange> stockExchangeOpt = stockExchangeDao.findById(stockExchangeId);
		return stockExchangeOpt.map(stockExchange -> {stockPrice.setStockExchange(stockExchange);
														return stockPriceDao.save(stockPrice);})
		.orElseThrow(() -> new NotFoundException(message + stockExchangeId));
	}
}
