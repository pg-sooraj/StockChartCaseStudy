package com.stockchart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.stockchart.dao.CompanyDao;
import com.stockchart.dao.DirectorDao;
import com.stockchart.entity.Company;
import com.stockchart.entity.Director;
import com.stockchart.exception.NotFoundException;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	CompanyDao companyDao;
	DirectorDao directorDao;
	
	public CompanyServiceImpl(CompanyDao companyDao, DirectorDao directorDao) {
		super();
		this.companyDao = companyDao;
		this.directorDao = directorDao;
	}
	
	private String message = "company not found with id :";

	@Override
	public Company findCompanyById(Integer companyId) {
		Optional<Company> companyOpt = companyDao.findById(companyId);
		if(companyOpt.isPresent()) {
			return companyOpt.get();
		} else {
			throw new NotFoundException(message + companyId);
		}
	}

	@Override
	public List<Company> findAllCompany() {
		return companyDao.findAll();
	}

	@Override
	public List<Director> findDirectorsByCompanyId(Integer companyId) {
		return directorDao.findByCompanyId(companyId);
	}

	@Override
	public Director addDirector(Integer companyId, Director director) {
		Optional<Company> companyOpt = companyDao.findById(companyId);
		return companyOpt.map(company -> {director.setCompany(company);
										return directorDao.save(director);})
		.orElseThrow(() -> new NotFoundException(message + companyId));
	}
}
