package com.example.service;

import com.example.dao.FlightMicroserviceDao;
import com.example.model.Flight;


public class FlightServiceImpl implements FlightService {

	
	FlightMicroserviceDao dao;
	
	@Override
	public Iterable<Flight> listOfFlights() {
		return dao.listOfFlights();
	}

}
