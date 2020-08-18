package com.capg.fms.airport.service;

import java.util.List;

import com.capg.fms.airport.model.Airport;
import com.capg.fms.airport.model.AirportList;

public interface IAirportService {
	
	AirportList getAllAirports();
	Airport getAirportByCode(String airportCode);
	Airport addAirport(Airport airport);
	void deleteAirport(String airportCode);
	public Airport getAirportByName(String airportName);
	
}
