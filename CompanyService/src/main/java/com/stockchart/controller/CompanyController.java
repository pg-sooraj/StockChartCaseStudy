package com.stockchart.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockchart.entity.Company;
import com.stockchart.entity.Director;
import com.stockchart.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {
	
	private CompanyService companyService;
	
	public CompanyController(CompanyService companyService) {
		super();
		this.companyService = companyService;
	}
		
	@GetMapping("/all")
	public ResponseEntity<List<Company>> findAll(){
		return new ResponseEntity<>(companyService.findAllCompany(), HttpStatus.OK);
	}
	
	@GetMapping("/{companyId}")
	public ResponseEntity<Company> findById(@PathVariable("companyId") Integer companyId){
		return new ResponseEntity<>(companyService.findCompanyById(companyId), HttpStatus.OK);
	}
	
	@PostMapping("/{companyId}/addDirector")
	public ResponseEntity<Director> addDirectors(@PathVariable("companyId") Integer companyId,
												@RequestBody Director director){
		return new ResponseEntity<>(companyService.addDirector(companyId, director), HttpStatus.OK);
    }
	
	@GetMapping("/{companyId}/directors")
	public ResponseEntity<List<Director>> findDirectors(@PathVariable("companyId") Integer companyId){
		return new ResponseEntity<>(companyService.findDirectorsByCompanyId(companyId), HttpStatus.OK);
	}
}
