package com.yin.aip.mb;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.yin.aip.facade.UserFacade;
import com.yin.aip.model.User;
import com.yin.aip.util.AIPConstants;
  
/**
 * @author Ram Vanga
 * May 22, 2013
 *
 */
@RequestScoped
@ManagedBean(name="loginMB") 
public class LoginMB extends BaseMB { 
    private static final long serialVersionUID = 1L;
	@ManagedProperty(value = UserMB.INJECTION_NAME) 
    private UserMB userMB; 
    private String email; 
    private String password; 
  
    /**
     * Loing Managed bean - login action
     * @return
     */
    public String login() { 
        UserFacade userFacade = new UserFacade(); 
  
        User user = userFacade.isValidLogin(email, password); 

        if(user != null){
            userMB.setUser(user); 
            FacesContext context = FacesContext.getCurrentInstance(); 
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest(); 
            request.getSession().setAttribute(AIPConstants.USER, user); 
            return AIPConstants.PAGE_INDEX; 
        }  	
  
        displayErrorMessageToUser("Check your email/password");//TODO move to resource bundle 
  
        return null; 
    } 
  
    public String getEmail() { 
    	return email; 
    } 
    
    public void setEmail(String email) { 
    	this.email = email; 
    } 
    
    public String getPassword() { 
    	return password; 
    } 
    
    public void setPassword(String password) { 
    	this.password = password; 
    } 
    
    public void setUserMB(UserMB userMB) { 
    	this.userMB = userMB; 
    }    
}
