package com.yin.aip.mb;


import org.primefaces.context.RequestContext;

import com.yin.aip.util.JSFMessageUtil;
  
/**
 * @author Ram Vanga
 * May 22, 2013
 *
 */
public class AbstractMB { 
    private static final String KEEP_DIALOG_OPENED = "KEEP_DIALOG_OPENED"; 
  
    /**
     * Construcor
     */
    public AbstractMB() { 
        super(); 
    } 
  
    /**
     * TODO
     * @param message
     */
    protected void displayErrorMessageToUser(String message) { 
        JSFMessageUtil messageUtil = new JSFMessageUtil(); 
        messageUtil.sendErrorMessageToUser(message); 
    } 
  
    /**
     * TODO
     * @param message
     */
    protected void displayInfoMessageToUser(String message) { 
        JSFMessageUtil messageUtil = new JSFMessageUtil(); 
        messageUtil.sendInfoMessageToUser(message); 
    } 
  
    /**
     * TODO
     */
    protected void closeDialog(){ 
        getRequestContext().addCallbackParam(KEEP_DIALOG_OPENED, false); 
    } 
  
    /**
     * TODO
     */
    protected void keepDialogOpen(){ 
        getRequestContext().addCallbackParam(KEEP_DIALOG_OPENED, true); 
    } 
  
    /**
     * TODO
     * @return
     */
    protected RequestContext getRequestContext(){ 
        return RequestContext.getCurrentInstance(); 
    } 
}