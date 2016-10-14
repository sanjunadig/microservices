package com.example;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.model.Flight;

@RestController
public class FlightMSConsumer {

	//Implementation provided by Consul
	@Autowired
	DiscoveryClient discoveryClient;
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public Iterable<Flight> listOfFlights(){
		//Get the service instance
		List<ServiceInstance> list = discoveryClient.getInstances("flight-microservice");
		ServiceInstance serviceInstance = list.get(0);
		if(serviceInstance != null && serviceInstance.getUri() != null){
			URI uri = serviceInstance.getUri();
			return (Iterable<Flight>)(new RestTemplate()
								.getForEntity(uri.toString().concat("/datarest"), Iterable.class).getBody());
		}
		return null;
	}
	
}
