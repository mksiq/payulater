package com.mck.payulater.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
//	- userName : string
//	- fullNmae : string
//	- phoneNumber : string
//	- currency : enum (For later)
//	- timeZone : string (For later)
//	- wallet : String
//	- email : String
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String userName;
	private String fullName;
	private String phoneNumber;
	private String email;
	
	
	// https://stackoverflow.com/questions/1656113/hibernate-recursive-many-to-many-association-with-the-same-entity
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="TBL_FRIENDS",
		joinColumns=@JoinColumn(name="person_id"),
		inverseJoinColumns=@JoinColumn(name="friend_id")		
	)
	private List<User> friends;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "friends")
	private List<User> friendOf;
//	@JoinTable(name="FRIENDS",
//	joinColumns=@JoinColumn(name="friend_id"),
//	inverseJoinColumns=@JoinColumn(name="person_id")		
//)	
	

	
	public User() {
		super();
	}
	public User(Integer id, String userName, String fullName, String phoneNumber, String email) {
		super();
		this.id = id;
		this.userName = userName;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.email = email;
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
	
	public List<User> getFriends() {
		return friends;
	}
	public void setFriends(List<User> friends) {
		this.friends = friends;
	}
	
	public List<User> getFriendOf() {
		return friendOf;
	}
	public void setFriendOf(List<User> friendOf) {
		this.friendOf = friendOf;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [id=" + id + "\n userName=" + userName + "\n fullName=" + fullName + "\n  phoneNumber=" + phoneNumber
				+ ", email=" + email + "]";
	}
	 
	
	
}
