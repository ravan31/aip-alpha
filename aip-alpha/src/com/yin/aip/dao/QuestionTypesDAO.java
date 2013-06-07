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

import com.yin.aip.model.QuestionType;

/**
 * @author Ram Vanga
 * Jun 2, 2013
 *
 */

public class QuestionTypesDAO extends GenericDAO<QuestionType> {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 */
	public QuestionTypesDAO() {
		super(QuestionType.class);
	}
}
