package com.Flightops.demo.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Flightops.demo.dto.AircraftDTO;
import com.Flightops.demo.dto.FlightAircraftInfoDTO;
import com.Flightops.demo.entities.Aircraft;
import com.Flightops.demo.entities.FlightAircraftInfo;
import com.Flightops.demo.repositories.AircraftRepository;
import com.Flightops.demo.repositories.FlightAircraftInfoRepository;
import com.Flightops.demo.services.exceptions.DatabaseException;
import com.Flightops.demo.services.exceptions.ResourceNotFoundException;

@Service
public class FlightAircraftInfoService {
	
	@Autowired
	private FlightAircraftInfoRepository repository;
	
	@Autowired
	private AircraftRepository aircraftRepository;
	
	@Transactional(readOnly = true)
	public Page<FlightAircraftInfoDTO> findAllPaged(PageRequest pageRequest){
		Page<FlightAircraftInfo> list = repository.findAll(pageRequest);		
		
		return list.map(x -> new FlightAircraftInfoDTO(x));
	
	}

	@Transactional(readOnly = true)
	public FlightAircraftInfoDTO findById(Long id) {
		Optional<FlightAircraftInfo> obj = repository.findById(id);
		FlightAircraftInfo entity = obj.orElseThrow(()-> new ResourceNotFoundException("Entity not found!"));
		return new FlightAircraftInfoDTO(entity, entity.getAircrafts());
	}

	@Transactional
	public FlightAircraftInfoDTO insert(FlightAircraftInfoDTO dto) {
		FlightAircraftInfo entity = new FlightAircraftInfo();
		copyDtotoEntity(dto, entity);
		// O ID nao deve ser incluido aqui // Outras entradas devem ser inseirdas aqui
		entity = repository.save(entity);
		return new FlightAircraftInfoDTO(entity);
	}
	
	

	@Transactional
	public FlightAircraftInfoDTO update(Long id, FlightAircraftInfoDTO dto) {
		try {
		FlightAircraftInfo entity = repository.getOne(id);
		copyDtotoEntity(dto, entity);
		
		entity = repository.save(entity);
		return new FlightAircraftInfoDTO(entity);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found!" + id);
		}
		
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		try {
		repository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found!" + id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity Violation!");
		}
		
	}
	
	private void copyDtotoEntity(FlightAircraftInfoDTO dto, FlightAircraftInfo entity) {
		// TODO Auto-generated method stub
		entity.setData(dto.getData());
		entity.setFlight_number(dto.getFlight_number());
		entity.setFlightTime(dto.getFlighttime());
		entity.setAcftTotalHours(dto.getAcfttotalhours());
		entity.setAcftTotallands(dto.getAcfttotallands());
		entity.setFuelUsed(dto.getFuelused());
		entity.setLogbookPage(dto.getLogbookpage());
		entity.setEngValuePerHourPerEngine(dto.getEngvalueperhourperengine());
		entity.setFuelUplifted(dto.getFueluplifted());
		entity.setFuelUpliftedLocation(dto.getFuelupliftedlocation());
		
		entity.getAircrafts().clear();
		//: dto.getAircrafts
		
		for(AircraftDTO acftDto : dto.getAircrafts() ) {
			Aircraft aircraft = aircraftRepository.getOne(acftDto.getId());
			entity.getAircrafts().add(aircraft);
			
		
			
			
		}
		
		
	}
}
