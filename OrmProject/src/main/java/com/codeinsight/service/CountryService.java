package com.codeinsight.service;

import java.util.List;

import com.codeinsight.entity.Country;

public interface CountryService {

	public List<Country> getAllCountry();
	
	public Country findCountryById(Integer id);
	
	public boolean deleteCountry(Integer id);
	
	public void insertCountry(Country country);
	
	public void updateCountry(Country country);
}
