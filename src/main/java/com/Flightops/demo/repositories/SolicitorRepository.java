package com.Flightops.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Flightops.demo.entities.Solicitor;

@Repository
public interface SolicitorRepository extends JpaRepository<Solicitor, Long> {

}
