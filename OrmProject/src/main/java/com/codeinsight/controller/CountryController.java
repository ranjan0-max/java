package com.codeinsight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codeinsight.entity.Country;
import com.codeinsight.service.CountryService;

@RestController
public class CountryController {

	@Autowired
	private CountryService countryService;

	@GetMapping("/country")
	public List<Country> getAllCountry() {
		List<Country> countryList = countryService.getAllCountry();
		return countryList;
	}

	@DeleteMapping("/country/{id}")
	public void deleteCountry(@PathVariable Integer id) {
		boolean deleteCountry = countryService.deleteCountry(id);
		if (deleteCountry) {
			System.out.println("user deleted");
		} else {
			System.out.println("user Not present");
		}
	}
	
	@PostMapping("/country")
	public void insertCountry(@RequestBody Country country) {
		countryService.insertCountry(country);
	}
	
	@PutMapping("/Country")
	public void updateCountry(@RequestBody Country country) {
		countryService.updateCountry(country);
	}
}
