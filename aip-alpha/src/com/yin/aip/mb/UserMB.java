/*************************************************************************
 * CONFIDENTIAL
 * __________________
 * [2013] - Yinsol - All Rights Reserved.
 * 
 * NOTICE:  All information contained herein is, and remains
 * the property of Yinsol and its suppliers, if any.  
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Yinsol.
 */
package com.yin.aip.mb;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.yin.aip.model.User;
import com.yin.aip.security.Privelege;
import com.yin.aip.util.AIPConstants;

/**
 * @author Ram Vanga 
 * @date May 21, 2013
 * 
 */

@SessionScoped
@ManagedBean(name = "userMB")
public class UserMB implements Serializable {
	public static final String INJECTION_NAME = "#{userMB}";
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = PageViewMB.INJECTION_NAME) 
    private PageViewMB pageViewMB;
	
	
	private User user;

	/**
	 * TODO
	 * 
	 * @return
	 */
	public void logOut() {
		// send the control to home and then logout
		pageViewMB.setActivePage("job","aip");
		getRequest().getSession().invalidate();
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(AIPConstants.PAGE_LOGOUT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * TODO
	 * 
	 * @param permission
	 * @return
	 */
	public boolean isPermitted(int permission) {
		return Privelege.isPermitted(user.getRole().getPrivilege(), permission);
	}

	/**
	 * TODO
	 * 
	 * @return
	 */
	private HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}

	// Getter & Stter
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public PageViewMB getPageViewMB() {
		return pageViewMB;
	}

	public void setPageViewMB(PageViewMB pageViewMB) {
		this.pageViewMB = pageViewMB;
	}

}
