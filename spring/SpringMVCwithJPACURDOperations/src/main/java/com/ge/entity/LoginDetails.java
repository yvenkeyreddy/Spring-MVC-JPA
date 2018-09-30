package com.ge.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "LOGIN_DETAILS")
// @NamedQuery(name = "login.find", query = "SELECT l.username,l.password FROM
// LoginDetails l where l.username=:username and l.password=:password")
public class LoginDetails {

	@Id
	@NotEmpty(message = "{usename.required}")
	@Size(min = 5, max = 10, message = "{size.required}")
	private String username;
	@NotEmpty(message = "{password.required}")
	@Size(min = 5, max = 10, message = "{size.required}")
	private String password;

//	Logger logger = null;

	public LoginDetails() {
//		logger = LoggerUtility.getLogger();
//		logger.info("LoginDetails class object created");
	}

	public LoginDetails(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
