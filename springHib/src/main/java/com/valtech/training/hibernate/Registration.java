package com.valtech.training.hibernate;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Registration {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String usernmae;
	private String password;
	private int mobile;

	@Embedded
	private RegAddress regAddress;
	
	public Registration() {}
	
	public Registration(String usernmae, String password, int mobile, RegAddress regAddress) {
		this.usernmae = usernmae;
		this.password = password;
		this.mobile = mobile;
		this.regAddress = regAddress;
	}

	public RegAddress getRegAddress() {
		return regAddress;
	}

	public void setRegAddress(RegAddress regAddress) {
		this.regAddress = regAddress;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsernmae() {
		return usernmae;
	}

	public void setUsernmae(String usernmae) {
		this.usernmae = usernmae;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	
	
}
