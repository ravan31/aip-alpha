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
package com.yin.aip.util;

import java.util.Date;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Ram Vanga Jun 5, 2013
 * 
 */

public class JPAUtil  {


	    private static final String DB_PU = "aip_core";

	    public static final boolean DEBUG = true;

	    private static final JPAUtil singleton = new JPAUtil();

	    private EntityManagerFactory emf;

	    private JPAUtil() {}

	    public static JPAUtil getInstance() {
	        return singleton;
	    }


	    public EntityManagerFactory getEntityManagerFactory() {
	        if(emf == null) {
	            emf = Persistence.createEntityManagerFactory(DB_PU);
	        }
	        if(DEBUG) {
	            System.out.println("factory created on: " + new Date());
	        }
	        return emf;
	    }

	    public void closeEmf() {
	        if(emf.isOpen() || emf != null) {
	            emf.close();
	        }
	        emf = null;
	        if(DEBUG) {
	            System.out.println("EMF closed at: " + new Date());
	        }
	    }

}
