package com.mepaj.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "themes")
public class Theme implements Serializable {

	private static final long serialVersionUID = -4063406545913769268L;

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

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
}
