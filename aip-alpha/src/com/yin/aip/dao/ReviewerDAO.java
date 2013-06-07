package com.yin.aip.dao;


import com.yin.aip.model.Reviewer;

/**
 * @author hari 
 * @date jun 7, 2013
 * 
 */
public class ReviewerDAO extends GenericDAO<Reviewer> {
	private static final long serialVersionUID = 1L;

	private static  ReviewerDAO instance = null;
	/**
	 * Construcor
	 */
	protected  ReviewerDAO() {
		super(Reviewer.class);
	}
	
	public static ReviewerDAO getInstance() {
		if (instance == null) {
			instance = new ReviewerDAO();
		}
		return instance;
	}

}
