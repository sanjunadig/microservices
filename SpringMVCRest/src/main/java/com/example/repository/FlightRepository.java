package com.example.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.model.Flight;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RepositoryRestResource(path="/datarest")
@Api(value="REST Data Api")
public interface FlightRepository extends MongoRepository<Flight, Integer>{
	
	@ApiOperation(value="findByDestinationName")
	public List<Flight> findByDestinationName(@Param("name") String name);
	
	/*@Query("select * from rest_flights where id = 12345")
	public List<Flight> getData();*/
}
