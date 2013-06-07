package com.yin.aip.mb;


import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.yin.aip.facade.ReviewerFacade;
import com.yin.aip.model.Reviewer;
@ViewScoped
@ManagedBean(name="reviewerMB")


public class ReviewerMB  extends BaseMB {
	public static final String INJECTION_NAME = "#{reviewerMB}";
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = UserMB.INJECTION_NAME) 
    private UserMB userMB;
	
	@ManagedProperty(value = PageViewMB.INJECTION_NAME) 
    private PageViewMB pageViewMB;
	
	@ManagedProperty(value = QuestionnaireMB.INJECTION_NAME) 
    private QuestionnaireMB qrMB;
	
	@ManagedProperty(value = ScheduleMB.INJECTION_NAME) 
    private ScheduleMB scheduleMB;
	
	private List<Reviewer> reviewers;
	
	public List<Reviewer> getReviewers() {
		return reviewers;
	}
	public void setReviewers(List<Reviewer> reviewers) {
		this.reviewers = reviewers;
	}
	private ReviewerFacade reviewerFacade;
	
	private Reviewer reviewer ;

	private List<String> allStatus;
	public Reviewer getReviewer() {
		return reviewer;
	}
	public void setReviewer(Reviewer reviewer) {
		this.reviewer = reviewer;
	}
	
	
	
	
	public List<String> getAllStatus() {
		
			if(allStatus == null){
				allStatus = new ArrayList<String>();
				allStatus.add("New");
				allStatus.add("Hold");
				allStatus.add("Closed");
			}
		return allStatus;
	}
	public void setAllStatus(List<String> allStatus) {
		this.allStatus = allStatus;
	}
	public ReviewerFacade getReviewerFacade() {
		return reviewerFacade;
	}
	public void setReviewerFacade(ReviewerFacade reviewerFacade) {
		this.reviewerFacade = reviewerFacade;
	}
	
}

