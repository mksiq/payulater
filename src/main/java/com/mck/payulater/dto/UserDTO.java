package com.mck.payulater.dto;

import java.io.Serializable;

import com.mck.payulater.domain.User;

public class UserDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String userName;
	private String fullName;
	private String phoneNumber;
	private String email;
	
	
	public UserDTO() {
		super();
	}
	
	
	public UserDTO(User user) {
		super();
		this.id = user.getId();
		this.userName = user.getUserName();
		this.fullName = user.getFullName();
		this.phoneNumber = user.getPhoneNumber();
		this.email = user.getEmail();
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
