package com.ms.passenger.entity;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;

public class PassengerDetails {
	@NotEmpty(message = "Passenger List cannot be empty for booking!")
	List<Passenger> passengerList;

	public List<Passenger> getPassengerList() {
		return passengerList;
	}

	public PassengerDetails() {
		super();
	}

	public PassengerDetails(List<Passenger> passengerList) {
		super();
		this.passengerList = passengerList;
	}

	public void setPassengerList(List<Passenger> passengerList) {
		this.passengerList = passengerList;
	}

	@Override
	public String toString() {
		return "PassengerDetails [passengerList=" + passengerList + "]";
	}

}
