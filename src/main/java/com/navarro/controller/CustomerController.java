package com.navarro.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.navarro.model.Customer;
import com.navarro.services.CustomerServiceImpl;

/**
 *
 * @since 2019-06-07
 * @author Francisco Navarro
 */
@Controller
public class CustomerController {

	@Autowired
	private CustomerServiceImpl customerService;

	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public String findAll(Model model, @RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "100") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		model.addAttribute("customers", customerService.findAll(page, linesPerPage, orderBy, direction));
		return "customers";
	}

	@RequestMapping(value = "/customers/search", method = RequestMethod.GET)
	public ResponseEntity<Page<Customer>> findByCountryAndState(
			@RequestParam(value = "countryCode", required = false) String countryCode,
			@RequestParam(value = "state", required = false) Boolean state,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "20") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {

		Page<Customer> pCustomer = new PageImpl<Customer>(new ArrayList<Customer>());

		if (state != null && countryCode != null) {
			pCustomer = customerService.findByCountryAndState(countryCode, state, page, linesPerPage, orderBy,
					direction);
		} else if (state != null) {
			pCustomer = customerService.findByState(state, page, linesPerPage, orderBy, direction);
		} else if (countryCode != null) {
			pCustomer = customerService.findByCountry(countryCode, page, linesPerPage, orderBy, direction);
		}

		return pCustomer != null ? ResponseEntity.ok().body(pCustomer) : new ResponseEntity<>(pCustomer, HttpStatus.OK);
	}

}
