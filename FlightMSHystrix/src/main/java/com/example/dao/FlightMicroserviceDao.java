package com.example.dao;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.model.Flight;

@FeignClient("flight-microservice")
public interface FlightMicroserviceDao {

	@RequestMapping(value="/datarest", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Flight> listOfFlights();

	@RequestMapping(value="/datarest/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Flight listOfFlights(@PathVariable("id") Integer id);
	
	@RequestMapping(value="/datarest", method=RequestMethod.POST)
	@ResponseStatus(code=HttpStatus.CREATED)
	public Flight createFlight(@RequestBody Flight flight);
	
	@RequestMapping(value="/datarest/{id}", method=RequestMethod.PUT)
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void updateFlight(@RequestBody Flight flight, @PathVariable("id") Integer id);
	
}
