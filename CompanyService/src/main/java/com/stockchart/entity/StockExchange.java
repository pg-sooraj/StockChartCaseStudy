package com.stockchart.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="stock_exchange")
public class StockExchange {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name="stock_exchange_name")
	private String stockExchangeName;
	@Column(name="stock_exchange_brief")
	private String stockExchangeBrief;
	@Column(name="stock_exchange_address")
	private String stockExchangeAddress;
	@Column(name="remarks")
	private String remarks;
	@OneToMany(mappedBy="stockExchange", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<IPO> ipos;
	@OneToMany(mappedBy="stockExchange", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<StockPrice> StockPrices;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStockExchangeName() {
		return stockExchangeName;
	}
	public void setStockExchangeName(String stockExchangeName) {
		this.stockExchangeName = stockExchangeName;
	}
	public String getStockExchangeBrief() {
		return stockExchangeBrief;
	}
	public void setStockExchangeBrief(String stockExchangeBrief) {
		this.stockExchangeBrief = stockExchangeBrief;
	}
	public String getStockExchangeAddress() {
		return stockExchangeAddress;
	}
	public void setStockExchangeAddress(String stockExchangeAddress) {
		this.stockExchangeAddress = stockExchangeAddress;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public List<IPO> getIpos() {
		return ipos;
	}
	public void setIpos(List<IPO> ipos) {
		this.ipos = ipos;
	}
	public List<StockPrice> getStockPrices() {
		return StockPrices;
	}
	public void setStockPrices(List<StockPrice> stockPrices) {
		StockPrices = stockPrices;
	}
	public StockExchange(String stockExchangeName, String stockExchangeBrief, String stockExchangeAddress,
			String remarks) {
		super();
		this.stockExchangeName = stockExchangeName;
		this.stockExchangeBrief = stockExchangeBrief;
		this.stockExchangeAddress = stockExchangeAddress;
		this.remarks = remarks;
	}
	public StockExchange() {
		super();
	}
	public StockExchange(Integer id, String stockExchangeName, String stockExchangeBrief, String stockExchangeAddress,
			String remarks, List<IPO> ipos, List<StockPrice> stockPrices) {
		super();
		this.id = id;
		this.stockExchangeName = stockExchangeName;
		this.stockExchangeBrief = stockExchangeBrief;
		this.stockExchangeAddress = stockExchangeAddress;
		this.remarks = remarks;
		this.ipos = ipos;
		StockPrices = stockPrices;
	}
	public StockExchange(Integer id, String stockExchangeName, String stockExchangeBrief, String stockExchangeAddress,
			String remarks) {
		super();
		this.id = id;
		this.stockExchangeName = stockExchangeName;
		this.stockExchangeBrief = stockExchangeBrief;
		this.stockExchangeAddress = stockExchangeAddress;
		this.remarks = remarks;
	}
}
