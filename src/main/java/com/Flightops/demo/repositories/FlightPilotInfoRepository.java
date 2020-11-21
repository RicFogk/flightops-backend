package com.Flightops.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Flightops.demo.entities.FlightPilotInfo;

@Repository
public interface FlightPilotInfoRepository extends JpaRepository<FlightPilotInfo, Long> {

}
