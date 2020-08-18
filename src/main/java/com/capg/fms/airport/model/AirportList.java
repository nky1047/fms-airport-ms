package com.capg.fms.airport.model;

import java.util.List;

public class AirportList {

	private List<Airport> airportList;

	public List<Airport> getAirportList() {
		return airportList;
	}

	public void setAirportList(List<Airport> airportList) {
		this.airportList = airportList;
	}

	@Override
	public String toString() {
		return "AirportList [airportList=" + airportList + "]";
	}

	public AirportList(List<Airport> airportList) {
		super();
		this.airportList = airportList;
	}

	public AirportList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
