package com.capg.fms.airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.fms.airport.model.Airport;

//Author                : Capgemini
//Created/Modified Date : 20/08/2020
//Description           : Airport Service interface for Airport Management system

@Repository
public interface IAirportRepo extends JpaRepository<Airport,String> {

	public Airport findByAirportName(String airportName);
	
	
}
