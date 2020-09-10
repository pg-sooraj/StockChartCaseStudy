package com.stockchart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockchart.entity.IPO;

@Repository
public interface IPODao extends JpaRepository<IPO, Integer>{

}
