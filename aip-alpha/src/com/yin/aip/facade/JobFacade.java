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

import com.yin.aip.dao.JobDAO;
import com.yin.aip.model.Job;
import com.yin.aip.util.AIPConstants;


/**
 * @author Ram Vanga 
 * @date May 21, 2013
 * 
 */
public class JobFacade {

	private JobDAO jobDAO = JobDAO.getInstance();
	
	
	public List<Job> listAll() {
		jobDAO.beginTransaction(); 
        List<Job> result = jobDAO.findAllSorted(AIPConstants.CREATED_ON); 
        jobDAO.commitAndCloseTransaction(); 
        return result;
	}

	public void createJob(Job job) {
		jobDAO.beginTransaction(); 
        jobDAO.save(job); 
        jobDAO.commitAndCloseTransaction();
		
	}

	public void updateJob(Job job) {
		jobDAO.beginTransaction(); 
        jobDAO.update(job); 
        jobDAO.commitAndCloseTransaction();
		
	}
	
}
