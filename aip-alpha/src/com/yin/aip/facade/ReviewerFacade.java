package com.yin.aip.facade;
import java.util.List;


import com.yin.aip.dao.ReviewerDAO;

import com.yin.aip.model.Reviewer;
import com.yin.aip.util.AIPConstants;


public class ReviewerFacade {

	private ReviewerDAO reviewerDAO = ReviewerDAO.getInstance();
	
	
	public List<Reviewer> listAll() {
		reviewerDAO .beginTransaction(); 
        List<Reviewer> result = reviewerDAO .findAllSorted(AIPConstants.CREATED_ON); 
        reviewerDAO .commitAndCloseTransaction(); 
        return result;
	}

	public void createReviewer(Reviewer reviewer) {
		reviewerDAO .beginTransaction(); 
		reviewerDAO .save(reviewer); 
		reviewerDAO .commitAndCloseTransaction();
		
	}

	public void updateJob(Reviewer reviewer) {
		reviewerDAO .beginTransaction(); 
		reviewerDAO .update(reviewer); 
		reviewerDAO .commitAndCloseTransaction();
		
	}

}
