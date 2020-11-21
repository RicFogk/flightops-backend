package com.Flightops.demo.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.Flightops.demo.entities.FlightSolicitorInfo;
import com.Flightops.demo.entities.Solicitor;

public class FlightSolicitorInfoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date data;
	private Long flt_number;
	private int logbookpage;
	private String flighttime;
	private Double fuelused;
	private Double fuelprice;
	private Double apttax;
	private Double navtax;
	private Double tripsuport;
	private Double fbohandler;
	private Double catering;
	private Double hotel;
	private Double enginevalueperhourperengine;
	
	private int paxnumber;
	private Double totalcost;
	private Double costperpax;
	private Double costperhour;
	
	private List<SolicitorDTO> solicitors = new ArrayList<>();
	
	public FlightSolicitorInfoDTO() {
	}

	public FlightSolicitorInfoDTO(Long id, Date data, Long flt_number, int logbookpage, String flighttime,
			Double fuelused, Double fuelprice, Double apttax, Double navtax, Double tripsuport, Double fbohandler,
			Double catering, Double hotel, Double enginevalueperhourperengine, int paxnumber, Double totalcost,
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
	
	public FlightSolicitorInfoDTO(FlightSolicitorInfo entity) {
		super();
		this.id = entity.getId();
		this.data = entity.getData();
		this.flt_number = entity.getFlt_number();
		this.logbookpage = entity.getLogbookpage();
		this.flighttime = entity.getFlighttime();
		this.fuelused = entity.getFuelused();
		this.fuelprice = entity.getFuelprice();
		this.apttax = entity.getApttax();
		this.navtax = entity.getNavtax();
		this.tripsuport = entity.getTripsuport();
		this.fbohandler = entity.getFbohandler();
		this.catering = entity.getCatering();
		this.hotel = entity.getHotel();
		this.enginevalueperhourperengine = entity.getEnginevalueperhourperengine();
		this.paxnumber = entity.getPaxnumber();
		this.totalcost = entity.getTotalcost();
		this.costperpax = entity.getCostperpax();
		this.costperhour = entity.getCostperhour();
	}
	
	
		public FlightSolicitorInfoDTO(FlightSolicitorInfo entity, Set<Solicitor> solicitors) {
		
		this(entity);
		solicitors.forEach(sol -> this.solicitors.add(new SolicitorDTO(sol)));
		
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

		public int getLogbookpage() {
			return logbookpage;
		}

		public void setLogbookpage(int logbookpage) {
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

		public int getPaxnumber() {
			return paxnumber;
		}

		public void setPaxnumber(int paxnumber) {
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

		public List<SolicitorDTO> getSolicitors() {
			return solicitors;
		}

		public void setSolicitors(List<SolicitorDTO> solicitors) {
			this.solicitors = solicitors;
		}

		
		

}
