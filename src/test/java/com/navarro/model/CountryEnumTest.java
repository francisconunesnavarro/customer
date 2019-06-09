package com.navarro.model;

import com.navarro.model.CountryEnum;
import com.navarro.utils.CountryUtils;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @since 2019-06-08
 * @author Francisco Navarro
 */
@RunWith(SpringRunner.class)
public class CountryEnumTest {

	@Test
	public void testAssertCountryPerCountryEnum() {
		assertEquals("212", CountryEnum.Morocco.getCountryCode());
		assertEquals("237", CountryEnum.Cameroon.getCountryCode());
		assertEquals("251", CountryEnum.Ethiopia.getCountryCode());
		assertEquals("256", CountryEnum.Uganda.getCountryCode());
		assertEquals("258", CountryEnum.Mozambique.getCountryCode());
		assertEquals("260", CountryEnum.Mozambique.getCountryCode());
	}

	@Test
	public void testAssertRegexPerCountryEnum() {
		assertEquals(CountryUtils.CAMEROON, CountryEnum.Cameroon.getRegex());
		assertEquals(CountryUtils.ETHIOPIA, CountryEnum.Ethiopia.getRegex());
		assertEquals(CountryUtils.MOROCCO, CountryEnum.Morocco.getRegex());
		assertEquals(CountryUtils.MOZAMBIQUE, CountryEnum.Mozambique.getRegex());
		assertEquals(CountryUtils.UGANDA, CountryEnum.Uganda.getRegex());
	}
}
