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

import com.Flightops.demo.dto.FlightPilotInfoDTO;
import com.Flightops.demo.dto.PilotDTO;
import com.Flightops.demo.entities.FlightPilotInfo;
import com.Flightops.demo.entities.Pilot;
import com.Flightops.demo.repositories.FlightPilotInfoRepository;
import com.Flightops.demo.repositories.PilotRepository;
import com.Flightops.demo.services.exceptions.DatabaseException;
import com.Flightops.demo.services.exceptions.ResourceNotFoundException;

@Service
public class FlightPilotInfoService {
	
	@Autowired
	private FlightPilotInfoRepository repository;
	
	@Autowired
	private PilotRepository pilotrepository;
	
	@Transactional(readOnly = true)
	public Page<FlightPilotInfoDTO> findAllPaged(PageRequest pageRequest){
		Page<FlightPilotInfo> list = repository.findAll(pageRequest);		
		
		return list.map(x -> new FlightPilotInfoDTO(x));
	
	}

	@Transactional(readOnly = true)
	public FlightPilotInfoDTO findById(Long id) {
		Optional<FlightPilotInfo> obj = repository.findById(id);
		FlightPilotInfo entity = obj.orElseThrow(()-> new ResourceNotFoundException("Entity not found!"));
		return new FlightPilotInfoDTO(entity, entity.getPilots());
	}

	@Transactional
	public FlightPilotInfoDTO insert(FlightPilotInfoDTO dto) {
		FlightPilotInfo entity = new FlightPilotInfo();
		copyDtotoEntity(dto, entity);
		// O ID nao deve ser incluido aqui // Outras entradas devem ser inseirdas aqui
		entity = repository.save(entity);
		return new FlightPilotInfoDTO(entity);
	}
	
	

	@Transactional
	public FlightPilotInfoDTO update(Long id, FlightPilotInfoDTO dto) {
		try {
		FlightPilotInfo entity = repository.getOne(id);
		copyDtotoEntity(dto, entity);
		
		entity = repository.save(entity);
		return new FlightPilotInfoDTO(entity);
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
	
	private void copyDtotoEntity(FlightPilotInfoDTO dto, FlightPilotInfo entity) {
		// TODO Auto-generated method stub
		entity.setData(dto.getData());
		entity.setFlt_number(dto.getFlt_number());
		entity.setCrew1(dto.getCrew1());
		entity.setCrew2(dto.getCrew2());
		entity.setPf(dto.getPf());
		entity.setApt_from(dto.getApt_from());
		entity.setApt_to(dto.getApt_to());
		entity.setBlock_time(dto.getBlock_time());
		entity.setLand(dto.getLand());
		entity.setLogbook_page(dto.getLogbook_page());
		
		entity.getPilots().clear();
		for (PilotDTO pilDto : dto.getPilots()) {
			Pilot pilot = pilotrepository.getOne(pilDto.getId());
			entity.getPilots().add(pilot);
		}
		
	}
}
