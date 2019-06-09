package com.navarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.navarro.model.Country;
import com.navarro.services.CountryService;

/**
 *
 * @since 2019-06-07
 * @author Francisco Navarro
 */
@RestController
public class CountryController {

	@Autowired
	private CountryService countryService;

	@RequestMapping(value = "/countries", method=RequestMethod.GET)
	public List<Country> findAll(Model model) {
		List<Country> lstCountry = countryService.findAll();
		model.addAttribute("developers", lstCountry);
		return lstCountry;
	}
	
//	@GetMapping(value = "/countries")
//	public String findAll(Model model) {
//		List<Country> lstCountry = countryService.findAll();
//		model.addAttribute("developers", lstCountry);
//		return "countries";
//	}

	@RequestMapping(value = "/countries/search")
	public Country find(@RequestParam(value = "countryCode", required = false) String countryCode) {
		return countryService.find(countryCode);
	}
}
