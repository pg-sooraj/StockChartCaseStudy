package com.stockchart.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockchart.entity.Company;

@Repository
public interface CompanyDao extends JpaRepository<Company, Integer>{
//	@Query("SELECT c FROM company c WHERE c.sectorId = ?1")
	List<Company> findBySectorId(Integer sectorId);
}
