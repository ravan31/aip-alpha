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

import java.util.List;

import com.yin.aip.dao.QuestionnaireMapDAO;
import com.yin.aip.dao.QuestionsDAO;
import com.yin.aip.model.Question;
import com.yin.aip.model.QuestionnaireQuestionMap;

/**
 * @author Ram Vanga
 * Jun 2, 2013
 *
 */

public class QuestionsFacade {
	
	private QuestionsDAO questionsDAO = new QuestionsDAO();
	private QuestionnaireMapDAO questinnaireMapDAO = new QuestionnaireMapDAO();

	public List<Question> listQuestionsByQuestionaireID(int QRID) {
		questionsDAO.beginTransaction(); 
        List<Question> result = questionsDAO.getQuestionsForQuestionnaireID(QRID); 
        questionsDAO.commitAndCloseTransaction(); 
        return result;
	}

	public void createQuestionnaire(Question question) {
		questionsDAO.beginTransaction(); 
		questionsDAO.save(question); 
		questionsDAO.commitAndCloseTransaction();
		
	}

	public void addMappingWithQuestinnaire(int question_id, int questionnaire_id) {
		questinnaireMapDAO.beginTransaction(); 
		QuestionnaireQuestionMap QQMap = new QuestionnaireQuestionMap();
		QQMap.setQuestion_id(question_id);
		QQMap.setQuestionnaire_id(questionnaire_id);
		questinnaireMapDAO.save(QQMap);
		questinnaireMapDAO.commitAndCloseTransaction();
	}

}
