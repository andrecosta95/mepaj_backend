package com.mepaj.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = -8262441316946600328L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(nullable = false)
	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	private Profile profile;

	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	private String email;

	@NotNull
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@Column(nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd'T'")
	private Date dateBirth;

	@NotNull
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Date createDateUser;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	public Date getCreateDateUser() {
		return createDateUser;
	}

	public void setCreateDateUser(Date createDateUser) {
		this.createDateUser = createDateUser;
	}
}
