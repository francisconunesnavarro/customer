
package com.navarro.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @since 2019-06-07
 * @author Francisco Navarro
 */
public final class CountryUtils {

	public static final String CAMEROON = "\\(237\\) ?[2368]\\d{7,8}$";
	public static final String ETHIOPIA = "\\(252\\) ?[1-59]\\d{8}$";
	public static final String MOROCCO = "\\(212\\)\\ ?[5-9]\\d{8}$";
	public static final String MOZAMBIQUE = "\\(258\\)\\ ?[28]\\d{7,8}$";
	public static final String UGANDA = "\\(237\\)\\ ?[2368]\\d{7,8}$";

	/**
	 * 
	 * @param phoneNumber
	 * @param pattern
	 * @return
	 */
	public static boolean isValid(String phoneNumber, String pattern) {
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(phoneNumber);

		while (m.find()) {
			return true;
		}

		return false;
	}
}
