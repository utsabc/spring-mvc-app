package com.resource.model.impl;

import java.util.Map;

public class User {

	private String userId;
	private String userName;
	private Map entitlementMatrix;
	private String designation;
	private String email;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Map getEntitlementMatrix() {
		return entitlementMatrix;
	}
	public void setEntitlementMatrix(Map entitlementMatrix) {
		this.entitlementMatrix = entitlementMatrix;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
