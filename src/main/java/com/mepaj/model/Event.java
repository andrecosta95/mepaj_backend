package com.mepaj.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "events")
public class Event implements Serializable {

	private static final long serialVersionUID = -341381699340329485L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	@Column(nullable = false)
	private Theme theme;

	@Column(nullable = false)
	private Date date;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private String status;

	@OneToMany
	private List<User> usersPresent;

	@Column(nullable = false)
	private Long createdBy;

	@NotNull
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Date createDateEvent;

	private Long orator;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<User> getUsersPresent() {
		return usersPresent;
	}

	public void setUsersPresent(List<User> usersPresent) {
		this.usersPresent = usersPresent;
	}

	public Long getOrator() {
		return orator;
	}

	public void setOrator(Long orator) {
		this.orator = orator;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreateDateEvent() {
		return createDateEvent;
	}

	public void setCreateDateEvent(Date createDateEvent) {
		this.createDateEvent = createDateEvent;
	}
}
