package com.Flightops.demo.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Flightops.demo.dto.RoleDTO;
import com.Flightops.demo.dto.UserDTO;
import com.Flightops.demo.dto.UserInsertDTO;
import com.Flightops.demo.dto.UserUpdateDTO;
import com.Flightops.demo.entities.Role;
import com.Flightops.demo.entities.User;
import com.Flightops.demo.repositories.RoleRepository;
import com.Flightops.demo.repositories.UserRepository;
import com.Flightops.demo.services.exceptions.DatabaseException;
import com.Flightops.demo.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RoleRepository roleRepository;
	

	@Transactional(readOnly = true)
	public Page<UserDTO> findAllPaged(PageRequest pageRequest){
		Page<User> list = repository.findAll(pageRequest);		
		
		return list.map(x -> new UserDTO(x));
	
	}

	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		Optional<User> obj = repository.findById(id);
		User entity = obj.orElseThrow(()-> new ResourceNotFoundException("Entity not found!"));
		return new UserDTO(entity);
	}

	@Transactional
	public UserDTO insert(UserInsertDTO dto) {
		User entity = new User();
		copyDtotoEntity(dto, entity);
		entity.setPassword(passwordEncoder.encode(dto.getPassword()));
		// O ID nao deve ser incluido aqui // Outras entradas devem ser inseirdas aqui
		entity = repository.save(entity);
		return new UserDTO(entity);
	}
	
	

	@Transactional
	public UserDTO update(Long id, UserUpdateDTO dto) {
		try {
		User entity = repository.getOne(id);
		copyDtotoEntity(dto, entity);
		
		entity = repository.save(entity);
		return new UserDTO(entity);
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
	
	private void copyDtotoEntity(UserDTO dto, User entity) {
		// TODO Auto-generated method stub
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setEmail(dto.getEmail());
		
		
		
		entity.getRoles().clear();
		for (RoleDTO roleDto : dto.getRoles()) {
			Role role = roleRepository.getOne(roleDto.getId());
			entity.getRoles().add(role);
		}
		
	}
}
