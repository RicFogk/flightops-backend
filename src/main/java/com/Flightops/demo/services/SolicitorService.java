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

import com.Flightops.demo.dto.SolicitorDTO;
import com.Flightops.demo.entities.Solicitor;
import com.Flightops.demo.repositories.SolicitorRepository;
import com.Flightops.demo.services.exceptions.DatabaseException;
import com.Flightops.demo.services.exceptions.ResourceNotFoundException;

@Service
public class SolicitorService {
	
	@Autowired
	private SolicitorRepository repository;
	
	@Transactional(readOnly = true)
	public Page<SolicitorDTO> findAllPaged(PageRequest pageRequest){
		Page<Solicitor> list = repository.findAll(pageRequest);		
		
		return list.map(x -> new SolicitorDTO(x));
	}

	@Transactional(readOnly = true)
	public SolicitorDTO findById(Long id) {
		Optional<Solicitor> obj = repository.findById(id);
		Solicitor entity = obj.orElseThrow(()-> new ResourceNotFoundException("Entity not found!"));
		return new SolicitorDTO(entity);
	}
	
	@Transactional
	public SolicitorDTO insert(SolicitorDTO dto) {
		Solicitor entity = new Solicitor();
		entity.setName(dto.getName());
		// O ID nao deve ser incluido aqui // Outras entradas devem ser inseirdas aqui
		entity = repository.save(entity);
		return new SolicitorDTO(entity);
	}

	@Transactional
	public SolicitorDTO update(Long id,SolicitorDTO dto) {
		try {
		Solicitor entity = repository.getOne(id);
		entity.setName(dto.getName());
		entity = repository.save(entity);
		return new SolicitorDTO(entity);
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

