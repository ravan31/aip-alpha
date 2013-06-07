package com.yin.aip.mb;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author Ram Vanga
 * @date Jun 1, 2013
 *
 */
@SessionScoped
@ManagedBean
public class PageViewMB implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String INJECTION_NAME = "#{pageViewMB}";
	private String activePage = "aip/job";
	

	public String getActivePage() {
		return activePage;
	}

	public void setActivePage(String activePage) {
		this.activePage = activePage;
	}
	
	public void setActivePage(String activePage,String module) {
		this.activePage = module+"/"+activePage;
	}
	
	public void setDefaultPage(){
		this.activePage = "aip/job";
	}
}
