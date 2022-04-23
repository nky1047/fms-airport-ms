package com.capg.fms.airport.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capg.fms.airport.model.Airport;
import com.capg.fms.airport.service.IAirportService;

//Author                : Capgemini
//Created/Modified Date : 20/08/2020
//Description           : AirportController class for Airport Management System 

@RestController
@RequestMapping("/airport")
@CrossOrigin(value = "http://localhost:4200")
public class AirportController {
	
	private static final Logger Log = LoggerFactory.getLogger(AirportController.class);
	
	@Autowired
	IAirportService service;

	
	@GetMapping("/all")
	public List<Airport> getAllAirports(){
		Log.info("Get All Airport Accessed");
		return service.getAllAirports();
	}

	
	@RequestMapping("/view/{airportCode}")
	public ResponseEntity<Airport> getAirportByCode( @PathVariable("airportCode") String airportCode1) {
		Log.info("View Airport By Code Accessed");
		return service.getAirportByCode(airportCode1);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Airport> addAirport( @RequestBody Airport airport) {
		Log.info("Add Airport Accessed");
		service.addAirport(airport);
		return new ResponseEntity<>(airport,HttpStatus.CREATED);
	}

	@DeleteMapping("/{airportCode}")
	public void deleteAirport( @PathVariable String airportCode) {
		Log.info("Delete Airport Accessed");
		 service.deleteAirport(airportCode);
	}
	
	@GetMapping("/airportname/{airportName}")
	public Airport getAirportByName(@PathVariable String airportName) {
		Log.info("View Airport By Name Accessed");
		return service.getAirportByName(airportName);
	}

	@ExceptionHandler(Exception.class)
	public String inValid(Exception e) {
		return e.getMessage();
	}
	
}
