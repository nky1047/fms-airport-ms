package com.capg.fms.airport.controller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capg.fms.airport.model.Airport;

@Repository
public interface AirportRepository  extends JpaRepository<Airport, String>{

}
