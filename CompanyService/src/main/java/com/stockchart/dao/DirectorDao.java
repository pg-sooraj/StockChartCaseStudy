package com.stockchart.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockchart.entity.Director;

@Repository
public interface DirectorDao extends JpaRepository<Director, Integer>{
//	@Query("SELECT d FROM director d WHERE d.companyId = ?1")
	List<Director> findByCompanyId(Integer companyId);
}
