package com.capg.fms.airport.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.capg.fms.airport.model.Airport;

public interface IAirportService {
	
	List<Airport> getAllAirports();
	ResponseEntity<Airport> getAirportByCode(String airportCode);
	Airport addAirport(Airport airport);
	void deleteAirport(String airportCode);
	public Airport getAirportByName(String airportName);
	
}
