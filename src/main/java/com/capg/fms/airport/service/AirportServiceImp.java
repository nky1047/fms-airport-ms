package com.capg.fms.airport.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.fms.airport.exception.AirportAlreadyExistsException;
import com.capg.fms.airport.exception.AirportNotFoundException;
import com.capg.fms.airport.model.Airport;
import com.capg.fms.airport.model.AirportList;
import com.capg.fms.airport.repository.IAirportRepo;

@Service
public class AirportServiceImp implements IAirportService {
	
	@Autowired(required=true)
    IAirportRepo airportRepo;

	@Override
	public AirportList getAllAirports() {
		return new AirportList(airportRepo.findAll());
	}
	
	@Override
	@Transactional
	public Airport getAirportByCode(String airportCode) {
		
		if(!airportRepo.existsById(airportCode)) {	
			System.out.println(airportCode);
			throw new AirportNotFoundException("Airport with code : ["+airportCode+"] Not Found");
        }
		return airportRepo.getOne(airportCode);
   }

	@Override
	@Transactional
	public Airport addAirport(Airport airport) {
		System.out.println(airport);
		if(airportRepo.existsById(airport.getAirportCode())) {
			throw new AirportAlreadyExistsException("Airport already exists");
		}
			return airportRepo.save(airport);
	}
	@Override
	@Transactional
	public void deleteAirport(String airportCode) {
		
		System.err.println("airport "+ airportCode);
		
		if(!airportRepo.existsById(airportCode)){
			throw new AirportNotFoundException("Airport with code : ["+airportCode+"] Not Found");
		}
		airportRepo.deleteById(airportCode);
	}

	public Airport getAirportByName(String airportName) {
		
		return  airportRepo.findByAirportName(airportName);
	}
	
}




	