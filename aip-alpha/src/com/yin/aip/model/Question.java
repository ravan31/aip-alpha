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
package com.yin.aip.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

/**
 * @author Ram Vanga
 * Jun 2, 2013
 *
 */

@Entity
@Table(name = "mm_question")

@NamedNativeQuery(name = "quesMapQuery", query ="SELECT mq.id,mq.question,mq.alloted_time,mq.type"
											+" FROM mm_question AS mq INNER JOIN mm_questionnaire_questions AS mqq"
											+" WHERE mqq.questionnaire_id=? AND mq.id=mqq.question_id",resultClass = Question.class)
public class Question  implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String question;
	private int alloted_time;
	private String  type;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public int getAlloted_time() {
		return alloted_time;
	}
	public void setAlloted_time(int alloted_time) {
		this.alloted_time = alloted_time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
