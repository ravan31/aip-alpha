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
package com.yin.aip.filter;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.yin.aip.util.AIPConstants;

/**
 * @author Ram Vanga
 * May 19, 2013
 *
 */

public class AbstractFilter { 
	  
    /**
     * Construcor
     */
    public AbstractFilter() { 
        super(); 
    } 
  
    /**
     * TODO
     * @param request
     * @param response
     * @param req
     * @throws ServletException
     * @throws IOException
     */
    protected void doLogin(ServletRequest request, ServletResponse response, HttpServletRequest req) throws ServletException, IOException { 
        RequestDispatcher rd = req.getRequestDispatcher(AIPConstants.PAGE_LOGIN); 
        rd.forward(request, response); 
    } 
  
}
