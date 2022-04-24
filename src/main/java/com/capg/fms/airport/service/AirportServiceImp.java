package com.capg.fms.airport.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.capg.fms.airport.controller.AirportRepository;
import com.capg.fms.airport.exception.AirportAlreadyExistsException;
import com.capg.fms.airport.exception.AirportNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.capg.fms.airport.model.Airport;
import com.capg.fms.airport.repository.IAirportRepo;

@Service
public class AirportServiceImp implements AirportService {

	@Autowired(required = true)
	IAirportRepo airportRepo;

	//	Function Name   : getAllAirports
	//	Input Parameters: None
	//  ReturnType      : Airport objects
	//	Throws          : None
	
	@Override
	public List<Airport> getAllAirports() {
		return airportRepo.findAll();
	}
	//	Function Name   : getAirportByCode
	//	Input Parameters: String airportCode
	//  ReturnType      : Airport
	//  Throws          : AirportNotFoundException		
	@Override
	@Transactional
	public ResponseEntity<Airport> getAirportByCode(@PathVariable("airportCode") String airportCode1) {
		Optional<Airport> getAirportByCode = airportRepo.findById(airportCode1);
		if (getAirportByCode.isPresent()) {
			Airport airport = getAirportByCode.get();
			return new ResponseEntity<>(airport, HttpStatus.OK);
		} 
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	//	Function Name   : addAirport
	//	Input Parameters: Airport Object
	//  ReturnType      : Airport
	//  Throws          : RUntimeException
	@Override
	@Transactional
	public Airport addAirport(Airport airport) {
		if (airportRepo.existsById(airport.getAirportCode())) {
			throw new AirportAlreadyExistsException("Airport already exists");
		}
		return airportRepo.save(airport);
	}
	
//	Function Name   : updateAirport
	@Transactional
	public ResponseEntity<Airport> updateAirport(@Valid @RequestBody Airport airport){
		Optional<Airport> findById = airportRepo.findById(airport.getAirportCode());
		try {
			if(findById.isPresent()) {
				airportRepo.save(airport);
				return new ResponseEntity<Airport>(airport , HttpStatus.OK);
			}else {
				throw new AirportNotFoundException("Sorry, Airport with provided code not in Database!!");
			}
		} catch (AirportNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
		
	
	//	Function Name   : deleteAirport
	//	Input Parameters: String airportCode
	//  ReturnType      : None
	//  Throws          : AirportNotFoundException
	@Override
	@Transactional
	public void deleteAirport(String airportCode) {
		if (!airportRepo.existsById(airportCode)) {
			throw new AirportNotFoundException("Airport with code : [" + airportCode + "] Not Found");
		}
		airportRepo.deleteById(airportCode);
	}
	//	Function Name   : getAirportByName
	//	Input Parameters: String airportName
	//  ReturnType      : Airport
	//  Throws          : None
	@Override
	public Airport getAirportByName(String airportName) {
		return airportRepo.findByAirportName(airportName);
	}
	

}
