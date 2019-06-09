package com.navarro.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.navarro.model.Customer;
import com.navarro.repository.CustomerRepository;
import com.navarro.utils.CustomerUtils;

/**
 *
 * @since 2019-06-07
 * @author Francisco Navarro
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	/**
	 * 
	 * @return
	 */
	public Page<Customer> findAll() {
		return CustomerUtils.setCountry(customerRepository.findAll());
	}

	/**
	 * 
	 * @param page
	 * @param linesPerPage
	 * @param orderBy
	 * @param direction
	 * @return
	 */
	@Override
	public Page<Customer> findAll(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

		return CustomerUtils.setCountry(customerRepository.findAll(), pageRequest);
	}

	/**
	 * 
	 * @param countryCode
	 * @param state
	 * @param page
	 * @param linesPerPage
	 * @param orderBy
	 * @param direction
	 * @return
	 */
	@Override
	public Page<Customer> findByCountryAndState(String countryCode, Boolean state, Integer page, Integer linesPerPage,
			String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

		List<Customer> lstCustomerByState = this.findByState(state);
		List<Customer> lstCustomerByCountry = this.findByCountry(countryCode);
		List<Customer> lstCustomer = lstCustomerByState.stream().filter(lstCustomerByCountry::contains)
				.collect(Collectors.toList());

		return CustomerUtils.getPageCustomer(lstCustomer, pageRequest);
	}

	/**
	 * 
	 * @param countryCode
	 * @return
	 */
	@Override
	public List<Customer> findByCountry(String countryCode) {
		return this.findAll().stream().filter(customer -> customer.getPhoneCountryCode().equals(countryCode))
				.collect(Collectors.toList());
	}

	/**
	 * 
	 * @param countryCode
	 * @param page
	 * @param linesPerPage
	 * @param orderBy
	 * @param direction
	 * @return
	 */
	@Override
	public Page<Customer> findByCountry(String countryCode, Integer page, Integer linesPerPage, String orderBy,
			String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Customer> lstCustomer = this.findAll().stream()
				.filter(customer -> customer.getPhoneCountryCode().equals(countryCode)).collect(Collectors.toList());

		return CustomerUtils.getPageCustomer(lstCustomer, pageRequest);
	}

	/**
	 * 
	 * @param state
	 * @return
	 */
	@Override
	public List<Customer> findByState(Boolean state) {
		return this.findAll().stream().filter(customer -> customer.getState().equals(state))
				.collect(Collectors.toList());
	}

	/**
	 * 
	 * @param state
	 * @param page
	 * @param linesPerPage
	 * @param orderBy
	 * @param direction
	 * @return
	 */
	@Override
	public Page<Customer> findByState(Boolean state, Integer page, Integer linesPerPage, String orderBy,
			String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Customer> lstCustomer = this.findAll().stream().filter(customer -> customer.getState().equals(state))
				.collect(Collectors.toList());

		return CustomerUtils.getPageCustomer(lstCustomer, pageRequest);
	}

}
