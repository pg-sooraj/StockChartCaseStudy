package com.stockchart.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.stockchart.entity.Company;
import com.stockchart.entity.Sector;
import com.stockchart.service.SectorService;

@RestController
@RequestMapping("/sector")
public class SectorController {
	
	private SectorService sectorService;
	
	public SectorController(SectorService sectorService) {
		super();
		this.sectorService = sectorService;
	}

	@PostMapping("/add")
	public ResponseEntity<Sector> addSector(@RequestBody Sector sector){
		return new ResponseEntity<>(sectorService.addSector(sector), HttpStatus.OK);
    }
	
	@PostMapping("/{sectorId}/addCompany")
	public ResponseEntity<Company> addCompany(@PathVariable("sectorId") Integer sectorId, @RequestBody Company company){
		return new ResponseEntity<>(sectorService.addCompany(sectorId, company), HttpStatus.OK);
    }
			
	@GetMapping("/all")
	public ResponseEntity<List<Sector>> findAll(){
		return new ResponseEntity<>(sectorService.findAllSector(), HttpStatus.OK);
	}
	
	@GetMapping("/{sectorId}")
	public ResponseEntity<Sector> findById(@PathVariable("sectorId") Integer sectorId){
		return new ResponseEntity<>(sectorService.findSectorById(sectorId), HttpStatus.OK);
	}
	
	@GetMapping("/{sectorId}/companies")
	public ResponseEntity<List<Company>> findCompanies(@PathVariable("sectorId") Integer sectorId){
		return new ResponseEntity<>(sectorService.findCompaniesBySectorId(sectorId), HttpStatus.OK);
	}
		
	@DeleteMapping("/delete/{sectorId}")
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteCompanyById(@PathVariable("sectorId") Integer sectorId){
		sectorService.deleteSectorById(sectorId);
	}
}
