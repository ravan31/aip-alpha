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
package com.yin.aip.model;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Ram Vanga
 * May 21, 2013
 *
 */

@Entity
@Table(name = "auth_users") 
@NamedQuery(name = "User.findUserByEmail", query = "select u from User u where u.email = :email") 
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L; 
	  
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private int id;

    @Column(unique = true) 
    private String email; 
    private String password; 
    private String name;
	
    @AttributeOverrides({
		@AttributeOverride(name="name",column=@Column(name="name")),
		@AttributeOverride(name="desc",column=@Column(name="desc")),
		@AttributeOverride(name="privilege",column=@Column(name="privilege"))
    })
    @MapsId
    @OneToOne
    @JoinColumn(name="role_id")
	private Role role; 
	
    
	// Setters & Getters
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	// Overrides
	@Override
    public int hashCode() { 
        return getId(); 
    } 
  
    @Override
    public boolean equals(Object obj) { 
        if (obj instanceof User) { 
            User user = (User) obj; 
            return user.getId() == id; 
        } 
  
        return false; 
    } 
    
}
