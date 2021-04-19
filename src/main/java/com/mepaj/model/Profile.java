package com.mepaj.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

@Entity
@Table(name = "profiles")
public class Profile implements Serializable {

	private static final long serialVersionUID = 8234814786673623838L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String accessLevel;

	@NotNull
	@Column(nullable = false)
	private String userName;

	@NotNull
	@Column(nullable = false)
	private String passWord;

	private Long lastAccess;

	private Boolean isActive = false;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public Long getLastAccess() {
		return lastAccess;
	}

	public void setLastAccess(Long lastAccess) {
		this.lastAccess = lastAccess;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
}
