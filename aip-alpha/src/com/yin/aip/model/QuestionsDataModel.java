package com.yin.aip.model;
import java.util.List;  
import javax.faces.model.ListDataModel;  
import org.primefaces.model.SelectableDataModel;  
  
public class QuestionsDataModel extends ListDataModel<Question> implements SelectableDataModel<Question> {    
  
    public QuestionsDataModel() {  
    }  
  
      
    public QuestionsDataModel(List<Question> questionsList) {
    	super(questionsList);
    }

	@Override  
    public Question getRowData(String rowKey) {  
        //In a real app, a more efficient way like a query by rowKey should be implemented to deal with huge data  
          
        @SuppressWarnings("unchecked")
		List<Question> questions = (List<Question>) getWrappedData();  
          
        for(Question question: questions) {  
        	if(question.getId() == Integer.parseInt(rowKey))  
                return question;  
        }  
          
        return null;  
    }  
  
    @Override
	public Object getRowKey(Question question) {
		// TODO Auto-generated method stub
		return question.getId();
	}  
}  
    