package com.Flightops.demo.dto;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;

import com.Flightops.demo.entities.FlightPilotInfo;
import com.Flightops.demo.entities.Pilot;

public class FlightPilotInfoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	@PastOrPresent (message = "Date Invalid!")
	private Date data;
	//private static SimpleDateFormat dataFormat= new SimpleDateFormat("dd/MM/yyyy");
	@NotBlank(message="Campo Requerido!")
	private Long flt_number;
	
	private String crew1;
	private String crew2;
	private String pf;
	private String apt_from;
	private String apt_to;
	
	@Temporal (TemporalType.TIME)
	private Time block_time;
	//private static SimpleDateFormat blockTimeFormat = new SimpleDateFormat("HH:mm");
	private Integer land;
	private Integer logbook_page;
	
	private List<PilotDTO> pilots = new ArrayList<>();
	
	public FlightPilotInfoDTO() {
	}

	public FlightPilotInfoDTO(Long id, Date data, Long flt_number, String crew1, String crew2, String pf,
			String apt_from, String apt_to, Time block_time, Integer land, Integer logbook_page) {
		
		this.id = id;
		this.data = data;
		this.flt_number = flt_number;
		this.crew1 = crew1;
		this.crew2 = crew2;
		this.pf = pf;
		this.apt_from = apt_from;
		this.apt_to = apt_to;
		this.block_time = block_time;
		this.land = land;
		this.logbook_page = logbook_page;
	}
	
	public FlightPilotInfoDTO(FlightPilotInfo entity) {
		
		this.id = entity.getId();
		this.data = entity.getData();
		this.flt_number = entity.getFlt_number();
		this.crew1 = entity.getCrew1();
		this.crew2 = entity.getCrew2();
		this.pf = entity.getPf();
		this.apt_from = entity.getApt_from();
		this.apt_to = entity.getApt_to();
		this.block_time = entity.getBlock_time();
		this.land = entity.getLand();
		this.logbook_page = entity.getLogbook_page();
	}
	
	public FlightPilotInfoDTO(FlightPilotInfo entity, Set<Pilot> pilots) {
		
		this(entity);
		pilots.forEach(pil -> this.pilots.add(new PilotDTO(pil)));
		
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

	public Long getFlt_number() {
		return flt_number;
	}

	public void setFlt_number(Long flt_number) {
		this.flt_number = flt_number;
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

	public String getPf() {
		return pf;
	}

	public void setPf(String pf) {
		this.pf = pf;
	}

	public String getApt_from() {
		return apt_from;
	}

	public void setApt_from(String apt_from) {
		this.apt_from = apt_from;
	}

	public String getApt_to() {
		return apt_to;
	}

	public void setApt_to(String apt_to) {
		this.apt_to = apt_to;
	}

	public Time getBlock_time() {
		return block_time;
	}

	public void setBlock_time(Time block_time) {
		this.block_time = block_time;
	}

	public Integer getLand() {
		return land;
	}

	public void setLand(Integer land) {
		this.land = land;
	}

	public Integer getLogbook_page() {
		return logbook_page;
	}

	public void setLogbook_page(Integer logbook_page) {
		this.logbook_page = logbook_page;
	}

	public List<PilotDTO> getPilots() {
		return pilots;
	}

	public void setPilots(List<PilotDTO> pilots) {
		this.pilots = pilots;
	}
	
	
	

}

