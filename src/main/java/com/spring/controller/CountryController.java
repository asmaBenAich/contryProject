package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dao.CountryDAO;
import com.spring.model.Country;
import com.spring.service.CountryService;

import io.swagger.annotations.Api;

@RestController
@Api(value="Hello Country", description="Hello World Controller")
public class CountryController {
	
	@Autowired
	private CountryService countryService;   
	
	@RequestMapping(value = "/getAllCountries", method = RequestMethod.GET)
	public List<Country> getCountries() {
		
		List<Country> listOfCountries = countryService.getAllCountries();
		return listOfCountries;
	}

	@RequestMapping(value = "/getCountry/{id}", method = RequestMethod.GET)
	public Country getCountryById(@PathVariable int id) {
		return countryService.getCountry(id);
	}

	@RequestMapping(value = "/addCountry", method = RequestMethod.POST)
	public void addCountry(@RequestBody Country country) {	
		countryService.addCountry(country);
		
	}

	@RequestMapping(value = "/updateCountry", method = RequestMethod.PUT)
	public void updateCountry(@RequestBody Country country) {
		countryService.updateCountry(country);
	}

	@RequestMapping(value = "/deleteCountry/{id}", method = RequestMethod.DELETE)
	public void deleteCountry(@PathVariable("id") int id) {
		countryService.deleteCountry(id);		
	}	
}
