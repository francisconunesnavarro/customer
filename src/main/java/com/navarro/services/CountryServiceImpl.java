package com.navarro.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.navarro.model.Country;
import com.navarro.model.CountryEnum;

/**
 *
 * @since 2019-06-07
 * @author Francisco Navarro
 */
@Service
public class CountryServiceImpl implements CountryService {

	@Override
	public List<Country> findAll() {
		List<Country> lstCountry = new ArrayList<Country>();

		for (CountryEnum country : CountryEnum.values()) {
			lstCountry.add(new Country(country.getCountryCode(), country.name()));
		}

		return lstCountry;
	}

	@Override
	public Country find(String countryCode) {
		List<Country> lstCountry = findAll();
		
		for (Country country : lstCountry) {
			if (country.getCode().equals(countryCode)) {
				return country;
			}
		}
		
		return new Country();
	}

}
