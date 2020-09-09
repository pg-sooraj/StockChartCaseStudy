package com.stockchart.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class IPO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "company_id")
	private Company company;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "stock_exchange_id")
	@JsonIgnore
	private StockExchange stockExchange;
	@Column(name="price_per_share", nullable=false)
	private Double pricePerShare;
	@Column(name="total_number_of_shares", nullable=false)
	private Long totalNumberOfShares;
	@Column(name="open_date_time", nullable=false)
	private Timestamp openDateTime;
	@Column(name="remarks")
	private String remarks;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public StockExchange getStockExchange() {
		return stockExchange;
	}
	public void setStockExchange(StockExchange stockExchange) {
		this.stockExchange = stockExchange;
	}
	public Double getPricePerShare() {
		return pricePerShare;
	}
	public void setPricePerShare(Double pricePerShare) {
		this.pricePerShare = pricePerShare;
	}
	public Long getTotalNumberOfShares() {
		return totalNumberOfShares;
	}
	public void setTotalNumberOfShares(Long totalNumberOfShares) {
		this.totalNumberOfShares = totalNumberOfShares;
	}
	public Timestamp getOpenDateTime() {
		return openDateTime;
	}
	public void setOpenDateTime(Timestamp openDateTime) {
		this.openDateTime = openDateTime;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public IPO(Integer id, Company company, StockExchange stockExchange, Double pricePerShare, Long totalNumberOfShares,
			Timestamp openDateTime, String remarks) {
		super();
		this.id = id;
		this.company = company;
		this.stockExchange = stockExchange;
		this.pricePerShare = pricePerShare;
		this.totalNumberOfShares = totalNumberOfShares;
		this.openDateTime = openDateTime;
		this.remarks = remarks;
	}
	public IPO(Company company, StockExchange stockExchange, Double pricePerShare, Long totalNumberOfShares,
			Timestamp openDateTime, String remarks) {
		super();
		this.company = company;
		this.stockExchange = stockExchange;
		this.pricePerShare = pricePerShare;
		this.totalNumberOfShares = totalNumberOfShares;
		this.openDateTime = openDateTime;
		this.remarks = remarks;
	}
	public IPO(Company company, Double pricePerShare, Long totalNumberOfShares, String remarks) {
		super();
		this.company = company;
		this.pricePerShare = pricePerShare;
		this.totalNumberOfShares = totalNumberOfShares;
		this.remarks = remarks;
	}
	public IPO() {
		super();
	}
}
