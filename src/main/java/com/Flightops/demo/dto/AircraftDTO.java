package com.Flightops.demo.dto;

import java.io.Serializable;

import com.Flightops.demo.entities.Pilot;

public class AircraftDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	
	public AircraftDTO() {
	}

	public AircraftDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public AircraftDTO(Pilot entity) {
		this.id = entity.getId();
		this.name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTailNumber() {
		return name;
	}

	public void setTailNumber(String name) {
		this.name = name;
	}
	
	

}
