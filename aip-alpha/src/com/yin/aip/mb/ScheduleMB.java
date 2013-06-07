package com.yin.aip.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.yin.aip.facade.ScheduleFacade;
import com.yin.aip.model.Schedule;
import com.yin.aip.util.DateUtil;

@ViewScoped
@ManagedBean(name="scheduleMB")
public class ScheduleMB extends BaseMB  { 
	
	public static final String INJECTION_NAME = "#{scheduleMB}";
	
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = UserMB.INJECTION_NAME) 
    private UserMB userMB;
	
	@ManagedProperty(value = PageViewMB.INJECTION_NAME) 
    private PageViewMB pageViewMB;
	
	
	

	private List<Schedule> schedules;
	private ScheduleFacade scheduleFacade;
	private Schedule schedule;
	private java.util.Date current_date;
	
	public Schedule getSchedule() {
		if(schedule == null)
			schedule = new Schedule();
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public List<Schedule> getAllScheduleResponses() { 
		if (schedules == null) { 
			loadScheduls(); 
        }  
        return schedules; 
    }
	
	public ScheduleFacade getScheduleFacade() { 
       
		if (scheduleFacade == null) { 
			scheduleFacade = new ScheduleFacade(); 
        } 
        return scheduleFacade; 
    } 
	
	private void loadScheduls() { 
		schedules = getScheduleFacade().listAll(); 
	}
	
	
	public void resetSchedule() { 
        schedule = new Schedule(); 
    } 
	
	public UserMB getUserMB() {
		return userMB;
	}

	public void setUserMB(UserMB userMB) {
		this.userMB = userMB;
	}

	public PageViewMB getPageViewMB() {
		return pageViewMB;
	}

	public void setPageViewMB(PageViewMB pageViewMB) {
		this.pageViewMB = pageViewMB;
	}
	
	public java.util.Date getCurrent_date() {
		current_date = DateUtil.getCurrentDate();
		return current_date;
	}

	public void setCurrent_date(java.util.Date current_date) {
		this.current_date = current_date;
	}

}
