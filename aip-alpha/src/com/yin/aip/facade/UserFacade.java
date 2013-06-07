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
package com.yin.aip.facade;

import com.yin.aip.dao.UserDAO;
import com.yin.aip.model.User;

/**
 * @author Ram Vanga 
 * @date May 21, 2013
 * 
 */
public class UserFacade {

	private UserDAO userDAO = new UserDAO();

	/**
	 * Validates loging with email & password
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	public User isValidLogin(String email, String password) {
		userDAO.beginTransaction();
		User user = userDAO.findUserByEmail(email);

		if (user == null || !user.getPassword().equals(password)) {
			return null;
		}

		return user;
	}
	
}
