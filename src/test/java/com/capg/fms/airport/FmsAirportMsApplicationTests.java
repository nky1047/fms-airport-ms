package com.capg.fms.airport;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.capg.fms.airport.model.Airport;

@SpringBootTest
class FmsAirportMsApplicationTests {
	
	static Logger logger = LoggerFactory.getLogger(FmsAirportMsApplication.class);
	
	RestTemplate restTemplate;
	@BeforeEach
	public void setUp() {
		restTemplate = new RestTemplate()	;
	}
	
	@Test
	public void searchAirport() {
		Airport airport = restTemplate.getForObject("http://localhost:8092/airport/view/lko234",Airport.class);
		Assertions.assertNotNull(airport);
		logger.info("Search Airport Works!!");
	}
	
	@Test
	public void addAirports() {
		Airport airport = new Airport();
		airport.setAirportCode("lko234");
		airport.setAirportLocation("Lucknow");
		airport.setAirportName("Mini LKO Airport");
		ResponseEntity<Airport> postForEntity = restTemplate.postForEntity("http://localhost:8092/airport/add/", airport, Airport.class);
		Assertions.assertNotNull(postForEntity);
		logger.info("Add Airport Works!!");
	}

	
}
