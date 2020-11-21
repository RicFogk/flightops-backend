package com.Flightops.demo.dto;

import java.io.Serializable;

import com.Flightops.demo.entities.Solicitor;

public class SolicitorDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	
	public SolicitorDTO() {
	}

	public SolicitorDTO(Long id, String name) {
		
		this.id = id;
		this.name = name;
	}
	
	public SolicitorDTO(Solicitor entity) {
		this.id = entity.getId();
		this.name = entity.getName();
	}

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
