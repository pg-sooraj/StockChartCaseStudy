package com.stockchart.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockchart.entity.Sector;

@Repository
public interface SectorDao extends JpaRepository<Sector, Integer>{
	
}
