package com.navarro.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.navarro.utils.CountryUtils;

/**
 *
 * @since 2019-06-08
 * @author Francisco Navarro
 */
public class CountryUtilsTest {

	@Test
	public void testAssertRegexPerCountry() {
		assertEquals(CountryUtils.CAMEROON, "\\(237\\) ?[2368]\\d{7,8}$");
		assertEquals(CountryUtils.ETHIOPIA, "\\(252\\) ?[1-59]\\d{8}$");
		assertEquals(CountryUtils.MOROCCO, "\\(212\\)\\ ?[5-9]\\d{8}$");
		assertEquals(CountryUtils.MOZAMBIQUE, "\\(258\\)\\ ?[28]\\d{7,8}$");
		assertEquals(CountryUtils.UGANDA, "\\(237\\)\\ ?[2368]\\d{7,8}$");
	}

	@Test
	public void testAssertTrueRegexPerCountry() {
		assertTrue(CountryUtils.isValid("(237) 673122155", CountryUtils.CAMEROON));
		assertTrue(CountryUtils.isValid("(251) 911203317", CountryUtils.ETHIOPIA));
		assertTrue(CountryUtils.isValid("(212) 6007989253", CountryUtils.MOROCCO));
		assertTrue(CountryUtils.isValid("(258) 847651504", CountryUtils.MOZAMBIQUE));
		assertTrue(CountryUtils.isValid("(256) 7734127498", CountryUtils.UGANDA));
	}

}
