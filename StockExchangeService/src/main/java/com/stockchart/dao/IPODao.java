package com.stockchart.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockchart.entity.IPO;

public interface IPODao extends JpaRepository<IPO, Integer>{

}
