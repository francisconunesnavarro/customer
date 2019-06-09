package com.navarro.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.navarro.model.Customer;

/**
 *
 * @since 2019-06-07
 * @author Francisco Navarro
 */
public interface CustomerService {

	Page<Customer> findAll();

	Page<Customer> findAll(Integer page, Integer linesPerPage, String orderBy, String direction);

	Page<Customer> findByCountryAndState(String countryCode, Boolean state, Integer page, Integer linesPerPage,
			String orderBy, String direction);

	List<Customer> findByCountry(String countryCode);

	Page<Customer> findByCountry(String countryCode, Integer page, Integer linesPerPage, String orderBy,
			String direction);

	List<Customer> findByState(Boolean state);

	Page<Customer> findByState(Boolean state, Integer page, Integer linesPerPage, String orderBy, String direction);

}
