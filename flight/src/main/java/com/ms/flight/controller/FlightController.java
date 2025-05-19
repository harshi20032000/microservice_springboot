/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ms.flight.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ms.flight.entity.Flight;
import com.ms.flight.entity.SearchFlights;
import com.ms.flight.exception.ARSServiceException;
import com.ms.flight.service.FlightService;
import com.ms.flight.utility.MyDateEditor;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/flights")
public class FlightController {

	protected Logger logger = Logger.getLogger(FlightController.class.getName());

	@Autowired
	private FlightService flightService;

	/**
	 * Registers a custom editor to parse dates in 'yyyy-MM-dd' format.
	 */
	@InitBinder
	public void myInitBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new MyDateEditor(format));
	}

	/**
	 * Get flight details by flight ID.
	 *
	 * @param flightId ID of the flight
	 * @return Flight details
	 * @throws ARSServiceException if the flight is not found or service fails
	 */
	@GetMapping("/{flightId}")
	public Flight getFlights(@PathVariable("flightId") String flightId) throws ARSServiceException {
		System.out.println("flight id" + flightId);
		return flightService.getFlights(flightId);
	}

	/**
	 * Get all available source cities from which flights depart.
	 *
	 * @return List of source cities
	 * @throws ARSServiceException if the service fails
	 */
	@RequestMapping(value = "/sources", method = RequestMethod.GET)
	public List<String> getFlightSources() throws ARSServiceException {
		System.out.println("In get sources");
		return flightService.getSources();
	}

	/**
	 * Get all available destination cities to which flights go.
	 *
	 * @return List of destination cities
	 * @throws ARSServiceException if the service fails
	 */
	@RequestMapping(value = "/destinations", method = RequestMethod.GET)
	public List<String> getFlightDestinations() throws ARSServiceException {
		System.out.println("In get sources");
		return flightService.getDestinationss();
	}

	/**
	 * Get available flights based on source, destination, and journey date.
	 *
	 * @param source       Source city
	 * @param response     HTTP response object (optional usage)
	 * @param destination  Destination city
	 * @param journeyDate  Date of journey (yyyy-MM-dd format)
	 * @return List of matching flights
	 */
	@RequestMapping(value = "/{source}/{destination}/{journeyDate}", method = RequestMethod.GET)
	public ResponseEntity<List<SearchFlights>> getFlightDetails(@PathVariable String source,
			HttpServletResponse response, @PathVariable String destination, @PathVariable Date journeyDate) {
		List<SearchFlights> availableFlights = flightService.getFlights(source, destination, journeyDate);
		return new ResponseEntity<List<SearchFlights>>(availableFlights, HttpStatus.OK);

	}

	/**
	 * Updates the number of available seats for a specific flight after booking.
	 *
	 * @param flightId  ID of the flight
	 * @param noOfSeats Number of seats to reduce
	 * @throws ARSServiceException if the update fails
	 */
	@RequestMapping(value = "/{flightId}/{noOfSeats}")
	public void updateFlightSeat(@PathVariable String flightId, @PathVariable int noOfSeats)
			throws ARSServiceException {
		flightService.updateFlight(flightId, noOfSeats);

	}
}