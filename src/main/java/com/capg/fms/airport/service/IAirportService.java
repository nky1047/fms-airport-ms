package com.capg.fms.airport.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.capg.fms.airport.model.Airport;

//Author                : Capgemini
//Created/Modified Date : 20/08/2020
//Description           : AirportServiceImp class implements services for Airport management System

public interface IAirportService {

	List<Airport> getAllAirports();
	ResponseEntity<Airport> getAirportByCode(String airportCode);
	Airport addAirport(Airport airport);
	void deleteAirport(String airportCode);
	public Airport getAirportByName(String airportName);
	
}
