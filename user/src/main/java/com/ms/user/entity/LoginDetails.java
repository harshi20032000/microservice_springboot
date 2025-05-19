/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ms.user.entity;

public class LoginDetails {
	private String userId;

	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the userName
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
