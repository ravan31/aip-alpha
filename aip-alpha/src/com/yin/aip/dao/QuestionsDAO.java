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

import java.util.List;

import javax.persistence.NoResultException;

import com.yin.aip.model.Question;
import com.yin.aip.util.JPAUtil;

/**
 * @author Ram Vanga
 * Jun 2, 2013
 *
 */

public class QuestionsDAO extends GenericDAO<Question> {

	private static final long serialVersionUID = 1L;
	
	private static String QUESTIONS_BY_QUESTIONNAIRE_ID="";

	/**
	 * Construcor
	 */
	public QuestionsDAO() {
		super(Question.class);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Question> getQuestionsForQuestionnaireID(int id){

		List<Question> result = null; 
		try { 
            //Query query = em.createNativeQuery("SELECT T1.* FROM mm_question AS T1 INNER JOIN mm_questionnaire_questions AS T2 WHERE T2.questionnaire_id = "+id+" AND T1.id = T2.question_id");//em.createNamedQuery(QUESTIONS_BY_QUESTIONNAIRE_ID); 
			result =  JPAUtil.getInstance().getEntityManagerFactory().createEntityManager().createNamedQuery("quesMapQuery").setParameter(1, id).getResultList(); 
        } catch (NoResultException e) { 
        	System.out.println("No result found for named query: " + QUESTIONS_BY_QUESTIONNAIRE_ID); 
        } catch (Exception e) { 
            System.out.println("Error while running query: " + e.getMessage()); 
            e.printStackTrace(); 
        } 
  
        return result;
		
	}


}
