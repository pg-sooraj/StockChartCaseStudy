package com.stockchart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.stockchart.dao.CompanyDao;
import com.stockchart.dao.SectorDao;
import com.stockchart.entity.Company;
import com.stockchart.entity.Sector;
import com.stockchart.exception.NotFoundException;

@Service
public class SectorServiceImpl implements SectorService {
	
	SectorDao sectorDao;
	CompanyDao companyDao;
	
	public SectorServiceImpl(SectorDao sectorDao, CompanyDao companyDao) {
		super();
		this.sectorDao = sectorDao;
		this.companyDao = companyDao;
	}
	
	private String sectorMessage = "sector not found with id :";

	@Override
	public Sector addSector(Sector sector) {
		return sectorDao.save(sector);
	}

	@Override
	public List<Sector> findAllSector() {
		return sectorDao.findAll();
	}

	@Override
	public Sector findSectorById(Integer sectorId) {
		Optional<Sector> sectorOpt = sectorDao.findById(sectorId);
		if(sectorOpt.isPresent()) {
			return sectorOpt.get();
		} else {
			throw new NotFoundException(sectorMessage + sectorId);
		}
	}

	@Override
	public List<Company> findCompaniesBySectorId(Integer sectorId) {
		return companyDao.findBySectorId(sectorId);
	}

	@Override
	public void deleteSectorById(Integer sectorId) {
		sectorDao.deleteById(sectorId);
	}

	@Override
	public Company addCompany(Integer sectorId, Company company) {
		Optional<Sector> sectorOpt = sectorDao.findById(sectorId);
		return sectorOpt.map(sector -> {company.setSector(sector);
										return companyDao.save(company);})
		.orElseThrow(() -> new NotFoundException(sectorMessage + sectorId));
	}

	@Override
	public Company updateCompany(Integer sectorId, Company company) {
		Optional<Sector> sectorOpt = sectorDao.findById(sectorId);
		return sectorOpt.map(sector -> {company.setSector(sector);
										companyDao.deleteById(company.getId());
										return companyDao.save(company);})
		.orElseThrow(() -> new NotFoundException(sectorMessage + sectorId));
	}
}
