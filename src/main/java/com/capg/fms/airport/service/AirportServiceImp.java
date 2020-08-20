package com.capg.fms.airport.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.capg.fms.airport.exception.AirportAlreadyExistsException;
import com.capg.fms.airport.exception.AirportNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.capg.fms.airport.model.Airport;
import com.capg.fms.airport.repository.IAirportRepo;

@Service
public class AirportServiceImp implements IAirportService {

	@Autowired(required = true)
	IAirportRepo airportRepo;

	@Override
	public List<Airport> getAllAirports() {
		return airportRepo.findAll();
	}

	@Override
	@Transactional
	public ResponseEntity<Airport> getAirportByCode(@PathVariable("airportCode") String airportCode1) {
		Optional<Airport> getAirportByCode = airportRepo.findById(airportCode1);
		if (getAirportByCode.isPresent()) {
			Airport airport = getAirportByCode.get();
			return new ResponseEntity<Airport>(airport, HttpStatus.OK);
		} else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@Override
	@Transactional
	public Airport addAirport(Airport airport) {
		System.out.println(airport);
		if (airportRepo.existsById(airport.getAirportCode())) {
			throw new AirportAlreadyExistsException("Airport already exists");
		}
		return airportRepo.save(airport);
	}

	@Override
	@Transactional
	public void deleteAirport(String airportCode) {

		//System.err.println("airport " + airportCode);

		if (!airportRepo.existsById(airportCode)) {
			throw new AirportNotFoundException("Airport with code : [" + airportCode + "] Not Found");
		}
		airportRepo.deleteById(airportCode);
	}

	@Override
	public Airport getAirportByName(String airportName) {

		return airportRepo.findByAirportName(airportName);
	}

}
