package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.CountryDAO;
import com.spring.model.Country;

//@Service("countryService")
@Service
public class CountryService {

	@Autowired
	CountryDAO countryDao;
	
	@Transactional
	public List<Country> getAllCountries() {
		return countryDao.getAllCountries();
	}

	@Transactional
	public Country getCountry(int id) {
		return countryDao.getCountry(id);
	}

	@Transactional
	public Country addCountry(Country country) {
		return countryDao.addCountry(country);
	}

	@Transactional
	public void updateCountry(Country country) {
		countryDao.updateCountry(country);

	}

	@Transactional
	public void deleteCountry(int id) {
		countryDao.deleteCountry(id);
	}
}
