package com.Flightops.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Flightops.demo.entities.FlightSolicitorInfo;

@Repository
public interface FlightSolicitorInfoRepository extends JpaRepository<FlightSolicitorInfo, Long> {

}
