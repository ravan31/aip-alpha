package com.yin.aip.util;


import javax.faces.application.FacesMessage; 
import javax.faces.application.FacesMessage.Severity; 
import javax.faces.context.FacesContext; 
  
/**
 * @author Ram Vanga
 * May 22, 2013
 *
 */
public class JSFMessageUtil { 
    
	/**
	 * TODO
	 * @param message
	 */
	public void sendInfoMessageToUser(String message) { 
        FacesMessage facesMessage = createMessage(FacesMessage.SEVERITY_INFO, message); 
        addMessageToJsfContext(facesMessage); 
    } 
  
    /**
     * TODO
     * @param message
     */
    public void sendErrorMessageToUser(String message) { 
        FacesMessage facesMessage = createMessage(FacesMessage.SEVERITY_WARN, message); 
        addMessageToJsfContext(facesMessage); 
    } 
  
    /**
     * TODO
     * @param severity
     * @param mensagemErro
     * @return
     */
    private FacesMessage createMessage(Severity severity, String mensagemErro) { 
        return new FacesMessage(severity, mensagemErro, mensagemErro); 
    } 
  
    /**
     * TODO
     * @param facesMessage
     */
    private void addMessageToJsfContext(FacesMessage facesMessage) { 
        FacesContext.getCurrentInstance().addMessage(null, facesMessage); 
    } 
}