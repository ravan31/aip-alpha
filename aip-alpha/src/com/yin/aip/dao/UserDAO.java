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
package com.yin.aip.dao;

import java.util.HashMap;
import java.util.Map;

import com.yin.aip.model.User;
import com.yin.aip.util.AIPConstants;

/**
 * @author Ram Vanga May 21, 2013
 * 
 */
public class UserDAO extends GenericDAO<User> {

	private static final long serialVersionUID = 1L;

	/**
	 * Construcor
	 */
	public UserDAO() {
		super(User.class);
	}

	/**
	 * Fetch a user from core_db which mas with the provided email
	 * @param email
	 * @return
	 */
	public User findUserByEmail(String email) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("email", email);

		return super.findOneResult(AIPConstants.FIND_BY_EMAIL, parameters);
	}
	
	public User findUserByPassword(String password) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("password", password);

		return super.findOneResult(AIPConstants.FIND_BY_PASSWORD, parameters);
	}
}
