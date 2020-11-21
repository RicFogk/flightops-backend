package com.Flightops.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Flightops.demo.entities.FlightAircraftInfo;

@Repository
public interface FlightAircraftInfoRepository extends JpaRepository<FlightAircraftInfo, Long> {

}
