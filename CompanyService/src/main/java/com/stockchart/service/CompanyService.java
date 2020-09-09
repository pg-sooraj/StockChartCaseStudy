package com.stockchart.service;

import java.util.List;

import com.stockchart.entity.Company;
import com.stockchart.entity.Director;

public interface CompanyService {
	
	Company findCompanyById(Integer companyId);
	List<Company> findAllCompany();
	List<Director> findDirectorsByCompanyId(Integer companyId);
	
	Director addDirector(Integer companyId, Director director);
}
