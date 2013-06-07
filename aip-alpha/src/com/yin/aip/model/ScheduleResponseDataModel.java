package com.yin.aip.model;
import java.util.List;  
import javax.faces.model.ListDataModel;  
import org.primefaces.model.SelectableDataModel;  
  
public class ScheduleResponseDataModel extends ListDataModel<ScheduleResponse> implements SelectableDataModel<ScheduleResponse> {    
  
    public ScheduleResponseDataModel() {  
    }  
  
    public ScheduleResponseDataModel(List<ScheduleResponse> data) {  
        super(data);  
    }  
      
    @Override  
    public ScheduleResponse getRowData(String rowKey) {  
        //In a real app, a more efficient way like a query by rowKey should be implemented to deal with huge data  
          
        @SuppressWarnings("unchecked")
		List<ScheduleResponse> responses = (List<ScheduleResponse>) getWrappedData();  
          
        for(ScheduleResponse response : responses) {  
        	if(response.getId() == Integer.parseInt(rowKey))  
                return response;  
        }  
          
        return null;  
    }  
  
    @Override
	public Object getRowKey(ScheduleResponse responses) {
		// TODO Auto-generated method stub
		return responses.getId();
	}  
}  
    