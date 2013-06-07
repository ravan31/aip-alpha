package com.yin.aip.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.yin.aip.facade.JobFacade;
import com.yin.aip.model.Job;
import com.yin.aip.model.JobsDataModel;
import com.yin.aip.model.Schedule;
import com.yin.aip.util.AIPConstants;
import com.yin.aip.util.DateUtil;
@ViewScoped
@ManagedBean(name="jobMB")
public class JobMB extends BaseMB  { 
	
	public static final String INJECTION_NAME = "#{jobMB}";
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = UserMB.INJECTION_NAME) 
    private UserMB userMB;
	
	@ManagedProperty(value = PageViewMB.INJECTION_NAME) 
    private PageViewMB pageViewMB;
	
	@ManagedProperty(value = QuestionnaireMB.INJECTION_NAME) 
    private QuestionnaireMB qrMB;
	
	@ManagedProperty(value = ScheduleMB.INJECTION_NAME) 
    private ScheduleMB scheduleMB;
	
	private List<Job> jobs;
	private JobFacade jobFacade;
	private Job job;
	private List<String> allStatus;
	
	public Job getJob() {
		if(job == null)
			job = new Job();
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public JobsDataModel getAllJobs() { 
		job = null;
        loadJobs(); 
        return new JobsDataModel(jobs); 
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
	
	public JobFacade getJobFacade() { 
		if (jobFacade == null) { 
        	jobFacade = new JobFacade(); 
        } 
        return jobFacade; 
    } 
	
	private void loadJobs() { 
		jobs = getJobFacade().listAll(); 
	}
	
	public void saveJob(){
		 try { 
			 	job.setCreated_by(userMB.getUser().getName());
			 	job.setCreated_on(DateUtil.getCurrentDate());
			 	if(job.getStatus()==null)
			 		job.setStatus(AIPConstants.INVITE_STATUS.NEW.toString());
			 	getJobFacade().createJob(job); 
	            displayInfoMessageToUser("Created With Sucess"); 
	            pageViewMB.setActivePage("job","aip");
	        } catch (Exception e) { 
	            displayErrorMessageToUser("Ops, we could not create. Try again later"); 
	            e.printStackTrace();
	            pageViewMB.setActivePage("job-create","actions");
	        } 
		
	}
	public void editJob(){
		 try { 
			 	job.setCreated_by(userMB.getUser().getName());
			 	job.setCreated_on(DateUtil.getCurrentDate());
			 	getJobFacade().updateJob(job); 
	            displayInfoMessageToUser("Created With Sucess"); 
	            pageViewMB.setActivePage("job","aip");
	        } catch (Exception e) { 
	            displayErrorMessageToUser("Ops, we could not create. Try again later"); 
	            e.printStackTrace();
	            pageViewMB.setActivePage("job-edit","actions");
	        } 
		
	}
	
	public void updateStatus(String status){
		 try { 
			 	job.setStatus(status);
			 	job.setUpdated_on(DateUtil.getCurrentDate());
			 	getJobFacade().updateJob(job); 
	        } catch (Exception e) { 
	            displayErrorMessageToUser("Oops, Try again later"); 
	            e.printStackTrace();
	        } 
		
	}
	
	public void createJob(){
			job = null;
			pageViewMB.setActivePage("job-create","actions");
	}
	public void resetJob() { 
        job = new Job(); 
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
	
	public void loadInvitePage(){
		if(scheduleMB.getSchedule() == null)
			scheduleMB.setSchedule(new Schedule());
		scheduleMB.getSchedule().setJob_id(job.getId());
		qrMB.setQuestionList(null);
		qrMB.setQuestionnaire(null);
		pageViewMB.setActivePage("job-invite","actions");
	}
	
	public void doInvite(){
		 try { 
			    scheduleMB.getSchedule().setCreated_by(userMB.getUser().getName());
			    scheduleMB.getSchedule().setSchedule_date(DateUtil.getCurrentDate());
			    scheduleMB.getSchedule().setStatus(AIPConstants.INVITE_STATUS.NEW.toString());
			    scheduleMB.getScheduleFacade().createSchedule(scheduleMB.getSchedule()); 
			 	updateStatus(AIPConstants.INVITE_STATUS.INVITED.toString());
	            displayInfoMessageToUser("Invited Successfully"); 
	            scheduleMB.resetSchedule();
	            pageViewMB.setActivePage("job","aip");
	        } catch (Exception e) { 
	            displayErrorMessageToUser("Oops, Try again later"); 
	            e.printStackTrace();
	            pageViewMB.setActivePage("job-invite","actions");
	        } 
		
	}

	public QuestionnaireMB getQrMB() {
		return qrMB;
	}

	public void setQrMB(QuestionnaireMB qrMB) {
		this.qrMB = qrMB;
	}

	public ScheduleMB getScheduleMB() {
		return scheduleMB;
	}

	public void setScheduleMB(ScheduleMB scheduleMB) {
		this.scheduleMB = scheduleMB;
	}

	

}
