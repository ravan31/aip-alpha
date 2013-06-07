
package com.yin.aip.mb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.yin.aip.facade.ScheduleResponseFecade;
import com.yin.aip.model.ScheduleResponse;
import com.yin.aip.model.ScheduleResponseDataModel;

@ViewScoped
@ManagedBean(name="scheduleResponseMB")
public class ScheduleResponseMB extends BaseMB  { 
	
	public static final String INJECTION_NAME = "#{scheduleResponseMB}";
	
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = UserMB.INJECTION_NAME) 
    private UserMB userMB;
	
	@ManagedProperty(value = PageViewMB.INJECTION_NAME) 
    private PageViewMB pageViewMB;
	
	@ManagedProperty(value = JobMB.INJECTION_NAME) 
    private JobMB jobMB;
	
	@ManagedProperty(value = QuestionnaireMB.INJECTION_NAME) 
    private QuestionnaireMB qrMB;
	
	private List<ScheduleResponse> scheduleResponses;
	private List<ScheduleResponse> selectedScheduleResponses;
	private ScheduleResponseFecade scheduleResponseFacade;
	private ScheduleResponse scheduleResponse;
	private List<String> usersList;
	
	public List<ScheduleResponse> getSelectedScheduleResponses() {
		return selectedScheduleResponses;
	}

	public void setSelectedScheduleResponses(List<ScheduleResponse> selectedScheduleResponses) {
		this.selectedScheduleResponses = selectedScheduleResponses;
	}

	public List<String> getUsersList() {
		if(usersList == null){
			usersList = new ArrayList<String>();
			usersList.add("Ram");
			usersList.add("Raj");
			usersList.add("Ravan");
			usersList.add("Jeevan");
		}
		return usersList;
	}

	public void setUsersList(List<String> usersList) {
		this.usersList = usersList;
	}

	public ScheduleResponse getScheduleResponse() {
		if(scheduleResponse == null)
			scheduleResponse = new ScheduleResponse();
		return scheduleResponse;
	}

	public void setScheduleResponse(ScheduleResponse scheduleResponse) {
		this.scheduleResponse = scheduleResponse;
	}

	public ScheduleResponseDataModel getAllScheduleResponses() { 
		if (scheduleResponses == null) { 
            loadScheduleResponses(); 
        }  
        return new ScheduleResponseDataModel(scheduleResponses); 
    }
	
	public ScheduleResponseFecade getSchedulResponseFacade() { 
       
		if (scheduleResponseFacade == null) { 
			scheduleResponseFacade = new ScheduleResponseFecade(); 
        } 
        return scheduleResponseFacade; 
    } 
	
	private void loadScheduleResponses() { 
		scheduleResponses = getSchedulResponseFacade().listAll(); 
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
	
	public JobMB getJobMB() {
		return jobMB;
	}

	public void setJobMB(JobMB jobMB) {
		this.jobMB = jobMB;
	}

	public QuestionnaireMB getQrMB() {
		return qrMB;
	}

	public void setQrMB(QuestionnaireMB qrMB) {
		this.qrMB = qrMB;
	}

	public List<ScheduleResponse> getScheduleResponses() {
		return scheduleResponses;
	}

	public void setScheduleResponses(List<ScheduleResponse> scheduleResponses) {
		this.scheduleResponses = scheduleResponses;
	}

	public ScheduleResponseFecade getScheduleResponseFacade() {
		return scheduleResponseFacade;
	}

	public void setScheduleResponseFacade(ScheduleResponseFecade scheduleResponseFacade) {
		this.scheduleResponseFacade = scheduleResponseFacade;
	}

	public void assignToReviewer(){
		try {
			for(ScheduleResponse sr:selectedScheduleResponses){
				sr.setUpdated_by(userMB.getUser().getName());
				sr.setUpdated_on(new Date());
				getScheduleResponseFacade().updateScheduleResponse(sr);
			}
			displayInfoMessageToUser("Assigned successfully"); 
			pageViewMB.setActivePage("schedule","aip");
		} catch (Exception e) {
			displayErrorMessageToUser("Oops, Try agian later"); 
            e.printStackTrace();
			pageViewMB.setActivePage("schedule","aip");
		}
		
	}

}
