package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Flight;
import com.example.repository.FlightRepository;

@RestController
@RequestMapping(value="/datarest")
public class FlightRestController {

	@Autowired
	private FlightRepository repo;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public Iterable<Flight> listOfFlights(){
		return repo.findAll();
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Flight listOfFlights(@PathVariable Integer id){
		return repo.findOne(id);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	@ResponseStatus(code=HttpStatus.CREATED)
	public Flight createFlight(@RequestBody Flight flight){
		return repo.save(flight);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void updateFlight(@RequestBody Flight flight, @PathVariable Integer id){
		Flight flightExisting = repo.findOne(flight.getId());
		flightExisting.setDestinationName(flight.getDestinationName());
		flightExisting.setStartTime(flight.getStartTime());
		repo.save(flightExisting);
	}
	
}
