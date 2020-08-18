package com.capg.fms.airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.fms.airport.model.Airport;

@Repository
public interface IAirportRepo extends JpaRepository<Airport,String> {

	//@Query("from Airport where airportName =:airportName")
	public Airport findByAirportName(String airportName);
	
	
}
