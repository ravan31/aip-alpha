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

import java.util.ArrayList;
import java.util.List;

import com.yin.aip.dao.QuestionTypesDAO;
import com.yin.aip.model.QuestionType;

/**
 * @author Ram Vanga
 * Jun 2, 2013
 *
 */

public class QuestionTypesFacade {
	
	private QuestionTypesDAO questionTypesDAO = new QuestionTypesDAO();

	
	public List<String> listAll() {
		List<String> questionList = new ArrayList<>();
		questionTypesDAO.beginTransaction(); 
        List<QuestionType> result = questionTypesDAO.findAll(); 
        for(QuestionType type:result){
        	questionList.add(type.getName());
        }
        questionTypesDAO.closeTransaction(); 
        return questionList;
	}
}
