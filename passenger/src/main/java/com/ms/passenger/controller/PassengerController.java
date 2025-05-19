package com.ms.passenger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.passenger.entity.Passenger;
import com.ms.passenger.service.PassengerService;

@RestController

@RequestMapping("/passenger")
public class PassengerController {
	
	@Autowired
	private PassengerService passengerService;

	/**
	 * API to create multiple passengers for a given booking.
	 *
	 * @param passengers List of Passenger objects to be persisted
	 * @return {@link ResponseEntity} with HTTP status and operation result
	 */
	@PostMapping
	public ResponseEntity<Boolean> createPassenger(@RequestBody List<Passenger> passengers) {

		passengerService.createPassenger(passengers);
		return new ResponseEntity<>(true, HttpStatus.OK);

	}

}
