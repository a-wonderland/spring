package com.spring.wonderland.common;

import java.util.ResourceBundle;

/**
 * This class is group of common functions. Provided non-instantiated
 * constructor.
 * 
 * @author Alice
 */
public class HelperFunction {

	/**
	 * Non-instantiated constructor
	 */
	private HelperFunction() {
	}

	/**
	 * This static method is supported for checking value of Object
	 * 
	 * @param obj
	 *            to compare
	 * @return true if the obj is empty or null
	 */

	public static boolean isEmpty(Object obj) {
		if (obj == null) {
			return true;
		} else if (obj instanceof String) {
			if (((String) obj).length() < 0) {
				return true;
			}
		} else {
			return false;
		}
		return false;

	}

	/**
	 * This static method is supported for loading properties file.
	 * 
	 * @param resourceName
	 *            name of properties file
	 * @return Loaded ResourceBundle object that contain locale-specific
	 *         messages.
	 */

	public static ResourceBundle loadResource(String resourceName) {
		ResourceBundle bundle = null;
		try {
			bundle = ResourceBundle.getBundle(resourceName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bundle;
	}

	/**
	 * This static method is supported for converting java.util.Date to java.sql.Date.
	 * 
	 * @param date
	 *            java.util.Date
	 * @return java.sql.Date
	 */
	public static java.sql.Date convertToSqlDate(java.util.Date date) {
		if (!isEmpty(date)) {
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			return sqlDate;
		}

		return null;
	}

}
