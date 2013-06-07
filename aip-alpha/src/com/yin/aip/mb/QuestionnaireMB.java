package com.yin.aip.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;

import com.yin.aip.facade.QuestionTypesFacade;
import com.yin.aip.facade.QuestionnaireFacade;
import com.yin.aip.facade.QuestionsFacade;
import com.yin.aip.model.Question;
import com.yin.aip.model.Questionnaire;
import com.yin.aip.model.QuestionnaireDataModel;
import com.yin.aip.util.AIPConstants;
import com.yin.aip.util.DateUtil;
@ViewScoped
@ManagedBean(name="questionnaireMB")
public class QuestionnaireMB extends BaseMB  { 
	
	private static final long serialVersionUID = 1L;

	public static final String INJECTION_NAME = "#{questionnaireMB}";
	
	@ManagedProperty(value = UserMB.INJECTION_NAME) 
    private UserMB userMB;
	
	@ManagedProperty(value = PageViewMB.INJECTION_NAME) 
    private PageViewMB pageViewMB;
	
	@ManagedProperty(value = ScheduleMB.INJECTION_NAME) 
    private ScheduleMB scheduleMB;
	
	
	private Questionnaire questionnaire;
	private List<Questionnaire> questionnaireList;
	private Question question;
	
	private List<Question> questionList;
	
	private List<String> questionTypes;
	private QuestionnaireFacade questionnaireFacade;
	private QuestionsFacade questionsFacade;
	private QuestionTypesFacade questionTypesFacade;
	//private Boolean isAddQuestionDisabled = true;
	
	private boolean newActionDisabled = true;
	private boolean editActionDisabled = true;
	
	public Questionnaire getQuestionnaire(){
		if(questionnaire == null)
			questionnaire = new Questionnaire();
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire){
		this.questionnaire = questionnaire;
	}
	
	public QuestionnaireDataModel getAllQuestionnaires() { 
        questionnaire = null;
        questionList = null;
		loadQuestionnaires(); 
        return new QuestionnaireDataModel(questionnaireList); 
    }
	
	public List<Questionnaire> getQuestionnairesList() { 
		loadPublishedQuestionnaires(); 
        return questionnaireList; 
    }
	
	public List<Question> getAllQuestions() { 
        loadQuestions(); 
        return questionList; 
    }
	
	
	
	public QuestionnaireFacade getQuestionnaireFacade() { 
		if (questionnaireFacade == null) { 
			questionnaireFacade  = new QuestionnaireFacade (); 
        } 
        return questionnaireFacade; 
    } 
	
	public QuestionsFacade getQuestionsFacade() { 
		if (questionsFacade == null) { 
			questionsFacade  = new QuestionsFacade(); 
        } 
        return questionsFacade; 
    } 
	
	public QuestionTypesFacade getQuestionTypesFacade() { 
		if (questionTypesFacade == null) { 
			questionTypesFacade  = new QuestionTypesFacade(); 
        } 
        return questionTypesFacade; 
    } 

	public void questionnaireChange(){
		questionList = getQuestionsFacade().listQuestionsByQuestionaireID(scheduleMB.getSchedule().getQuestionnaire_id()); 
	}
	
	private void loadPublishedQuestionnaires() { 
		questionnaireList = getQuestionnaireFacade().listAllPublished(); 
	}
	
	private void loadQuestionnaires() { 
		questionnaireList = getQuestionnaireFacade().listAll(); 
	}
	
	private void loadQuestions() { 
		if(questionnaire != null){
			questionList = getQuestionsFacade().listQuestionsByQuestionaireID(questionnaire.getId()); 
		}
	}	
	
	private void loadQuestionTypes(){
		questionTypes = getQuestionTypesFacade().listAll();
	}
	
	public void saveQuestionnaire(){
		 try { 
			 	questionnaire.setCreated_by(userMB.getUser().getName());
			 	questionnaire.setCreated_on(DateUtil.getCurrentDate());
			 	questionnaire.setStatus(AIPConstants.QUESTIONNAIRE_STATUS.NEW.toString());
			 	getQuestionnaireFacade().createQuestionnaire(questionnaire);
			 	displayInfoMessageToUser("Created With Sucess"); 
	            pageViewMB.setActivePage("questionaire-create","actions");
	        } catch (Exception e) { 
	            displayErrorMessageToUser("Ops, we could not create. Try again later"); 
	            e.printStackTrace();
	            pageViewMB.setActivePage("questionaire-create","actions");
	        } 
		
	}
	
	public void updateQuestionnaire(){
		 try { 
			 	getQuestionnaireFacade().updateQuestionnaire(questionnaire);
			 	displayInfoMessageToUser("Updated successfully."); 
	            pageViewMB.setActivePage("questionaire-edit","actions");
	        } catch (Exception e) { 
	            displayErrorMessageToUser("Oops, Try again later"); 
	            e.printStackTrace();
	            pageViewMB.setActivePage("questionaire-edit","actions");
	        } 
		
	}
	
	public void doPublish(){
		try { 
			questionnaire.setStatus(AIPConstants.QUESTIONNAIRE_STATUS.LOCKED.toString());
			getQuestionnaireFacade().updateQuestionnaire(questionnaire);
		 	displayInfoMessageToUser("Locked Successfully"); 
            pageViewMB.setActivePage("questionaire-edit","actions");
        } catch (Exception e) { 
            displayErrorMessageToUser("Oops, Try again later"); 
            e.printStackTrace();
            pageViewMB.setActivePage("questionaire-edit","actions");
        } 
	}
	
	public void saveQuestion(){
		try{
			getQuestionsFacade().createQuestionnaire(question);
			getQuestionsFacade().addMappingWithQuestinnaire(question.getId(), questionnaire.getId());
			question = null;
			loadQuestions();
			pageViewMB.setActivePage("questionaire-edit","actions");
		} catch (Exception e) { 
            displayErrorMessageToUser("Oops. Unable to create question."); 
            e.printStackTrace();
            pageViewMB.setActivePage("questions-add","actions");
        } 
	}
	
	public void goToAddQuestion(){
			pageViewMB.setActivePage("questions-add","actions");
	}
	
	public void addQuestionToQuestionnaire() { 
        /*try { 
        	for()
            getQuestionnaireFacade().addQuestionToQuestionnaire(); addDogToPerson(dog.getId(), personWithDogs.getId()); 
            closeDialog(); 
            displayInfoMessageToUser("Added With Sucess"); 
            reloadPersonWithDogs(); 
            resetDog(); 
        } catch (Exception e) { 
            keepDialogOpen(); 
            displayErrorMessageToUser("Ops, we could not create. Try again later"); 
            e.printStackTrace(); 
        }*/ 
    }
	
	
	public void resetQuestionnaire() { 
		questionnaire = new Questionnaire(); 
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
	
	public Question getQuestion() {
		if(question == null)
			question = new Question();
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public List<String> getQuestionTypes() {
		if(questionTypes == null)
			loadQuestionTypes();
		return questionTypes;
	}

	public void setQuestionTypes(List<String> questionTypes) {
		this.questionTypes = questionTypes;
	}

	public void setQuestionTypesFacade(QuestionTypesFacade questionTypesFacade) {
		this.questionTypesFacade = questionTypesFacade;
	}
	
	public void createNewQuestionnaire(){
		questionnaire = null;
		question = null;
		questionList = null;
		newActionDisabled = true;
		editActionDisabled = true;
		pageViewMB.setActivePage("questionaire-create","actions");
	}

	public ScheduleMB getScheduleMB() {
		return scheduleMB;
	}

	public void setScheduleMB(ScheduleMB scheduleMB) {
		this.scheduleMB = scheduleMB;
	}
	
	public List<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}
	
	public void enableActions(SelectEvent event){
		newActionDisabled = false;
		editActionDisabled = false;
	}
	
	public void disableActions(SelectEvent event){
		newActionDisabled = true;
		editActionDisabled = true;
	}

	public Boolean getNewActionDisabled() {
		return newActionDisabled;
	}

	public Boolean getEditActionDisabled() {
		return editActionDisabled;
	}

	public void setNewActionDisabled(boolean newActionDisabled) {
		this.newActionDisabled = newActionDisabled;
	}

	public void setEditActionDisabled(boolean editActionDisabled) {
		this.editActionDisabled = editActionDisabled;
	}
	 
	
}
