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

import com.yin.aip.dao.ScheduleDAO;
import com.yin.aip.model.Schedule;


/**
 * @author Ram Vanga 
 * @date May 21, 2013
 * 
 */
public class ScheduleFacade {

	private ScheduleDAO scheduleDAO = new ScheduleDAO();

	// need to implement this
	public List<Schedule> listAll() {
		scheduleDAO .beginTransaction(); 
        List<Schedule> result = scheduleDAO.findAll(); 
        scheduleDAO .commitAndCloseTransaction(); 
        return result;
	}

	public void createSchedule(Schedule schedule) {
		scheduleDAO.beginTransaction(); 
		scheduleDAO.save(schedule); 
		scheduleDAO.commitAndCloseTransaction();
		
	}

}
