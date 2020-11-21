package com.Flightops.demo.dto;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.Flightops.demo.entities.Aircraft;
import com.Flightops.demo.entities.FlightAircraftInfo;

public class FlightAircraftInfoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date data;
	private int flight_number;
	private Time flighttime;
	private Time acfttotalhours;
	private int acfttotallands;
	private Double fuelused;
	private int logbookpage;
	private Double engvalueperhourperengine;
	private Double fueluplifted;
	private String fuelupliftedlocation;
	
	@Column(columnDefinition = "TEXT")
	private String ocorrencia;
	
	private List<AircraftDTO> aircrafts = new ArrayList<>();
	
	public FlightAircraftInfoDTO () {
	}

	public FlightAircraftInfoDTO(Long id, Date data, int flight_number, Time flighttime, Time acfttotalhours,
			int acfttotallands, Double fuelused, int logbookpage, Double engvalueperhourperengine, Double fueluplifted,
			String fuelupliftedlocation, String ocorrencia) {
		super();
		this.id = id;
		this.data = data;
		this.flight_number = flight_number;
		this.flighttime = flighttime;
		this.acfttotalhours = acfttotalhours;
		this.acfttotallands = acfttotallands;
		this.fuelused = fuelused;
		this.logbookpage = logbookpage;
		this.engvalueperhourperengine = engvalueperhourperengine;
		this.fueluplifted = fueluplifted;
		this.fuelupliftedlocation = fuelupliftedlocation;
		this.ocorrencia = ocorrencia;
	}
	
	public FlightAircraftInfoDTO(FlightAircraftInfo entity) {
		super();
		this.id = entity.getId();
		this.data = entity.getData();
		this.flight_number = entity.getFlight_number();
		this.flighttime = entity.getFlightTime();
		this.acfttotalhours = entity.getAcftTotalHours();
		this.acfttotallands = entity.getAcftTotallands();
		this.fuelused = entity.getFuelUsed();
		this.logbookpage = entity.getLogbookPage();
		this.engvalueperhourperengine = entity.getEngValuePerHourPerEngine();
		this.fueluplifted = entity.getFuelUplifted();
		this.fuelupliftedlocation = entity.getFuelUpliftedLocation();
		this.ocorrencia = entity.getOcorrencia();
	}
	
	public FlightAircraftInfoDTO(FlightAircraftInfo entity, Set<Aircraft> aircrafts) {
		this(entity);
		aircrafts.forEach(acft -> this.aircrafts.add(new AircraftDTO()));
		
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

	public Time getFlighttime() {
		return flighttime;
	}

	public void setFlighttime(Time flighttime) {
		this.flighttime = flighttime;
	}

	public Time getAcfttotalhours() {
		return acfttotalhours;
	}

	public void setAcfttotalhours(Time acfttotalhours) {
		this.acfttotalhours = acfttotalhours;
	}

	public int getAcfttotallands() {
		return acfttotallands;
	}

	public void setAcfttotallands(int acfttotallands) {
		this.acfttotallands = acfttotallands;
	}

	public Double getFuelused() {
		return fuelused;
	}

	public void setFuelused(Double fuelused) {
		this.fuelused = fuelused;
	}

	public int getLogbookpage() {
		return logbookpage;
	}

	public void setLogbookpage(int logbookpage) {
		this.logbookpage = logbookpage;
	}

	public Double getEngvalueperhourperengine() {
		return engvalueperhourperengine;
	}

	public void setEngvalueperhourperengine(Double engvalueperhourperengine) {
		this.engvalueperhourperengine = engvalueperhourperengine;
	}

	public Double getFueluplifted() {
		return fueluplifted;
	}

	public void setFueluplifted(Double fueluplifted) {
		this.fueluplifted = fueluplifted;
	}

	public String getFuelupliftedlocation() {
		return fuelupliftedlocation;
	}

	public void setFuelupliftedlocation(String fuelupliftedlocation) {
		this.fuelupliftedlocation = fuelupliftedlocation;
	}

	public String getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(String ocorrencia) {
		this.ocorrencia = ocorrencia;
	}

	public List<AircraftDTO> getAircrafts() {
		return aircrafts;
	}

	public void setAircrafts(List<AircraftDTO> aircrafts) {
		this.aircrafts = aircrafts;
	}

	



	
	
	
	
	

}
