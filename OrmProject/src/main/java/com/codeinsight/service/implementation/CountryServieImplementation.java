package com.codeinsight.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codeinsight.dao.CountryDao;
import com.codeinsight.entity.Country;
import com.codeinsight.service.CountryService;

@Service
public class CountryServieImplementation implements CountryService{

	@Autowired
	private CountryDao countryDao;

	@Transactional
	public List<Country> getAllCountry() {
		List<Country> countryList = countryDao.getAllCountry();
		return countryList;
	}
	
	@Transactional
	public Country findCountryById(Integer Id) {
		Country country = countryDao.findCountryById(Id);
		return country;
	}

	@Transactional
	public boolean deleteCountry(Integer id) {
		boolean deleteCountry = countryDao.deleteCountry(id);
		return deleteCountry;
	}

	@Transactional
	public void insertCountry(Country country) {
		countryDao.insertCountry(country);
	}

	@Transactional
	public void updateCountry(Country country) {
		countryDao.updateCountry(country);
	}
}
