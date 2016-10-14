package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Flight;

@RestController
public class FeignFlightMSClient {

	//Implementation provided by Consul
	@Autowired
	FlightMSFeignConsumer discoveryClient;
	
	
	@RequestMapping(value="/flights", method=RequestMethod.GET)
	public Iterable<Flight> listOfFlights(){
		return discoveryClient.listOfFlights();
	}
	
	@RequestMapping(value="/flight/{id}", method=RequestMethod.GET)
	public Flight flight(@PathVariable("id") Integer id){
		return discoveryClient.listOfFlights(id);
	}
	
	
}
