package com.yin.aip.model;
import java.util.List;  
import javax.faces.model.ListDataModel;  
import org.primefaces.model.SelectableDataModel;  
  
public class JobsDataModel extends ListDataModel<Job> implements SelectableDataModel<Job> {    
  
    public JobsDataModel() {  
    }  
  
    public JobsDataModel(List<Job> data) {  
        super(data);  
    }  
      
    @Override  
    public Job getRowData(String rowKey) {  
        //In a real app, a more efficient way like a query by rowKey should be implemented to deal with huge data  
          
        @SuppressWarnings("unchecked")
		List<Job> jobs = (List<Job>) getWrappedData();  
          
        for(Job job : jobs) {  
        	if(job.getId() == Integer.parseInt(rowKey))  
                return job;  
        }  
          
        return null;  
    }  
  
    @Override
	public Object getRowKey(Job job) {
		// TODO Auto-generated method stub
		return job.getId();
	}  
}  
    