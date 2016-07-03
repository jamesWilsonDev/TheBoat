package com.example.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class RegistrationDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	String userName;
	String password;
	String fullName;
	String givenName;
	Date dateOfBirth;

	public RegistrationDetails(String userName, String password, String fullName, String givenName, Date dateOfBirth) {
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.givenName = givenName;
		this.dateOfBirth = dateOfBirth;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
}
