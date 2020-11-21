package com.Flightops.demo.entities;

import java.io.Serializable;
import java.sql.Date;
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
@Table(name = "TB_COSTINFO")
public class FlightSolicitorInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name = "DATA")
	private Date data;
	
	@Column (name = "FLT_NUMBER")
	private Long flt_number;
	
	@Column (name = "LOGBOOKPAGE")
	private Integer logbookpage;
	
	@Column (name = "FLIGHTTIME")
	private String flighttime;
	
	@Column (name = "FUELUSED")
	private Double fuelused;
	
	@Column (name = "FUELPRICE")
	private Double fuelprice;
	
	@Column (name = "APTTAX")
	private Double apttax;
	
	@Column (name = "NAVTAX")
	private Double navtax;
	
	@Column (name = "TRIPSUPORT")
	private Double tripsuport;
	
	@Column (name = "FBOHANDLER")
	private Double fbohandler;
	
	@Column (name = "CATERING")
	private Double catering;
	
	@Column (name = "HOTEL")
	private Double hotel;
	
	@Column (name = "ENGINEVALUEPERHOURPERENGINE")
	private Double enginevalueperhourperengine;
	
	@Column (name = "PAXNUMBER")
	private Integer paxnumber;
	
	@Column (name = "TOTALCOST")
	private Double totalcost;
	
	@Column (name = "COSTPERPAX")
	private Double costperpax;
	
	@Column (name = "COSTPERHOUR")
	private Double costperhour;
	
	
//	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
//	private Instant data_criacao;
	
	@ManyToMany
	@JoinTable(name = "TB_COSTSOLICITOR",
		joinColumns = @JoinColumn (name = "costinfo_id"),
		inverseJoinColumns = @JoinColumn (name = "solicitor_id"))
	
	Set<Solicitor> solicitors = new HashSet<>();
	
	
	
	public FlightSolicitorInfo() {
	}




		
		
		//Exemplo (depois dos teste precisa remover)
//		flightTime = "02:30";
//		
//		String[] array = new String [2];
//		array = flightTime. split(":");
//		
//		String hora = array[0];
//		String minuto = array[1];
//		
//		int hour = Integer.parseInt(hora);
//		Double minute = Double.parseDouble(minuto);
//		
//		minute = minute / 60;
//		
//		Double horaDecimal = hour + minute;
//		
//	
//		 
//		
//		totalCost = (fuelUsed * fuelPrice) + aptTax + navTax + tripSuport + fboHandler + catering + hotel + (horaDecimal * engineValuePerHourPerEngine);
//		costPerHour = totalCost / horaDecimal;
//		costPerPax = totalCost / paxNumber;
		
		//System.out.println("Tempo de voo: " + horaDecimal);
		//System.out.println(totalCost);
		
	


	public FlightSolicitorInfo(Long id, Date data, Long flt_number, Integer logbookpage, String flighttime,
			Double fuelused, Double fuelprice, Double apttax, Double navtax, Double tripsuport, Double fbohandler,
			Double catering, Double hotel, Double enginevalueperhourperengine, Integer paxnumber, Double totalcost,
			Double costperpax, Double costperhour) {
		super();
		this.id = id;
		this.data = data;
		this.flt_number = flt_number;
		this.logbookpage = logbookpage;
		this.flighttime = flighttime;
		this.fuelused = fuelused;
		this.fuelprice = fuelprice;
		this.apttax = apttax;
		this.navtax = navtax;
		this.tripsuport = tripsuport;
		this.fbohandler = fbohandler;
		this.catering = catering;
		this.hotel = hotel;
		this.enginevalueperhourperengine = enginevalueperhourperengine;
		this.paxnumber = paxnumber;
		this.totalcost = totalcost;
		this.costperpax = costperpax;
		this.costperhour = costperhour;
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






	public Integer getLogbookpage() {
		return logbookpage;
	}






	public void setLogbookpage(Integer logbookpage) {
		this.logbookpage = logbookpage;
	}






	public String getFlighttime() {
		return flighttime;
	}






	public void setFlighttime(String flighttime) {
		this.flighttime = flighttime;
	}






	public Double getFuelused() {
		return fuelused;
	}






	public void setFuelused(Double fuelused) {
		this.fuelused = fuelused;
	}






	public Double getFuelprice() {
		return fuelprice;
	}






	public void setFuelprice(Double fuelprice) {
		this.fuelprice = fuelprice;
	}






	public Double getApttax() {
		return apttax;
	}






	public void setApttax(Double apttax) {
		this.apttax = apttax;
	}






	public Double getNavtax() {
		return navtax;
	}






	public void setNavtax(Double navtax) {
		this.navtax = navtax;
	}






	public Double getTripsuport() {
		return tripsuport;
	}






	public void setTripsuport(Double tripsuport) {
		this.tripsuport = tripsuport;
	}






	public Double getFbohandler() {
		return fbohandler;
	}






	public void setFbohandler(Double fbohandler) {
		this.fbohandler = fbohandler;
	}






	public Double getCatering() {
		return catering;
	}






	public void setCatering(Double catering) {
		this.catering = catering;
	}






	public Double getHotel() {
		return hotel;
	}






	public void setHotel(Double hotel) {
		this.hotel = hotel;
	}






	public Double getEnginevalueperhourperengine() {
		return enginevalueperhourperengine;
	}






	public void setEnginevalueperhourperengine(Double enginevalueperhourperengine) {
		this.enginevalueperhourperengine = enginevalueperhourperengine;
	}






	public Integer getPaxnumber() {
		return paxnumber;
	}






	public void setPaxnumber(Integer paxnumber) {
		this.paxnumber = paxnumber;
	}






	public Double getTotalcost() {
		return totalcost;
	}






	public void setTotalcost(Double totalcost) {
		this.totalcost = totalcost;
	}






	public Double getCostperpax() {
		return costperpax;
	}






	public void setCostperpax(Double costperpax) {
		this.costperpax = costperpax;
	}






	public Double getCostperhour() {
		return costperhour;
	}






	public void setCostperhour(Double costperhour) {
		this.costperhour = costperhour;
	}






	public Set<Solicitor> getSolicitors() {
		return solicitors;
	}






	public void setSolicitors(Set<Solicitor> solicitors) {
		this.solicitors = solicitors;
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
		FlightSolicitorInfo other = (FlightSolicitorInfo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



	
	

	
	
	

}
