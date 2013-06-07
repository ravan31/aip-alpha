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

import java.util.Arrays;

import com.yin.aip.exception.DBSecurityException;

/**
 * @author Ram Vanga 
 * May 20, 2013
 * 
 */

public class CopyOfPrivelege implements IPrivelege {

	//TODO Remove this later
	public static final int[] validPermissions = { NOTHING_ALLOWED, 
													VIEW_ALLOWED, 
													VIEW_ADD_ALLOWED, 
													VIEW_EDIT_ALLOWED, 
													VIEW_ADD_EDIT_ALLOWED, 
													VIEW_DEL_ALLOWED, ALL_ALLOWED 
												};
	//Sort before binary search
	static {
		Arrays.sort(validPermissions);
	}

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
	public static int addPermission(int myPermissions, int permissionToAdd) throws DBSecurityException {

		return addPermissions(myPermissions, new int[] { permissionToAdd });
	}

	/**
	 * @param myPermissions
	 * @param permissionsToAdd
	 * @return
	 * @throws DBSecurityException
	 */
	public static int addPermissions(int myPermissions, int[] permissionsToAdd) throws DBSecurityException {


		for (int i = 0; i < permissionsToAdd.length; i++) {
			System.out.print("Add permission:" + printAsBinary(permissionsToAdd[i]));
			myPermissions |= permissionsToAdd[i];
		}

		if (Arrays.binarySearch(validPermissions, myPermissions) < 0) {
			throw new DBSecurityException("Resulting permission set will be invalid.  Aborted.");
		} else {
			System.out.print("AFTER  Permissions:" + printAsBinary(myPermissions) + "\n");
			return myPermissions;
		}
	}

	/**
	 * TODO
	 * @param myPermissions
	 * @param permissionToDelete
	 * @return
	 * @throws DBSecurityException
	 */
	public static int deletePermission(int myPermissions, int permissionToDelete) throws DBSecurityException {

		return deletePermissions(myPermissions, new int[] { permissionToDelete });
	}

	/**
	 * @param myPermissions
	 * @param permissionsToDelete
	 * @return
	 * @throws DBSecurityException
	 */
	public static int deletePermissions(int myPermissions, int[] permissionsToDelete) throws DBSecurityException {

		System.out.println("BEFORE Permissions:" + printAsBinary(myPermissions));
		for (int i = 0; i < permissionsToDelete.length; i++) {
			System.out.println("Delete  permission:" + printAsBinary(permissionsToDelete[i]));
			myPermissions &= ~permissionsToDelete[i];
		}

		if (Arrays.binarySearch(validPermissions, myPermissions) < 0) {
			throw new DBSecurityException("Resulting permission set will be invalid.  Aborted.");
		} else {
			System.out.println("AFTER  Permissions:" + printAsBinary(myPermissions) + "\n");
			return myPermissions;
		}
	}

	/**
	 * Toggle permission(s) - off if on, on if off - RARELY USED
	 * @param myPermissions
	 * @param permissionToToggle
	 * @return
	 * @throws DBSecurityException
	 */
	public static int togglePermission(int myPermissions, int permissionToToggle) throws DBSecurityException {

		myPermissions ^= permissionToToggle;

		if (Arrays.binarySearch(validPermissions, myPermissions) < 0) {
			throw new DBSecurityException("Resulting permission set will be invalid.  Aborted.");
		} else {
			return myPermissions;
		}
	}

	/**
	 * Convert an int to a string displaying int as binary - For testing only
	 * @param i
	 * @return
	 */
	private static String printAsBinary(int i) {

		System.out.println("incoming   = " + i);

		StringBuffer sb = new StringBuffer();
		if (isPermitted(i, VIEW))
			sb.append('V');
		else
			sb.append(' ');
		if (isPermitted(i, ADD))
			sb.append('A');
		else
			sb.append(' ');
		if (isPermitted(i, EDIT))
			sb.append('E');
		else
			sb.append(' ');
		if (isPermitted(i, DELETE))
			sb.append('D');
		else
			sb.append(' ');
		return sb.toString();
	}

}
