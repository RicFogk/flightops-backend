package com.Flightops.demo.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_aircraft")
public class Aircraft implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String tailNumber;
	private Date data;
	private String crew1;
	private String crew2;
	private String solicitor;
	private int flight_number;
	private int logBookPage;
	
	@ManyToMany(mappedBy = "aircrafts")
	private Set<FlightAircraftInfo> flightaircraftinfo = new HashSet<>();
	
	
	public Aircraft() {
	}

	public Aircraft(Long id, Date data, String crew1, String crew2, String solicitor, int flight_number, String tailNumber, int logbookPage) {
		super();
		this.id = id;
		this.data = data;
		this.crew1 = crew1;
		this.crew2 = crew2;
		this.solicitor = solicitor;
		this.flight_number = flight_number;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getCrew1() {
		return crew1;
	}

	public void setCrew1(String crew1) {
		this.crew1 = crew1;
	}

	public String getCrew2() {
		return crew2;
	}

	public void setCrew2(String crew2) {
		this.crew2 = crew2;
	}

	public String getSolicitor() {
		return solicitor;
	}

	public void setSolicitor(String solicitante) {
		this.solicitor = solicitante;
	}

	public int getFlight_number() {
		return flight_number;
	}

	public void setFlight_number(int flight_number) {
		this.flight_number = flight_number;
	}
	

	public String getTailNumber() {
		return tailNumber;
	}

	public void setTailNumber(String tailNumber) {
		this.tailNumber = tailNumber;
	}
	
	

	public int getLogBookPage() {
		return logBookPage;
	}

	public void setLogBookPage(int logBookPage) {
		this.logBookPage = logBookPage;
	}

	
	
	public Set<FlightAircraftInfo> getFlightaircraftinfo() {
		return flightaircraftinfo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aircraft other = (Aircraft) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
