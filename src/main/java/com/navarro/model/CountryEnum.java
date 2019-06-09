package com.navarro.model;

import com.navarro.utils.CountryUtils;

/**
 *
 * @since 2019-06-07
 * @author Francisco Navarro
 */
public enum CountryEnum {

	Cameroon("237", CountryUtils.CAMEROON), 
	Ethiopia("251", CountryUtils.ETHIOPIA),
	Morocco("212", CountryUtils.MOROCCO), 
	Mozambique("258", CountryUtils.MOZAMBIQUE),
	Uganda("256", CountryUtils.UGANDA);

	private final String countryCode;
	private final String regex;

	CountryEnum(String countryCode, String regex) {
		this.countryCode = countryCode;
		this.regex = regex;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public String getRegex() {
		return this.regex;
	}
}
