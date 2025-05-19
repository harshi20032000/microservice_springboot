package com.ms.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ms.user.entity.Customer;
import com.ms.user.entity.LoginDetails;
import com.ms.user.exception.InfyGoServiceException;
import com.ms.user.service.LoginService;
import com.ms.user.service.RegistrationService;



@RestController
public class UserController {
	@Autowired
	LoginService loginService;

	@Autowired
	RegistrationService registrationService;

	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Boolean> Validate(@RequestBody LoginDetails login) throws InfyGoServiceException {
		Boolean result = false;
		result = loginService.isUserValid(login);
		return new ResponseEntity<Boolean>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<Boolean> customer(@RequestBody Customer customer) throws InfyGoServiceException {
		Boolean result = registrationService.insertUser(customer);
		return new ResponseEntity<Boolean>(result, HttpStatus.OK);
	}

}
