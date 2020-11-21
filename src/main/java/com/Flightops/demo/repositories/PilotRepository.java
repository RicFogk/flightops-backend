package com.Flightops.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Flightops.demo.entities.Pilot;

@Repository
public interface PilotRepository extends JpaRepository<Pilot, Long> {

}
