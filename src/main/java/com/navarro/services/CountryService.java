package com.navarro.services;

import java.util.List;

import com.navarro.model.Country;

/**
 *
 * @since 2019-06-07
 * @author Francisco Navarro
 */
public interface CountryService {

	List<Country> findAll();

	Country find(String countryCode);

}
