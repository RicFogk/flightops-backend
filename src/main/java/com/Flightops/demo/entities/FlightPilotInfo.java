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


//
// PAREI NO VIDEO 1-25
//



@Entity
@Table(name = "TB_FLIGHTINFO")
public class FlightPilotInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "DATE")
	private Date data;
	//private static SimpleDateFormat dataFormat= new SimpleDateFormat("dd/MM/yyyy");
	
	@Column(name = "FLT_NUMBER")
	private Long flt_number;
	
	private String crew1;
	private String crew2;
	
	private String pf;
	
	@Column(name = "APT_FROM" )
	private String apt_from;
	
	@Column(name = "APT_TO")
	private String apt_to;
	
	@Column(name = "BLOCK_TIME")
	private Time block_time;
	//private static SimpleDateFormat blockTimeFormat = new SimpleDateFormat("HH:mm");
	
	private Integer land;
	
	
	
	//@Column(columnDefinition = "TEXT")
	//private String obs;
	@Column(name = "LOGBOOK_PAGE")
	private Integer logbook_page;
	
	
	
	
	
	
	
	
//	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
//	private Instant data_criacao;
	
	@ManyToMany
	@JoinTable(name = "TB_FLIGHTINFOPERPILOT",
		joinColumns = @JoinColumn (name = "flightinfo_id"),
		inverseJoinColumns = @JoinColumn (name = "pilot_id"))
			
	Set<Pilot> pilots = new HashSet<>();
	
	public FlightPilotInfo() {
	}


	
		//Instant data_criacao (isso vai nos argumentos logo apos perEngPerHour
	
		
		//this.data_criacao = data_criacao;





	public Long getId() {
		return id;
	}

	public FlightPilotInfo(Long id, Date data, Long flt_number, String crew1, String crew2, String pf,
				String apt_from, String apt_to, Time block_time, Integer land,
				Integer logbook_page, Set<Pilot> pilots) {
			super();
			this.id = id;
			//this.data = data;
			this.flt_number = flt_number;
			this.crew1 = crew1;
			this.crew2 = crew2;
			
			this.pf = pf;
			this.apt_from = apt_from;
			this.apt_to = apt_to;
			//this.block_time = block_time;
			this.land = land;
			
			//this.obs = obs;
			this.logbook_page = logbook_page;
			this.pilots = pilots;
		}



	public void setId(Long id) {
		this.id = id;
	}


//	}

	

	public Date getData() {
		return data;
	}



	public Integer getLand() {
		return land;
	}



	public void setLand(Integer land) {
		this.land = land;
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



	public void setPilots(Set<Pilot> pilots) {
		this.pilots = pilots;
	}






	

//	public String getObs() {
//		return obs;
//	}
//
//	public void setObs(String obs) {
//		this.obs = obs;
//	}

	public Integer getLogbook_page() {
		return logbook_page;
	}

	public void setLogbook_page(Integer logbook_page) {
		this.logbook_page = logbook_page;
	}


	public Set<Pilot> getPilots() {
		return pilots;
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
		FlightPilotInfo other = (FlightPilotInfo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	
	
	
	

}
