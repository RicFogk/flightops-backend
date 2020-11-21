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

import com.Flightops.demo.dto.FlightSolicitorInfoDTO;
import com.Flightops.demo.dto.SolicitorDTO;
import com.Flightops.demo.entities.FlightSolicitorInfo;
import com.Flightops.demo.entities.Solicitor;
import com.Flightops.demo.repositories.FlightSolicitorInfoRepository;
import com.Flightops.demo.repositories.SolicitorRepository;
import com.Flightops.demo.services.exceptions.DatabaseException;
import com.Flightops.demo.services.exceptions.ResourceNotFoundException;

@Service
public class FlightSolicitorInfoService {
	
	@Autowired
	private FlightSolicitorInfoRepository repository;
	
	@Autowired
	private SolicitorRepository solicitorRepository;
	
	@Transactional(readOnly = true)
	public Page<FlightSolicitorInfoDTO> findAllPaged(PageRequest pageRequest){
		Page<FlightSolicitorInfo> list = repository.findAll(pageRequest);		
		
		return list.map(x -> new FlightSolicitorInfoDTO(x));
	
	}

	@Transactional(readOnly = true)
	public FlightSolicitorInfoDTO findById(Long id) {
		Optional<FlightSolicitorInfo> obj = repository.findById(id);
		FlightSolicitorInfo entity = obj.orElseThrow(()-> new ResourceNotFoundException("Entity not found!"));
		return new FlightSolicitorInfoDTO(entity, entity.getSolicitors());
	}

	@Transactional
	public FlightSolicitorInfoDTO insert(FlightSolicitorInfoDTO dto) {
		FlightSolicitorInfo entity = new FlightSolicitorInfo();
		copyDtotoEntity(dto, entity);
		
		// O ID nao deve ser incluido aqui // Outras entradas devem ser inseirdas aqui
		entity = repository.save(entity);
		return new FlightSolicitorInfoDTO(entity);
	}
	
	

	@Transactional
	public FlightSolicitorInfoDTO update(Long id, FlightSolicitorInfoDTO dto) {
		try {
		FlightSolicitorInfo entity = repository.getOne(id);
		copyDtotoEntity(dto, entity);
		entity = repository.save(entity);
		return new FlightSolicitorInfoDTO(entity);
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
	
	private void copyDtotoEntity(FlightSolicitorInfoDTO dto, FlightSolicitorInfo entity) {
		// TODO Auto-generated method stub
		entity.setData(dto.getData());
		entity.setFlt_number(dto.getFlt_number());
		entity.setLogbookpage(dto.getLogbookpage());
		entity.setFlighttime(dto.getFlighttime());
		entity.setFuelused(dto.getFuelused());
		entity.setFuelprice(dto.getFuelprice());
		entity.setApttax(dto.getApttax());
		entity.setNavtax(dto.getNavtax());
		entity.setTripsuport(dto.getTripsuport());
		entity.setFbohandler(dto.getFbohandler());
		entity.setCatering(dto.getCatering());
		entity.setHotel(dto.getHotel());
		entity.setEnginevalueperhourperengine(dto.getEnginevalueperhourperengine());
		entity.setPaxnumber(dto.getPaxnumber());
		entity.setTotalcost(dto.getTotalcost());
		entity.setCostperpax(dto.getCostperpax());
		entity.setCostperhour(dto.getCostperhour());
		
		entity.getSolicitors().clear();
		for(SolicitorDTO solDto : dto.getSolicitors()) {
			Solicitor solicitor = solicitorRepository.getOne(solDto.getId());
			entity.getSolicitors().add(solicitor);
		}
		
		
	}
}
