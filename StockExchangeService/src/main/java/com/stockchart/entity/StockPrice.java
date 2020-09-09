package com.stockchart.entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class StockPrice {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "company_id")
	@JsonIgnore
	private Company company;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "stock_exchange_id")
	@JsonIgnore
	private StockExchange stockExchange;
	@Column(name="current_price")
	private double currentPrice;
	private Date date;
	private Time time;
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
	public double getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public StockPrice(Integer id, Company company, StockExchange stockExchange, double currentPrice, Date date,
			Time time) {
		super();
		this.id = id;
		this.company = company;
		this.stockExchange = stockExchange;
		this.currentPrice = currentPrice;
		this.date = date;
		this.time = time;
	}
	public StockPrice(Company company, StockExchange stockExchange, double currentPrice, Date date, Time time) {
		super();
		this.company = company;
		this.stockExchange = stockExchange;
		this.currentPrice = currentPrice;
		this.date = date;
		this.time = time;
	}
	public StockPrice(double currentPrice) {
		super();
		this.currentPrice = currentPrice;
	}
	public StockPrice() {
		super();
	}
}
