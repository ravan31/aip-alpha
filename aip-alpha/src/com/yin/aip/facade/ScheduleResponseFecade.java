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

import com.yin.aip.dao.ScheduleResponseDAO;
import com.yin.aip.model.ScheduleResponse;
import com.yin.aip.util.AIPConstants;


/**
 * @author Ram Vanga 
 * @date May 21, 2013
 * 
 */
public class ScheduleResponseFecade {

	private ScheduleResponseDAO srDAO = new ScheduleResponseDAO();

	public void updateScheduleResponse(ScheduleResponse scheduleResponse) {
		srDAO.beginTransaction(); 
		srDAO.update(scheduleResponse); 
		srDAO.commitAndCloseTransaction();
	}
	public List<ScheduleResponse> listAll() {
		srDAO.beginTransaction(); 
        List<ScheduleResponse> result = srDAO.findAllSorted(AIPConstants.RECIEVED_ON); 
        srDAO.commitAndCloseTransaction(); 
        return result;
	}
	
}
