package com.Flightops.demo.dto;

import java.io.Serializable;

import com.Flightops.demo.entities.Pilot;

public class PilotDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	
	public PilotDTO() {
	}

	public PilotDTO(Long id, String name) {
		
		this.id = id;
		this.name = name;
	}
	
	public PilotDTO(Pilot entity) {
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
