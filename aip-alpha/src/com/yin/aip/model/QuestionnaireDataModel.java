package com.yin.aip.model;
import java.util.List;  
import javax.faces.model.ListDataModel;  
import org.primefaces.model.SelectableDataModel;  
  
public class QuestionnaireDataModel extends ListDataModel<Questionnaire> implements SelectableDataModel<Questionnaire> {    
  
    public QuestionnaireDataModel() {  
    }  
  
      
    public QuestionnaireDataModel(List<Questionnaire> questionnaireList) {
    	super(questionnaireList);
    }

	@Override  
    public Questionnaire getRowData(String rowKey) {  
        //In a real app, a more efficient way like a query by rowKey should be implemented to deal with huge data  
          
        @SuppressWarnings("unchecked")
		List<Questionnaire> questionnaires = (List<Questionnaire>) getWrappedData();  
          
        for(Questionnaire questionnaire: questionnaires) {  
        	if(questionnaire.getId() == Integer.parseInt(rowKey))  
                return questionnaire;  
        }  
          
        return null;  
    }  
  
    @Override
	public Object getRowKey(Questionnaire questionnaire) {
		// TODO Auto-generated method stub
		return questionnaire.getId();
	}  
}  
    