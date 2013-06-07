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
package com.yin.aip.security;

/**
 * @author Ram Vanga May 20, 2013
 * 
 */

public interface IPrivelege {

	
	public static final long SUPER_ACCESS = (long)Math.pow(2, 50); // can assign a max of 50 different permissions
	public static final long NO_ACCESS = 0; // with this, nothing is allowed
	public static final long AIP_ACCESS =(long)Math.pow(2, 0);
	public static final long USER_MGNT_ACCESS =(long)Math.pow(2, 1);
	public static final long SCHEDULE_MGNT_ACCESS =(long)Math.pow(2, 2);
	
}
