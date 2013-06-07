/*************************************************************************
 * CONFIDENTIAL
 * __________________
 * [2013] - Yinsol - All Rights Reserved.
 * 
 * NOTICE:  All information contained herein is, and remains
 * the property of Yinsol and its suppliers, if any.  
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Yinsol.
 */
package com.yin.aip.util;

import java.sql.Date;

/**
 * @author Ram Vanga
 * Jun 1, 2013
 *
 */

public class DateUtil {

	public static Date getCurrentDate(){
		java.util.Date utilDate = new java.util.Date();
	    return new java.sql.Date(utilDate.getTime());
	}
}
