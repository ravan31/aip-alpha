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

/**
 * @author Ram Vanga
 * @date May 21, 2013
 * 
 */
public interface AIPConstants {

	// JPA & Session Constants
	public static final String FIND_BY_EMAIL = "User.findUserByEmail";
	public static final String FIND_BY_PASSWORD = "User.findUserByPassword";
	public static final String USER = "user";
	public static final String ADMIN = "ADMIN";
	public static final String RECRUITER = "RECRUITER";
	public static final String REVIEWER = "REVIEWER";
	public static final String SUBUSER = "SUBUSER";
	public static final String CREATED_QUESTIONNAIRE = "CreatedQuestionaire";
	

	// Page - constants
	static String PAGE_LOGIN = "index.xhtml";
	static String PAGE_LOGOUT = "../index.xhtml";
	static String PAGE_INDEX = "pages/master-layout.xhtml";

	public enum QUESTIONNAIRE_STATUS {
		NEW,DEPRICATED,LOCKED; // ; is optional
	}
	
	public enum INVITE_STATUS {
		NEW,CLOSED,INVITED; // ; is optional
	} 
	
	//Order By Columns
	public String CREATED_ON="created_on";
	public String RECIEVED_ON="recieved_on";

	//where clause columns
	public static final String STATUS = "status";

}
