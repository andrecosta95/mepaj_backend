package com.mepaj.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "events")
public class Event implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Address address;

    @OneToOne
    private Theme theme;

    private Date date;

    private String description;

    @OneToMany
    private List<User> usersPresent;

    @OneToOne
    private User orator;

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

    public User getOrator() {
        return orator;
    }

    public void setOrator(User orator) {
        this.orator = orator;
    }
}
