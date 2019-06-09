package com.navarro.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.navarro.model.CountryEnum;
import com.navarro.model.Customer;

/**
 *
 * @since 2019-06-08
 * @author Francisco Navarro
 */
public class CustomerUtilsTest {

	private List<Customer> mockedLstCustomers() {
		List<Customer> lstCustomer = new ArrayList<Customer>();
		List<String> lstPhone = new ArrayList<String>();

		lstPhone.add("(237) 673122155");
		lstPhone.add("(251) 911203317");
		lstPhone.add("(212) 6007989253");
		lstPhone.add("(258) 847651504");
		lstPhone.add("(256) 7734127498");

		for (int i = 0; i < lstPhone.size(); i++) {
			Customer customer = new Customer();
			customer.setPhone(lstPhone.get(i));
			lstCustomer.add(customer);
		}

		return lstCustomer;
	}

	@Test
	public void insPhoneCountryCode() {
		List<Customer> lstCustomer = this.mockedLstCustomers();
		lstCustomer = CustomerUtils.insPhoneCountryCode(lstCustomer);

		assertEquals(lstCustomer.get(0).getPhoneCountryCode(), "237");
		assertEquals(lstCustomer.get(1).getPhoneCountryCode(), "251");
		assertEquals(lstCustomer.get(2).getPhoneCountryCode(), "212");
		assertEquals(lstCustomer.get(3).getPhoneCountryCode(), "258");
		assertEquals(lstCustomer.get(4).getPhoneCountryCode(), "256");
	}

	@Test
	public void insCountry() {
		List<Customer> lstCustomer = this.mockedLstCustomers();
		lstCustomer = CustomerUtils.insPhoneCountryCode(lstCustomer);
		lstCustomer = CustomerUtils.insCountry(lstCustomer);

		Map<String, String> mCountriesDefault = new HashMap<String, String>();
		mCountriesDefault.put(CountryEnum.Cameroon.getCountryCode(), CountryEnum.Cameroon.name());
		mCountriesDefault.put(CountryEnum.Ethiopia.getCountryCode(), CountryEnum.Ethiopia.name());
		mCountriesDefault.put(CountryEnum.Morocco.getCountryCode(), CountryEnum.Morocco.name());
		mCountriesDefault.put(CountryEnum.Mozambique.getCountryCode(), CountryEnum.Mozambique.name());
		mCountriesDefault.put(CountryEnum.Uganda.getCountryCode(), CountryEnum.Uganda.name());

		Map<String, String> mCountries = new HashMap<String, String>();
		mCountries.put(lstCustomer.get(0).getCountry().getCode(), lstCustomer.get(0).getCountry().getName());
		mCountries.put(lstCustomer.get(1).getCountry().getCode(), lstCustomer.get(1).getCountry().getName());
		mCountries.put(lstCustomer.get(2).getCountry().getCode(), lstCustomer.get(2).getCountry().getName());
		mCountries.put(lstCustomer.get(3).getCountry().getCode(), lstCustomer.get(3).getCountry().getName());
		mCountries.put(lstCustomer.get(4).getCountry().getCode(), lstCustomer.get(4).getCountry().getName());
		assertTrue(mCountriesDefault.equals(mCountries));
	}

	@Test
	public void includeIsValid() {
		List<Customer> lstCustomer = this.mockedLstCustomers();
		lstCustomer = CustomerUtils.insPhoneCountryCode(lstCustomer);
		lstCustomer = CustomerUtils.insCountry(lstCustomer);
		lstCustomer = CustomerUtils.insIsState(lstCustomer);

		assertEquals(lstCustomer.get(0).getState(), true);
		assertEquals(lstCustomer.get(1).getState(), true);
		assertEquals(lstCustomer.get(2).getState(), false);
		assertEquals(lstCustomer.get(3).getState(), true);
		assertEquals(lstCustomer.get(4).getState(), false);

	}

}
