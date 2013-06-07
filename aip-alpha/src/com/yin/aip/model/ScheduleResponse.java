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
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Ram Vanga
 * Jun 2, 2013
 *
 */
@Entity
@Table(name = "mm_schedule_response")
public class ScheduleResponse implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int job_id;
	private int schedule_id;
	private int questionnaire_id;
	private String email;
	private String reviewer;
	private Date recieved_on;
	private String updated_by;
	private Date updated_on;
	private String status;
	
	public Date getRecieved_on() {
		return recieved_on;
	}
	public void setRecieved_on(Date recieved_on) {
		this.recieved_on = new java.sql.Date(recieved_on.getTime());
	}
	public String getUpdated_by() {
		return updated_by;
	}
	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}
	public Date getUpdated_on() {
		return updated_on;
	}
	public void setUpdated_on(Date updated_on) {
		this.updated_on = new java.sql.Date(updated_on.getTime());
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getJob_id() {
		return job_id;
	}
	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}
	public int getSchedule_id() {
		return schedule_id;
	}
	public void setSchedule_id(int schedule_id) {
		this.schedule_id = schedule_id;
	}
	public int getQuestionnaire_id() {
		return questionnaire_id;
	}
	public void setQuestionnaire_id(int questionnaire_id) {
		this.questionnaire_id = questionnaire_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getReviewer() {
		return reviewer;
	}
	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}
	
}
