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
package com.yin.aip.security;

import com.yin.aip.exception.DBSecurityException;

/**
 * @author Ram Vanga 
 * May 20, 2013
 * 
 */

public class Privelege implements IPrivelege {


	/**
	 * Check permission(s)
	 * @param myPermissions
	 * @param permissionToCheck
	 * @return
	 */
	public static boolean isPermitted(int myPermissions, int permissionToCheck) {

		return ((myPermissions & permissionToCheck) == permissionToCheck);
	}

	/**
	 * Public setter methods to make sure that only valid permission sets can be
	 * assigned
	 * @param myPermissions
	 * @param permissionToAdd
	 * @return
	 * @throws DBSecurityException
	 */
	public static long addPermission(long myPermissions, long permissionToAdd) throws DBSecurityException {

		return addPermissions(myPermissions, new long[] { permissionToAdd });
	}

	/**
	 * @param myPermissions
	 * @param permissionsToAdd
	 * @return
	 * @throws DBSecurityException
	 */
	public static long addPermissions(long myPermissions, long[] permissionsToAdd) throws DBSecurityException {


		for (int i = 0; i < permissionsToAdd.length; i++) {
			myPermissions |= permissionsToAdd[i];
		}

			return myPermissions;
	}

	/**
	 * TODO
	 * @param myPermissions
	 * @param permissionToDelete
	 * @return
	 * @throws DBSecurityException
	 */
	public static long deletePermission(long myPermissions, long permissionToDelete) throws DBSecurityException {

		return deletePermissions(myPermissions, new long[] { permissionToDelete });
	}

	/**
	 * @param myPermissions
	 * @param permissionsToDelete
	 * @return
	 * @throws DBSecurityException
	 */
	public static long deletePermissions(long myPermissions, long[] permissionsToDelete) throws DBSecurityException {

		for (int i = 0; i < permissionsToDelete.length; i++) {
			myPermissions &= ~permissionsToDelete[i];
		}

			return myPermissions;
	}

	/**
	 * Toggle permission(s) - off if on, on if off - RARELY USED
	 * @param myPermissions
	 * @param permissionToToggle
	 * @return
	 * @throws DBSecurityException
	 */
	public static long togglePermission(long myPermissions, long permissionToToggle) throws DBSecurityException {

		myPermissions ^= permissionToToggle;

			return myPermissions;
	}


}
