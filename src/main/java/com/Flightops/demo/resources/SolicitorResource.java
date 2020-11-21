package com.Flightops.demo.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Flightops.demo.dto.SolicitorDTO;
import com.Flightops.demo.services.SolicitorService;

@RestController
@RequestMapping(value = "/solicitors")
public class SolicitorResource {

	@Autowired
	private SolicitorService service;
	
	@GetMapping
	public ResponseEntity<Page<SolicitorDTO>> findAll(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy
			
			){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		Page<SolicitorDTO> list = service.findAllPaged(pageRequest);
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SolicitorDTO> findById(@PathVariable Long id){
		SolicitorDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
		
	}
	
	@PostMapping
	public ResponseEntity<SolicitorDTO> insert (@Valid @RequestBody SolicitorDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<SolicitorDTO> update (@PathVariable Long id, @RequestBody SolicitorDTO dto){
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<SolicitorDTO> delete (@PathVariable Long id){
		 service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
}

