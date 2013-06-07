package com.yin.aip.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mm_questionnaire_questions")
public class QuestionnaireQuestionMap {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private int id; 
	
	private int question_id;
	private int questionnaire_id;
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public int getQuestionnaire_id() {
		return questionnaire_id;
	}
	public void setQuestionnaire_id(int questionnaire_id) {
		this.questionnaire_id = questionnaire_id;
	}

}
