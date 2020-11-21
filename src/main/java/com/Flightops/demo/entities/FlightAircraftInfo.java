package com.Flightops.demo.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name = "tb_aircraftinfo")
public class FlightAircraftInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date data;
	private int flight_number;
	private Time flightTime;
	private Time acftTotalHours;
	private int acftTotallands;
	private Double fuelUsed;
	private int logbookPage;
	private Double engValuePerHourPerEngine;
	private Double fuelUplifted;
	private String fuelUpliftedLocation;
	
	@Column(columnDefinition = "TEXT")
	private String ocorrencia;
	
	
	@ManyToMany
	@JoinTable(name = "TB_AIRCRAFTINFO_PERFLIGHT",
		joinColumns = @JoinColumn (name = "aircraftinfo_id"),
		inverseJoinColumns = @JoinColumn (name = "aircraft_id"))
			
	Set<Aircraft> aircrafts = new HashSet<>();

	
	public FlightAircraftInfo() {
	}


	public FlightAircraftInfo(Long id, Date data, int flight_number, Time flightTime, Time acftTotalHours,
			int acftTotallands, Double fuelUsed, int logbookPage, Double engValuePerHourPerEngine, Double fuelUplifted,
			String fuelUpliftedLocation, String ocorrencia) {
		super();
		this.id = id;
		this.data = data;
		this.flight_number = flight_number;
		this.flightTime = flightTime;
		this.acftTotalHours = acftTotalHours;
		this.acftTotallands = acftTotallands;
		this.fuelUsed = fuelUsed;
		this.logbookPage = logbookPage;
		this.engValuePerHourPerEngine = engValuePerHourPerEngine;
		this.fuelUplifted = fuelUplifted;
		this.fuelUpliftedLocation = fuelUpliftedLocation;
		this.ocorrencia = ocorrencia;
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


	public int getFlight_number() {
		return flight_number;
	}


	public void setFlight_number(int flight_number) {
		this.flight_number = flight_number;
	}


	public Time getFlightTime() {
		return flightTime;
	}


	public void setFlightTime(Time flightTime) {
		this.flightTime = flightTime;
	}


	public Time getAcftTotalHours() {
		return acftTotalHours;
	}


	public void setAcftTotalHours(Time acftTotalHours) {
		this.acftTotalHours = acftTotalHours;
	}


	public int getAcftTotallands() {
		return acftTotallands;
	}


	public void setAcftTotallands(int acftTotallands) {
		this.acftTotallands = acftTotallands;
	}


	public Double getFuelUsed() {
		return fuelUsed;
	}


	public void setFuelUsed(Double fuelUsed) {
		this.fuelUsed = fuelUsed;
	}


	public int getLogbookPage() {
		return logbookPage;
	}


	public void setLogbookPage(int logbookPage) {
		this.logbookPage = logbookPage;
	}


	public Double getEngValuePerHourPerEngine() {
		return engValuePerHourPerEngine;
	}


	public void setEngValuePerHourPerEngine(Double engValuePerHourPerEngine) {
		this.engValuePerHourPerEngine = engValuePerHourPerEngine;
	}


	public Double getFuelUplifted() {
		return fuelUplifted;
	}


	public void setFuelUplifted(Double fuelUplifted) {
		this.fuelUplifted = fuelUplifted;
	}


	public String getFuelUpliftedLocation() {
		return fuelUpliftedLocation;
	}


	public void setFuelUpliftedLocation(String fuelUpliftedLocation) {
		this.fuelUpliftedLocation = fuelUpliftedLocation;
	}


	public String getOcorrencia() {
		return ocorrencia;
	}


	public void setOcorrencia(String ocorrencia) {
		this.ocorrencia = ocorrencia;
	}

	

	public Set<Aircraft> getAircrafts() {
		return aircrafts;
	}


	public void setAircrafts(Set<Aircraft> aircrafts) {
		this.aircrafts = aircrafts;
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
		FlightAircraftInfo other = (FlightAircraftInfo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
