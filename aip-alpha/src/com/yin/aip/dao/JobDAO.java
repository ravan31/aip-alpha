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

import com.yin.aip.model.Job;

/**
 * @author Ram Vanga 
 * @date May 21, 2013
 * 
 */
public class JobDAO extends GenericDAO<Job> {

	private static final long serialVersionUID = 1L;

	private static JobDAO instance = null;
	/**
	 * Construcor
	 */
	protected JobDAO() {
		super(Job.class);
	}
	
	public static JobDAO getInstance() {
		if (instance == null) {
			instance = new JobDAO();
		}
		return instance;
	}

}
