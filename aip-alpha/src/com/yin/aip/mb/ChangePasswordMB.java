package com.yin.aip.mb;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
  
/**
 * @author Ram Vanga
 * 
 * 
 * 
 * 
 * May 22, 2013
 *
 */
@RequestScoped
@ManagedBean(name="changePasswordMB") 
@FacesValidator("confirmPasswordValidator")
public class ChangePasswordMB extends AbstractMB implements Validator { 
    @ManagedProperty(value = UserMB.INJECTION_NAME) 
    private UserMB userMB; 

	private String currentPassword; 
    private String newPassword;
    private String confirmNewPassword;
  
   
    @Override
    public void validate(FacesContext context, UIComponent component, Object value)
            throws ValidatorException
        {
            // Cast the value of the entered password to String.
    		currentPassword = (String) value;

            // Obtain the component and submitted value of the confirm password component.
            UIInput confirmComponent = (UIInput) component.getAttributes().get("confirm");
            confirmNewPassword = (String) confirmComponent.getSubmittedValue();

            // Check if they both are filled in.
            if (currentPassword == null || currentPassword.isEmpty() || confirmNewPassword == null || confirmNewPassword.isEmpty()) {
                
            	//update in data base server
            	
            }

            // Compare the password with the confirm password.
            if (!currentPassword.equals(confirmNewPassword)) {
                confirmComponent.setValid(false); 
                throw new ValidatorException(new FacesMessage("Passwords are not equal."));
            }
        }
    
    //Getters & Setters 
    
    public UserMB getUserMB() {
    	return userMB;
    }
    
    public void setUserMB(UserMB userMB) {
    	this.userMB = userMB;
    }
    
    public String getCurrentPassword() {
    	return currentPassword;
    }
    
    public void setCurrentPassword(String currentPassword) {
    	this.currentPassword = currentPassword;
    }
    
    public String getNewPassword() {
    	return newPassword;
    }
    
    public void setNewPassword(String newPassword) {
    	this.newPassword = newPassword;
    }
    
    public String getConfirmNewPassword() {
    	return confirmNewPassword;
    }
    
    public void setConfirmNewPassword(String confirmNewPassword) {
    	this.confirmNewPassword = confirmNewPassword;
    }
}
