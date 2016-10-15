package com.example.model;

public class SearchRabbitMQ {

	private String flightNumber;
	private String flightDate;
	private Integer newInventory;
	
	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}

	public Integer getNewInventory() {
		return newInventory;
	}

	public void setNewInventory(int newInventory) {
		this.newInventory = newInventory;
	}

	@Override
	public String toString() {
		return flightNumber +" : "+ flightDate +" : "+ newInventory;
	}
	
	
}
