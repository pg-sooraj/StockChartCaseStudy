package com.stockchart.service;

import java.util.List;

import com.stockchart.entity.Company;
import com.stockchart.entity.Sector;

public interface SectorService {
	Sector addSector(Sector sector);
	List<Sector> findAllSector();
	Sector findSectorById(Integer sectorId);
	List<Company> findCompaniesBySectorId(Integer sectorId);
	void deleteSectorById(Integer sectorId);
	
	Company addCompany(Integer sectorId, Company company);
	Company updateCompany(Integer sectorId, Company company);
}
