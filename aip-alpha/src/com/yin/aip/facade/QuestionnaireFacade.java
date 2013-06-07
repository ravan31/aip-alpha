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

import java.io.Serializable;
import java.util.List;

import com.yin.aip.dao.QuestionnaireDAO;
import com.yin.aip.model.Questionnaire;
import com.yin.aip.util.AIPConstants;

/**
 * @author Ram Vanga
 * Jun 2, 2013
 *
 */

public class QuestionnaireFacade implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private QuestionnaireDAO questionnaireDAO = QuestionnaireDAO.getInstance();// new QuestionnaireDAO();

	public List<Questionnaire> listAll() {
		questionnaireDAO.beginTransaction(); 
        List<Questionnaire> result = questionnaireDAO.findAllSorted(AIPConstants.CREATED_ON); 
        questionnaireDAO.commitAndCloseTransaction(); 
        return result;
	}
	
	public List<Questionnaire> listAllPublished() {
		questionnaireDAO.beginTransaction(); 
        List<Questionnaire> result = questionnaireDAO.findAllWhere(AIPConstants.STATUS,AIPConstants.QUESTIONNAIRE_STATUS.LOCKED.toString()); 
        questionnaireDAO.commitAndCloseTransaction(); 
        return result;
	}

	public void createQuestionnaire(Questionnaire questionnaire) {
		questionnaireDAO.beginTransaction(); 
		questionnaireDAO.save(questionnaire); 
		questionnaireDAO.commitAndCloseTransaction();
		
	}
	
	public void updateQuestionnaire(Questionnaire questionnaire) {
		questionnaireDAO.beginTransaction(); 
		questionnaireDAO.update(questionnaire); 
		questionnaireDAO.commitAndCloseTransaction();
		
	}

}
