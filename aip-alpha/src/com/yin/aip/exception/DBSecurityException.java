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
package com.yin.aip.exception;

/**
 * @author Ram Vanga
 * May 21, 2013
 *
 */

public class DBSecurityException extends Exception {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Construcor
	 */
	public DBSecurityException() { super(); }
    /**
     * Construcor
     * @param s
     */
    public DBSecurityException(String s) { super(s); }


}
