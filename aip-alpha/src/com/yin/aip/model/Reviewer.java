package com.yin.aip.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*@Entity
@Table(name = "mm_job")
*/
public class Reviewer implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String jobTitle;
	private String questionTitle;
	private String status;
	private String response;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getId() {
		return id;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public String getQuestionTitle() {
		return questionTitle;
	}
	public String getStatus() {
		return status;
	}
	public String getResponse() {
		return response;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setResponse(String response) {
		this.response = response;
	}


}
