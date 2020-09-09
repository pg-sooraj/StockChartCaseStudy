package com.stockchart.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="sector")
public class Sector {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name="sector_name")
	private String sectorName;
	@OneToMany(mappedBy="sector", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Company> companies;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSectorName() {
		return sectorName;
	}
	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}
	public List<Company> getCompanies() {
		return companies;
	}
	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}
	public Sector(Integer id, String sectorName, List<Company> companies) {
		super();
		this.id = id;
		this.sectorName = sectorName;
		this.companies = companies;
	}
	public Sector(Integer id, String sectorName) {
		super();
		this.id = id;
		this.sectorName = sectorName;
	}
	public Sector(String sectorName) {
		super();
		this.sectorName = sectorName;
	}
	public Sector() {
		super();
	}
}
