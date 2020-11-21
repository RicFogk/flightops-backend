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

import com.Flightops.demo.dto.PilotDTO;
import com.Flightops.demo.entities.Pilot;
import com.Flightops.demo.repositories.PilotRepository;
import com.Flightops.demo.services.exceptions.DatabaseException;
import com.Flightops.demo.services.exceptions.ResourceNotFoundException;

@Service
public class PilotService {
	
	@Autowired
	private PilotRepository repository;
	
	@Transactional(readOnly = true)
	public Page<PilotDTO> findAllPaged(PageRequest pageRequest){
		Page<Pilot> list = repository.findAll(pageRequest);		
		
		return list.map(x -> new PilotDTO(x));
	
	}

	@Transactional(readOnly = true)
	public PilotDTO findById(Long id) {
		Optional<Pilot> obj = repository.findById(id);
		Pilot entity = obj.orElseThrow(()-> new ResourceNotFoundException("Entity not found!"));
		return new PilotDTO(entity);
	}

	@Transactional
	public PilotDTO insert(PilotDTO dto) {
		Pilot entity = new Pilot();
		entity.setName(dto.getName());
		// O ID nao deve ser incluido aqui // Outras entradas devem ser inseirdas aqui
		entity = repository.save(entity);
		return new PilotDTO(entity);
	}
	
	@Transactional
	public PilotDTO update(Long id, PilotDTO dto) {
		try {
		Pilot entity = repository.getOne(id);
		entity.setName(dto.getName());
		entity = repository.save(entity);
		return new PilotDTO(entity);
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
}
