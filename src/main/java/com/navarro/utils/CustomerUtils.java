
package com.navarro.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import com.navarro.model.Country;
import com.navarro.model.CountryEnum;
import com.navarro.model.Customer;

/**
 *
 * @since 2019-06-08
 * @author Francisco Navarro
 */
public final class CustomerUtils {

	/**
	 * 
	 * @param lstCustomer
	 * @return
	 */
	public static Page<Customer> getPageCustomer(List<Customer> lstCustomer) {
		return new PageImpl<Customer>(lstCustomer);
	}

	/**
	 * 
	 * @param lstCustomer
	 * @param pageRequest
	 * @return
	 */
	public static Page<Customer> getPageCustomer(List<Customer> lstCustomer, PageRequest pageRequest) {
		int start = (int) pageRequest.getOffset();
		int end = (int) (start + pageRequest.getPageSize()) > lstCustomer.size() ? lstCustomer.size()
				: (start + pageRequest.getPageSize());
		Page<Customer> pCustomer = new PageImpl<Customer>(lstCustomer.subList(start, end), pageRequest,
				lstCustomer.size());

		return pCustomer;
	}

	/**
	 * 
	 * @param lstCustomer
	 * @return
	 */
	public static final Page<Customer> setCountry(List<Customer> lstCustomer) {
		lstCustomer = insPhoneCountryCode(lstCustomer);
		lstCustomer = insCountry(lstCustomer);
		lstCustomer = insIsState(lstCustomer);

		Page<Customer> pCustomer = new PageImpl<Customer>(lstCustomer);

		return pCustomer;
	}

	/**
	 * 
	 * @param lstCustomer
	 * @param pageRequest
	 * @return
	 */
	public static final Page<Customer> setCountry(List<Customer> lstCustomer, PageRequest pageRequest) {
		lstCustomer = insPhoneCountryCode(lstCustomer);
		lstCustomer = insCountry(lstCustomer);
		lstCustomer = insIsState(lstCustomer);

		return CustomerUtils.getPageCustomer(lstCustomer, pageRequest);
	}

	/**
	 * 
	 * @param lstCustomerParam
	 * @return
	 */
	public static final List<Customer> insPhoneCountryCode(List<Customer> lstCustomerParam) {
		List<Customer> lstCustomer = new ArrayList<Customer>(lstCustomerParam);

		lstCustomerParam.stream().map((customer) -> {
			customer.setPhoneCountryCode(customer.getPhone().replaceAll("[()]", "").substring(0, 3));
			return customer;
		}).forEach((costumer) -> {
			lstCustomer.set(lstCustomerParam.indexOf(costumer), costumer);
		});

		return lstCustomer;
	}

	/**
	 * 
	 * @param lstCustomerParam
	 * @return
	 */
	public static final List<Customer> insCountry(List<Customer> lstCustomerParam) {
		List<Customer> lstCustomer = new ArrayList<Customer>(lstCustomerParam);

		lstCustomerParam.stream().map((customer) -> {
			Country country = new Country();

			for (CountryEnum countryEnum : CountryEnum.values()) {
				if (customer.getPhoneCountryCode().equals(countryEnum.getCountryCode())) {
					country.setCode(countryEnum.getCountryCode());
					country.setName(countryEnum.name());
				}
			}

			customer.setCountry(country);
			return customer;
		}).forEach((costumer) -> {
			lstCustomer.set(lstCustomerParam.indexOf(costumer), costumer);
		});

		return lstCustomer;
	}

	/**
	 * 
	 * @param lstCustomerParam
	 * @return
	 */
	public static final List<Customer> insIsState(List<Customer> lstCustomerParam) {
		List<Customer> lstCustomer = new ArrayList<Customer>(lstCustomerParam);

		lstCustomerParam.forEach((customer) -> {
			for (CountryEnum countryEnum : CountryEnum.values()) {
				if (customer.getCountry().getName().equals(countryEnum.name())) {
					if (CountryUtils.isValid(customer.getPhone(), countryEnum.getRegex())) {
						customer.setState(true);
					} else {
						customer.setState(false);
					}
					lstCustomer.set(lstCustomerParam.indexOf(customer), customer);
				}
			}
		});

		return lstCustomer;
	}

}
